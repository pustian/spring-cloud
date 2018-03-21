/**
 * Copyright (C), 2016-2017, 上海友米互联网科技有限公司
 */
package tian.pusen.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
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
@Service("testService")
public class TestServiceImpl implements ITestService {
    @HystrixCommand(fallbackMethod = "isHealthFallbackMethod")
    public boolean isHealth() {
        return true;
    }
    public boolean isHealthFallbackMethod() {
        return false;
    }
}
