package alipay.test1.com.Driver;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
@Component
public class RequestUtils {
    public static String baseUrl(HttpServletRequest req) {
        String url = req.getRequestURL().toString();
        int idx = url.indexOf('/', 8); // 跳过http://或者https://
        if (idx > 0) {
            url = url.substring(0, idx);
        }
        return url;
    }
}

