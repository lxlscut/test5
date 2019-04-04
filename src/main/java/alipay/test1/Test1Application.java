package alipay.test1;

import alipay.test1.com.MQTT.ClientMQTT;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication()
@MapperScan("alipay.test1.com.dao")
@EnableCaching
public class Test1Application implements ApplicationRunner {

    @Autowired
    private ClientMQTT clientMQTT;

    public void run(ApplicationArguments args) throws Exception{
        clientMQTT.start();
    }

    public static void main(String[] args) {
        SpringApplication.run(Test1Application.class, args);
    }

}
