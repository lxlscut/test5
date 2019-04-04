package alipay.test1.com.controller;

import alipay.test1.com.Driver.PhantomJsUtil;
import alipay.test1.com.Driver.RequestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;

@Controller
public class QrCodeController {
    @Autowired
    private RequestUtils requestUtils;

    private static Logger logger = LoggerFactory.getLogger(QrCodeController.class);

    @RequestMapping(value = "alipay/getCode", produces = {MediaType.IMAGE_PNG_VALUE})
    @ResponseBody
    public byte[] getCode(HttpServletRequest req) {
        //采用当前时间作为订单号
        SimpleDateFormat sdfs = new SimpleDateFormat("yyyyMMddHHmmss");
        String outTradeNo = sdfs.format(System.currentTimeMillis()) ;
     //   String outTradeNo = "abaabbbbcdt";
        String totalAmount = "0.01";
        String subject = "测试";
        String body = "test";
        String format = requestUtils.baseUrl(req)+"/alipay/pay?outTradeNo=%s&totalAmount=%s&subject=%s&body=%s";
//        String format = "http://localhost:8080/alipay/pay?outTradeNo=%s&totalAmount=%s&subject=%s&body=%s";
        String url = String.format(format, outTradeNo, totalAmount, subject, body);
        return PhantomJsUtil.getCodeBytes(url);
    }
}
