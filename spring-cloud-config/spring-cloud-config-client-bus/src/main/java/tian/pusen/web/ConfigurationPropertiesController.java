package tian.pusen.web;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tianpusen on 2017/5/17.
 */
@RestController
@ConfigurationProperties
public class ConfigurationPropertiesController {
    private String authorName;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @RequestMapping("/configurationProperties")
    public String showAutherName() {
        return "The author name is: " + authorName ;
    }

}
