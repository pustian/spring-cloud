package com.miscx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ApplicationContext;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * Date: 2018/2/8 13:21
 *
 * @author tianpusen
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication {
    private final static Logger logger =  LoggerFactory.getLogger(EurekaApplication.class);

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(EurekaApplication.class).run(args);
        String[] activeProfiles = applicationContext.getEnvironment().getActiveProfiles();
        for(String activeProfile: activeProfiles) {
            logger.info("Spring-boot profile:", activeProfile);
        }
        logger.info("Eureka is Done!");
    }
}
