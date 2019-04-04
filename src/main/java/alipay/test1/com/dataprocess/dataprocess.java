package alipay.test1.com.dataprocess;

import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Arrays;

@Component
public class dataprocess {
    public  byte[] read(String s)
    {
        byte[] aim=null;
        try {
            FileInputStream fis = new FileInputStream(s);
            aim=new byte[fis.available()];
            fis.read(aim);
            //BufferedImage sourceImg = ImageIO.read(new File(s));
            System.out.println("读取的文件为"+Arrays.toString(aim));
            System.out.println("读取成功");
           // ByteArrayOutputStream os = new ByteArrayOutputStream();
           // ImageIO.write(sourceImg, "bmp", os);//利用ImageIO类提供的write方法，将bi以png图片的数据模式写入流。
          //  aim=os.toByteArray();
         //   System.out.println("aim Success"+aim.length);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return aim;
    }
}
