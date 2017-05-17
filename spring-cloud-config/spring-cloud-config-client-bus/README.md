# Spring Cloud Bus的更新只对三种情况有效
  @ConfigurationProperties
  @RefreshScope
  日志级别

#注意：需要启动rabbitmq或是 kafla支持，本次以ranbbitMQ为例

# 与spring-cloud-config-client 比较变动点
    1, 配置文件 bootstrap.yml 新增
    spring:
        rabbitmq:
            host: localhost
            port: 5672
            username: guest
            password: guest
    2，pom.xml 中为项目添加 spring-cloud-starter-bus-amqp 的依赖。
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-bus-amqp</artifactId>
        </dependency>
    3，代码测试
    ConfigClientController 原始的调用
    RefreshScopeController 增加@RefreshScope
    ConfigurationPropertiesController 增加@ConfigurationProperties 并且代码中不在使用Value，而是使用get/set方法

# 测试结果
执行 curl -X POST http://localhost:7001/bus/refresh
然后通过浏览器查看三个Controller中的调用 可看到 RefreshScopeController和 ConfigurationPropertiesController
跟随git库中的内容做了实时更新。

# 另外有一种方案，在 config-server中支持refresh会对所有的子应用改动做统一更新，没有验证过

