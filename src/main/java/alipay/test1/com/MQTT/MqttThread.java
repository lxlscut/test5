package alipay.test1.com.MQTT;
import alipay.test1.com.Driver.PhantomJsUtil;
import alipay.test1.com.Driver.RequestUtils;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

import static alipay.test1.com.MQTT.PushCallback.*;


@Component
public class MqttThread extends Thread{


    SimpleDateFormat sdfs = new SimpleDateFormat("yyyyMMddHHmmss");//获取当前系统时间
    String outTradeNo = sdfs.format(System.currentTimeMillis()) ;
    String totalAmount;
    String subject = "商品";
    String body = "哈哈";
  //  String format = requestUtils.baseUrl(req)+"/alipay/pay?outTradeNo=%s&totalAmount=%s&subject=%s&body=%s";
    String format = "http://localhost:8888/alipay/pay?outTradeNo=%s&totalAmount=%s&subject=%s&body=%s";
 //   String url = String.format(format, outTradeNo, totalAmount, subject, body);


    @Override
    public void run() {
        ServerMQTT servermqtt;
        try {
            servermqtt = new ServerMQTT();
            String Padid= padid;//获取pad的id
            String Commoditynum= commoditynum;//获取商品的id
            totalAmount=price;
            System.out.println("商品的id : " + Commoditynum);
            System.out.println("商品的价格 : " + totalAmount);
            String url = String.format(format, outTradeNo, totalAmount, subject, body);
            byte[] PAYdata= PhantomJsUtil.getCodeBytes(url);//获取二维码数据包
            byte[] trans=servermqtt.image2RGB565Bmp(PAYdata);//将32位深图片转化为16位深
            servermqtt.messagedevi(trans,'q');//发送二维码
            System.out.println("发送支付宝二维码" );
        } catch (MqttException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }





}