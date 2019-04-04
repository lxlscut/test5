package alipay.test1.com.MQTT;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.MemoryImageSource;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Title:Server 这是发送消息的服务端
 * Description: 服务器向多个客户端推送主题，即不同客户端可向服务器订阅相同主题
 * @author rao
 */
@Component
public class ServerMQTT {

    //tcp://MQTT安装的服务器地址:MQTT定义的端口号
    public static final String HOST = "tcp://139.199.208.33:1883";
    //定义一个主题
    //public static final String TOPIC = "/CC3200@PAD/1/PADDATA/UPFILE";  //发布的主题

    public static final String TOPIC = "/CLOUND/CC3200@PAD/1/QRCODE";  //发布的主题
    //定义MQTT的ID，可以在MQTT服务配置中指定
    private static final String clientid = "client110";

    private MqttClient client;
    public MqttTopic topic11;
    private String userName = "paho";  //非必须
    private String passWord = "";  //非必须

    public MqttMessage message;

    @Autowired
    private PushCallback pushCallback;

    /**
     * 构造函数
     * @throws MqttException
     */
    public ServerMQTT() throws MqttException {
        // MemoryPersistence设置clientid的保存形式，默认为以内存保存
        client = new MqttClient(HOST, clientid, new MemoryPersistence());
        connect();
    }

    /**
     *  用来连接服务器
     */
    public void connect() {
        MqttConnectOptions options = new MqttConnectOptions();
        options.setCleanSession(false);
        options.setUserName(userName);
        options.setPassword(passWord.toCharArray());
        // 设置超时时间
        options.setConnectionTimeout(10);
        // 设置会话心跳时间
        options.setKeepAliveInterval(20);
        // clean_session=0;
        try {
            client.setCallback(pushCallback);
            client.connect(options);

            topic11 = client.getTopic(TOPIC);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param topic
     * @param message
     * @throws MqttPersistenceException
     * @throws MqttException
     */
    public void publish(MqttTopic topic , MqttMessage message) throws MqttPersistenceException,
            MqttException {
        MqttDeliveryToken token = topic.publish(message);
        token.waitForCompletion();
        System.out.println("message is published completely! "
                + token.isComplete());
    }


    /**
     *  启动入口
     * @param args
     * @throws MqttException
     * @throws IOException
     */


    //MQTT发送
    public static int sendmessage(byte[] message) throws MqttException {
        ServerMQTT server = new ServerMQTT();//创建mqtt发送端
        server.connect();
        server.message = new MqttMessage();
        server.message.setQos(1);  //保证消息能到达一次
        server.message.setRetained(false);
        server.message.setPayload(message);
        server.publish(server.topic11 , server.message);
        System.out.println(server.message.isRetained() + "------ratained状态");
        server.message.clearPayload();
        return 0;
    }


    public static int messagedevi(byte[] messa, char flag) throws MqttException, InterruptedException {
        int lenth = messa.length;//总数据长度
        int datalenth=793;//每一帧的数据
        int slip1len =lenth-datalenth*(lenth/datalenth);//最后一帧数据长度
        byte[] slip =new byte[800];
        byte[] slip1 =new byte[slip1len+7];
        slip[0]=slip1[0]='#';
        slip[1]=slip1[1]='W';
        if(flag=='q') {
            slip[2]=slip1[2]='q';

        }else if(flag=='t') {
            slip[2]=slip1[2]='t';
        }else if(flag=='c') {
            slip[2]=slip1[2]='c';
        }

        slip[796]=slip1[slip1len+6]='@';
        slip[797]=slip1[slip1len+5]='#';
        slip[798]=slip1[slip1len+4]='$';
        slip[799]=slip1[slip1len+3]='%';
        for(int j=0;j<lenth/datalenth+1;j++) {
            if(PushCallback.StopFlag==1) {////0：不操作，1：继续发送，2：停止发送
                if(j!=lenth/datalenth) {//当不是最后一帧数据时
                    System.arraycopy(messa, j*datalenth, slip, 3, datalenth);//前三个保存帧头帧尾和flag，数据从第三个数据开始复制793
                    sendmessage(slip);//发送数据
                    TimeUnit.MILLISECONDS.sleep(50);
                    System.out.println("这是第"+j+"帧数据");
                }
                else if(j==lenth/datalenth) {
                    System.arraycopy(messa, j*datalenth, slip1, 3, slip1len);
                    TimeUnit.MILLISECONDS.sleep(50);
                    sendmessage(slip1);	//发送数据
                    System.out.println("这是第"+j+"帧数据");
                }
            }
            else if(PushCallback.StopFlag==2) {
                byte[] clear= {'#','W','c','l','e','a','r','%','$','#','@'};
                sendmessage(clear);	//发送数据
                PushCallback.StopFlag=0;
                messa=null;
                System.out.println("已发送停止指令");
            }
        }
        return 0;
    }

    /*将32位深图片转化为16位深图片*/
    public static byte[] image2RGB565Bmp(byte[] original) throws InterruptedException
    {
        byte[] aim=null;
        ByteArrayInputStream in = new ByteArrayInputStream(original); //将original作为输入流；
        BufferedImage sourceImg;
        try {
            sourceImg = ImageIO.read(in); //将in作为输入流，读取图片存入image中，而这里in可以为ByteArrayInputStream();
            int h = sourceImg.getHeight(), w = sourceImg.getWidth();
            int[] pixel = new int[w * h];//新建int[]用来保存图片的颜色信息；
            PixelGrabber pixelGrabber = new PixelGrabber(sourceImg, 0, 0, w, h, pixel, 0, w);//用PixelGrabber读取像素信息；
            pixelGrabber.grabPixels();
            MemoryImageSource m = new MemoryImageSource(w, h, pixel, 0, w);//MemoryImageSource缓存像素信息为Toolkit.getDefaultToolkit().createImage可以使用的格式；
            Image image = Toolkit.getDefaultToolkit().createImage(m);
            BufferedImage buffimage = new BufferedImage(w, h, BufferedImage.TYPE_USHORT_565_RGB);//新建BufferedImage来保存转换后的图片数据；
            buffimage.createGraphics().drawImage(image, 0, 0 ,null);
            // ImageIO.write(buffimage, "bmp",new File("C:\\Users\\Lenovo\\Desktop\\q\\a.bmp"));
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(buffimage, "bmp", os);//利用ImageIO类提供的write方法，将bi以png图片的数据模式写入流。
            aim=os.toByteArray();

            return aim;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return aim;
    }
}