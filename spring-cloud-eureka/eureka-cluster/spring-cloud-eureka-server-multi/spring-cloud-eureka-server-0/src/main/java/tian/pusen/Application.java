package tian.pusen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by tianpusen on 2017/5/5.
 */
@EnableEurekaServer
@SpringBootApplication
public class Application {
    private final static Logger logger =  LoggerFactory.getLogger(Application.class);
    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).web(true).run(args);
    }
}
