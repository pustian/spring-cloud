package tian.pusen.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by tianpusen on 2017/5/5.
 */
@RestController
public class EurekaClientController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/discovery")
    public String doDiscoveryService(){
        StringBuilder buf = new StringBuilder();
        List<String> serviceIds = discoveryClient.getServices();
        if(!CollectionUtils.isEmpty(serviceIds)){
            for(String s : serviceIds){
                System.out.println("serviceId:" + s);
                List<ServiceInstance> serviceInstances =  discoveryClient.getInstances(s);
                if(!CollectionUtils.isEmpty(serviceInstances)){
                    for(ServiceInstance si:serviceInstances){
                        buf.append("["+si.getServiceId() +" host=" +si.getHost()+" port="+si.getPort()+" uri="+si.getUri()+"]");
                    }
                }else{
                    buf.append("no service.");
                }
            }
        }
        return buf.toString();
    }

    @RequestMapping("/eureka-client-test")
    public String test(){
        return "eureka-client-test";
    }
}
