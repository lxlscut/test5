

package alipay.test1.com.MQTT;

import java.text.SimpleDateFormat;

import alipay.test1.com.entity.commodity;
import alipay.test1.com.service.service;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;
import java.io.ByteArrayOutputStream;


/**
 * 发布消息的回调类
 *
 * 必须实现MqttCallback的接口并实现对应的相关接口方法CallBack 类将实现 MqttCallBack。
 * 每个客户机标识都需要一个回调实例。在此示例中，构造函数传递客户机标识以另存为实例数据。
 * 在回调中，将它用来标识已经启动了该回调的哪个实例。
 * 必须在回调类中实现三个方法：
 *
 *  public void messageArrived(MqttTopic topic, MqttMessage message)接收已经预订的发布。
 *
 *  public void connectionLost(Throwable cause)在断开连接时调用。
 *
 *  public void deliveryComplete(MqttDeliveryToken token))
 *  接收到已经发布的 QoS 1 或 QoS 2 消息的传递令牌时调用。
 *  由 MqttClient.connect 激活此回调。
 *
 */
@Component
public class PushCallback implements MqttCallback {
    public static int StopFlag=0;//0：不操作，1：继续发送，2：停止发送
    public String Reveive="";
    public static String str="";
    public static String padid;
    public static String commoditynum;
    public static String price=null;

    @Autowired
    private service serv;

    public static PushCallback pushCallback;
    @PostConstruct
    public  void init(){
        pushCallback = this;
        pushCallback.serv = this.serv;
    }


    public void connectionLost(Throwable cause) {
        // 连接丢失后，一般在这里面进行重连
        System.out.println("连接断开，可以做重连");
    }

    //将byte数据转化为string
    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }
        char[] buffer = new char[2];
        for (int i = 0; i < src.length; i++) {
            buffer[0] = Character.forDigit((src[i] >>> 4) & 0x0F, 16);
            buffer[1] = Character.forDigit(src[i] & 0x0F, 16);
            stringBuilder.append(buffer);
        }
        return stringBuilder.toString();
    }

    public void deliveryComplete(IMqttDeliveryToken token) {
        System.out.println("deliveryComplete---------" + token.isComplete());
    }
    public void messageArrived(String  topic, MqttMessage message) throws Exception {
        SimpleDateFormat sdfs = new SimpleDateFormat("yyyyMMddHHmmss");//获取当前系统时间
        String outTradeNo = sdfs.format(System.currentTimeMillis()) ;
        String totalAmount = "0.01";
        String subject = "商品";
        String body = "哈哈";
        String format = "http://localhost:8888/alipay/pay?outTradeNo=%s&totalAmount=%s&subject=%s&body=%s";
        String url = String.format(format, outTradeNo, totalAmount, subject, body);
        try {
            byte[] messa= message.getPayload();//获取接收到的消息
            //String str=new String(message.getPayload());
            String str=bytesToHexString(messa);  //转换消息的格式
            System.out.println(str.charAt(2));
            System.out.println("接收消息主题 : " + topic);
            System.out.println("接收消息Qos: " + message.getQos());
            System.out.println("接收消息内容 : " + str);
            Thread myThread1 = new MqttThread();
            //&& str.charAt(16)=='d'
            if(str.charAt(0)=='d' && str.charAt(1)=='1') {//判断帧头帧尾
                if(str.charAt(2)=='a') {
                    padid=str.substring(3, 12);//获取pad的id
                    commoditynum=str.substring(13, 16);//获取商品的id
                    System.out.println("商品的id : " + commoditynum);

                    commodity comm = pushCallback.serv.queryid(Integer.parseInt(commoditynum));


                    System.out.println("商品的id : " + commoditynum);
                    System.out.println("商品的价格："+comm.getPrice());
                    price = String.valueOf(comm.getPrice());

                    StopFlag=1;
                    System.out.println("开始发送支付宝二维码" );
                    myThread1.start();                     // 调用start()方法使得线程进入就绪状态

                }else if(str.charAt(2)=='b') {
                    StopFlag=1;

                    System.out.println("发送微信二维码" );
                }else if(str.charAt(2)=='d') {
                    myThread1.stop();
//                    while(myThread1.interrupted());
                    System.out.println("将标志位置为true");
                    StopFlag=2;//发送清空指令

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}