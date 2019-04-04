package alipay.test1.com.controller;

import alipay.test1.com.MQTT.PushCallback;
import alipay.test1.com.config.AlipayConfig;
import alipay.test1.com.entity.info;
import alipay.test1.com.service.service;
import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import alipay.test1.com.MQTT.ServerMQTT;


@Controller
@MapperScan("com.mapper")
public class notify {
//声明业务层
    @Autowired
    private service serv;


    @Autowired
    private PushCallback pushCallback;

    @Autowired
    private ServerMQTT serverMQTT;

    String tradeinfo;

    @RequestMapping("/notify")
    @ResponseBody
    public String notifyurl(HttpServletRequest request) throws AlipayApiException, IOException, MqttException, InterruptedException {
        System.out.println("1");
        Map<String,String> params = new HashMap<String,String>();
        Map<String,String[]> requestParams = request.getParameterMap();
        System.out.println("2");
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            System.out.println("3");
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
            // System.out.println("value: "+valueStr);
        }
        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名
        if(signVerified)
        {
            //商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
            System.out.println("out: "+out_trade_no);
            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
            System.out.println("no:"+trade_no);
            //交易状态
            String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");
            System.out.println("state: "+trade_status);
            //交易付款时间
            String gmt_payment=new String(request.getParameter("gmt_payment").getBytes("ISO-8859-1"),"UTF-8");
            System.out.println("time: "+gmt_payment);
            info inf = new info(out_trade_no,trade_no,trade_status,gmt_payment);
            if(trade_status.equals("TRADE_FINISHED")){
                //存储交易数据
                serv.save(inf);


            }else if (trade_status.equals("TRADE_SUCCESS")){

                // 经过验证可用
//                BufferedImage image = ImageIO.read(new File("C:\\Users\\Administrator\\Desktop\\new\\recommend.bmp"));
//                ByteArrayOutputStream out = new ByteArrayOutputStream();
//                boolean flag = ImageIO.write(image, "bmp", out);
//                byte[] b = out.toByteArray();
                System.out.println("支付成功");
//                serverMQTT.messagedevi(b,'t');
//                System.out.println("进入回调程序");
//                System.out.println("图片数组的长度位："+b.length);
                byte b[] = {'s','u','c','c','e','s','s'};
                serverMQTT.messagedevi(b,'t');
                System.out.println("支付成功");

                tradeinfo="success";
                //如果有做过处理，不执行商户的业务程序
                serv.save(inf);
                //注意：
                System.out.println("支付成功");
                //付款完成后，支付宝系统发送该交易状态通知
            }


        }
        else {//验证失败

            tradeinfo="fail";
            //调试用，写文本函数记录程序运行情况是否正常
            //String sWord = AlipaySignature.getSignCheckContentV1(params);
            //AlipayConfig.logResult(sWord);
        }
        return tradeinfo;
    }

}
