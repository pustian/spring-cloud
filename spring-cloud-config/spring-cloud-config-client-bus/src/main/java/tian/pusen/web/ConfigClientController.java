package tian.pusen.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tianpusen on 2017/5/1.
 */
@RestController
public class ConfigClientController {
    @Value("${author-name}") String authorName;
    @Value("${project.name}") String projectName;

    @RequestMapping("/")
    public String showAutherName() {
        return "The author name is: " + authorName +" at the project "+projectName;
    }
}
