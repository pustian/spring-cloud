package tian.pusen.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tianpusen on 2017/5/17.
 */
@RestController
@RefreshScope
public class RefreshScopeController {
    @Value("${author-name}") String authorName;
    @Value("${project.name}") String projectName;

    @RequestMapping("/refreshscope")
    public String showAutherName() {
        return "The author name is: " + authorName +" at the project "+projectName;
    }

}
