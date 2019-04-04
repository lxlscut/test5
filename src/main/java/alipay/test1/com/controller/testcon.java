package alipay.test1.com.controller;
import alipay.test1.com.MQTT.PushCallback;
import alipay.test1.com.dataprocess.dataprocess;
import alipay.test1.com.entity.commodity;
import alipay.test1.com.entity.info;
import alipay.test1.com.service.service;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;



/**
 * 此类为测试数据库工具，仅作测试使用
 */
@RestController
public class testcon {
    @Autowired
    private service serv;

    @Autowired
    private dataprocess datap;

    @Autowired
    private PushCallback pushCallback;

    private commodity co;
    @RequestMapping("/tes")
    @ResponseBody
    public String test() throws IOException, MqttException {
    //    byte nn[] = null;
//
//        nn = datap.read( "E:\\支付宝副本\\副本4\\test1\\src\\main\\resources\\static\\1112222.bmp");
//        System.out.println(nn.length);
//       int n =pushCallback.messagedevi(nn,'t');
//        System.out.println(Arrays.toString(nn));
//        System.out.println(n);

  // 经过验证可用
        BufferedImage image = ImageIO.read(new File("E:\\支付宝副本\\副本4\\test1\\src\\main\\resources\\static\\1112222.bmp"));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        boolean flag = ImageIO.write(image, "bmp", out);
        byte[] b = out.toByteArray();
        System.out.println(b.length);
        PushCallback push = new PushCallback();
    //    push.messagedevi(b,'t');


//		for(int i=0;i<b.length;i++) {
//			System.out.println(b[i]);}





        return "hello";
    }
}