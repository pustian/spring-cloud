package tian.pusen.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by tianpusen on 2017/5/15.
 */
@RestController
public class HelloController {
    public static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public AlwaysSampler alwaysSampler(){
        return new AlwaysSampler();
    }

    @RequestMapping("/miya")
    public String miya(){
        return "I am miya!";
    }

    @RequestMapping("/callHi")
    public String callHi(){
        logger.info("service-miya callHi method");
        return restTemplate.getForObject("http://127.0.0.1:8112/hi", String.class);
    }
    // recall
    @RequestMapping("/undirectCallHi")
    public String undirectCallHi(){
        logger.info("service-miya undirectCallHi method");
        return restTemplate.getForObject("http://127.0.0.1:8112/callMiyacCallHi", String.class);
    }
}
