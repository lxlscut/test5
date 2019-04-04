package alipay.test1.com.Driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import java.util.Base64;
import java.util.concurrent.TimeUnit;

public class PhantomJsUtil {
    private static final String imgId = "copyCode";
    private static String js = "var url = document.getElementsByTagName('canvas')[0].toDataURL(); " +
            "var img = document.createElement('img'); " +
            "img.src = url;" +
            "img.id = '" + imgId + "';" +
            "document.body.appendChild(img);";
    static {
        System.setProperty("phantomjs.binary.path", "C:\\anzhuangbao\\phantomjs-2.1.1\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
    }

    /**
     * 通过url返回二维码的字节
     * @param url
     * @return
     */
    public static byte[] getCodeBytes(String url) {
        PhantomJSDriver driver = null;
        try {
            driver = new PhantomJSDriver();
            driver.get(url);
            try {
                waitPage(driver);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            driver.executeScript(js);
            WebElement img = driver.findElementById(imgId);
            String rawBase64 = img.getAttribute("src");
            String base64 = rawBase64.substring(rawBase64.indexOf(",") + 1);
            return Base64.getDecoder().decode(base64);
        } finally {
            if (driver != null) {
                driver.close();
            }
        }
    }

    private static void waitPage(PhantomJSDriver driver) throws InterruptedException {
        while (true) {
            TimeUnit.MILLISECONDS.sleep(500);
            WebElement element = driver.findElementByTagName("canvas");
            if (element != null) {
                break;
            }
        }
    }
}
