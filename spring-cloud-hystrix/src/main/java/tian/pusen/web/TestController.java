/**
 * Copyright (C), 2016-2017, 上海友米互联网科技有限公司
 */
package tian.pusen.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.Request;
import tian.pusen.service.ITestService;

/**
 * 〈一句话功能简述〉 <br>
 * 〈功能详细描述〉
 * <p>
 * Date: 2017/7/5
 *
 * @author tianpusen
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@RestController
public class TestController {
    @Autowired
    ITestService testService;
    @RequestMapping(value = "/health", method = {RequestMethod.GET, RequestMethod.POST})
    public Boolean healthService() {
        boolean bool = testService.isHealth();
        System.out.println("Health check:" + bool);
        return bool;
    }

}
