package alipay.test1.com.config;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {

    //↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2018071760713283";//正式账号


    //public static String app_id = "2016092000556750";//沙箱账号

    // 商户私钥，您的PKCS8格式RSA2私钥
    // public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCEmcrzEjt9K9jnUQIlueMgB6bKrhCiUM1BFiJvDgAxrF3jwGaaydqNFWodkmBRze4kuzmqSUaOQpkdueP90rRGKDBxhGmOnEWPV+VsC6Tf9tMrTwnBG65aFHIakPs7yV2SEJjbxW53cMlBblR5forczbWQrVnn1FxTDKAkY00ZEplQ9z5pyHRW++8enTcrUJAz8toKCELCwfbYfuDvY0V4AbSQSfuofsXGRxIMqG+BylgdBDtWxZhSiXFwC1RJgwnH65ivtT63SGWw5UF9IrWkskZ3R8TWBiQPMng3iGfZX1rdwICDfzYKmxz96iaezljiXXkYOHkNOrvkBM/M0hKBAgMBAAECggEAMdZ76RAZO9qXE5nm7LcJHqjBj7wMlHU6MBRZrNPeTs0yHL/b0KG9evlpgOPbP+Pedf/IlLAlzKJLWljb0DK5fwTr8D6MTgV+P3oRyKI3vdXPWJ/EUshMp563pDSJuNbeTF/gk/mIo2vIuMb3CRL+ri7C5zXAbNnsOWqtZf/MondGkvdd0K+MQcJHmJ9Be4vhImTzhFSfR4uHrYnm4IcblUBKTf4uu/kW9J9+OYetpHGWoDPT4OPSVjTR9l1zG1RrGMTFxwP1i2A8ByU/hrPSD9HpFCMeS8nDgNkt3+IA77rjR9LatNo1BUNxb9XEs3FB+emKj/yf+T12AxSPGOimgQKBgQDajZmCdEl7y6suHTQ99s1Vl6u0RIFi6IyRO8gWniY/pNzDgP+SnUWGTPsMqaenjTsCxGYBiyLyelRUhqmH790OGNgcTmd7UBEsl3SGlrnX3p1eWZ7pmYxGxYKCry8kw+mp9YSVlGbB1lXvLpf1i9RC7RorR+hC91g9OwcekhW41QKBgQCbUg/8j6wRDt1AxHo+2b81zlm12LtM+htMPf8pqHoshkdzcnnrZBsz24GJPgacGHxthb1cv/+Rs+HiWGKdSFwAXoLUo7e5bs4NX0SYMB+bzYX5GPW9O4+Sg6xQZdhhac+fFhDSqLRpkThjZ1D7BJ09qvqW9uaJKxzz4yo8GyTI/QKBgQDWRW+Uq+gDnDnW+0Dl41uLKClqkqN70l1GYqMYMbN0QHFEp+tp1hF8y2pzDr5Vkiyh2OXda4k2y+J0AJajtPI4SPlQPzpLdsNvwYm4Dnxj/ViyURFxG16hYDFFaPXCiOVFAXYcpKNeNYKI/lhzn8TaXNWES3qWdSQo2/9t5HGxhQKBgAVeM7E94euBAQKRB8yOR/57EDypred+KV1cMypkaTyKs4N47F/HSO1k47gzjZTtf7dlTOMcu590gRUKivX2nz9gBNOGiP3+p15s8Xj1CNKgqsWuKCgPG+orZNQugOj0+Dj+UTyGmh2f6Dv/QRw7z5dnBlwbUmJhPBHtwvLq2T2dAoGAIaKD4q0eVpoNhGLsxeFFyundGEzv+SP5WpEnTRelFnipDYeegL5JoAu9ZIGE2ofPuST00e53KN8j+Vz1/fKIUaDZ23tWzl2ILUN/pv8w347ms0sBdarAC2AzUTMh7pU+b6OUxlkQ+JBSXgmF6VDJmWU1f1POpB/HNFgOxMeozUU=";
    //正式私钥
    public static String merchant_private_key =
            "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDa3IyLKgszqxpJ\r\n" +
                    "Gy0KxarVvDMy/69ZoYNf7VWZXlwfD3EooGqpVm9K8jRqv+PvnhsDLOPUxLlJUQPU\r\n" +
                    "ik5gKI8eUxH+XzOFJXnvSya6LX5eVAA8dfyV1+ICKWZINHxXDlLKdNRvlEKJLHyk\r\n" +
                    "P3NEAFreyN1zRvA96PEzNvRgE6D5ckJtudeJFG7lahoAFi56wMNkhssU2KntywUr\r\n" +
                    "9uZ792+4X++4iKBiiLmf+gkdddZ22mVBlPhthlpQkXeFNAwAVl83No5qFXnhXnbV\r\n" +
                    "aiHbqe2mpjCU6nyWt3IRQJ5I4cSy+IKhyKLbzAFaLUXvhGM5uJZpaEPtc+V4T0Jl\r\n" +
                    "+DNOciTvAgMBAAECggEBALtwp+2H1JAruhdibvEK2YSz6iWDVWouKZW+bdEsPzla\r\n" +
                    "wE9LFA5zOF23kazbKxvNDNVrXLScxxNDj0Q4L2erVOdjvcVdQ4KE1ila84//5npi\r\n" +
                    "9tDRO8IZYjb3veGZEeR9H+rEpCvrjhBtSVJiBRX4N9sVrJNN7fMXzXtPVXvzU6pN\r\n" +
                    "2pxzNTYCeeGR/cS/GQP8VLsAlrQPvbP2ACL1uIMvYChnEO9JP589oWMQ1K1KvRlE\r\n" +
                    "k2rIsI95j31GRUnUOM/VjVmsXcAYBjDe3d5XxgU+rKj9/yaedlpQnKjuEQ9ZduhB\r\n" +
                    "5uFEGKV8l5pJB6L7SvQI5qA88g3tjlynw7mxa/fAxAECgYEA/jAWVFP1Adu+H0+b\r\n" +
                    "9e3tl3rGaQe5+ZE4boYhYeIF+vuY7ko+g0IwXqKkJiORbDYRnj0O5X3EIUzM8IQr\r\n" +
                    "POfmk8zIZlU+1uP1q4mXlocfOoLwU3ZiVc24vtDu1a7gFo4Z5uueqPTsWXGQ8R5c\r\n" +
                    "0id/wINnMEv9VvhXLDiak0aIlOcCgYEA3Gv9C+wvQyGNxSrMsa0g/0qRA4arKOaz\r\n" +
                    "C0uukcT2jJCquKUMTtt34NMSfpHUwDNZW6w9jpf+zC0ebBNO2ptvqVbmwItl7tgr\r\n" +
                    "IpaY347mtsDaKy6+UES7BQON8Xre6kS4TLyuh0kmBKE8uVK/Jbn59Fxa5lYB9TQe\r\n" +
                    "eGV1+Spx5rkCgYEAoSg90ANW8HGwrctcd2T9YTAPQaILcEZ5P+G8ooGaBxGjWVkr\r\n" +
                    "Hy9E2YtGhYPBfJkfPHM70ZaWVgKKYOd7PmdNEmIgoHjlmXr4VGSs/lv3GbLQyinh\r\n" +
                    "mMMQobJ36nSwULyRgY3bjwWSH/dXzPfSI8+1OIpXTxCus4hKRJgysLNkfvsCgYEA\r\n" +
                    "gsajPMalh9vJhDiPd78zO6QfA4uL01mE0ufVK/FDIkTWtXRfKA44QrCYYXXeVyZg\r\n" +
                    "Fu7LGuX9K2B9kzulZjggeMTxZT2PfbTNatkU3FapdbZX+pTiHzeYCjKArcvro+yf\r\n" +
                    "uA+eMO/qWYbcQ0vf0t9TeHKvD8fpo3SHu4DfDLTtHSkCgYAYpI3vs2uenya22vhy\r\n" +
                    "uns1r/HnoKYk3HQipE/uguJvuunND1daa7XPXt3l6rMaCB5ntdL02xclLGR/Krmz\r\n" +
                    "5qWft1wB08/0+7grf6JzTKaKAg/04ZG1YvugYiJjG0MCcBqHGXYWLwgtfs4iKqey\r\n" +
                    "SRJ5s9+VC45jVto3IqwL4q4lAw==";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    //public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqnolb2i5AwAkJP/h1ztVzqscv63EpHgH8O8jQO3w6MJxyAkQnC9+mXoHxpNYtTuYQUECrlMzNv7SIGBf9BHHyWwWu7ebkvIuYD1z6ZPhVfkIxWp/sP4LgupeSV1QcvNLOqXlZuGN7Nbwud1+LgIgy/Cr0V4ZA1Fh4pRpk2iFVm47dCgSTk1/oLcT6OVW1LU0lmv7PI66r0GhxDdFg+S0irbcqX1NfLbVslNc+7ec87FHIgl1G+wnVzPDw568yOl/SWxgNVLEnWRpVkAAHcMX3q/EwZSwklL1kvQSV/9DSrJ5zfRegdv2aC3Bq1mMfkGYV1f32eBEUnHpsQ4DDLIw+QIDAQAB";
    //正式私钥
    public static String alipay_public_key="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgY/33qw6xfQZ/3pZrI+E2G4qr3B1a9J+QFvx1V58Swj0Cf/XF7mvYdfrs6GUUBHbVGsP9ty0dycUmmtrpBA824yVn2fP3vu3j5IP9SCJJtcQJm5dA4WyKD2qPaif0jj5keuhlRIUuRv0XHh42+Ig7cTFMNeFj9uKz9KfpQs5zsWcPID3SIvZ4Z1KGSFdmMA6xjEB59n7OuTmtdsU0EXRWOVZVv75rqi3djJrA52a1Q4RVOdi4CRENefInzpIF/5tSi4m7/k3KJic6a4W3u4Lx6xKyR96GWbKDlWM9lVO6GyUH1/IGXQODIzM6nWN7A+jz8zpum/VbZf185FF48wy3QIDAQAB";
    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问       服务器后台通知,这个页面是程序后台运行的(买家和卖家都看不到),买家付完款后,支付宝会调用notify_url这个页面所在的页面并把相应的参数传递到这个页面,这个页面根据支付宝传递过来的参数修改网站订单的状态,更新完订单后需要在页面上打印出一个success给支付宝,如果反馈给支付宝的不是success,支付宝会继续调用这个页面
    public static String notify_url = "http://119.29.3.201:8888/notify";//"http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";
    //云服务器的地址为119.29.4.158

    // public static String notify_url = "http://localhost:8080/notify";
    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问     买家付款成功后,如果接口中指定有return_url ,买家付完款后会跳到 return_url所在的页面,这个页面可以展示给客户看,这个页面只有付款成功才会跳转
    public static String return_url = "http://localhost:8888/return_url.jsp";//"http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


    //↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
