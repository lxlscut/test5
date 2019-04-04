package alipay.test1.com.controller;

import alipay.test1.com.config.AlipayUtil;
import com.alipay.api.AlipayApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PayController {
    private static Logger logger = LoggerFactory.getLogger(PayController.class);

    @RequestMapping(value = "alipay/pay", produces = {MediaType.TEXT_HTML_VALUE})
    @ResponseBody
    public String pay(String outTradeNo, String totalAmount, String subject, String body) throws AlipayApiException {
        return AlipayUtil.pay(outTradeNo, totalAmount, subject, body);
    }
}
