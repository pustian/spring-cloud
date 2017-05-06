# 构建eureka server 
    spring-cloud-eureka-server
    ├── pom.xml
    └── src
        ├── main
        │   ├── java
        │   │   └── tian
        │   │       └── pusen
        │   │           └── Application.java
        │   └── resources
        │       └── application.yml
        └── test
            └── java
# application.yml 中内容
    server:
        port: 8002
    spring:
        application:
            name: spring-cloud-eureka-server
    eureka:
        client:
            register-with-eureka: false
            fetch-registry: false
            serviceUrl:
                defaultZone: http://localhost:8002/eureka/
# application.yml说明
    eureka.client.serviceUrl.defaultZone 配置eureka服务地址,指定注册中心的地址 
    每个Eureka Server同时也是一个Eureka Client,下面两个表示要不要将自己注册到Eureka Server
    eureka.client.registerWithEureka=false
    eureka.client.fetchRegistry=false
    
    --------------------------------------------------------------------------------------------
    eureka.healthcheck.enabled=true
    Discovery Client不会传播当前的spring boot actuator健康检查状态。
    这就是说只要成功注册了Eureka就会一直通知应用是在“UP”状态。
    这个动作可以被改变通过使用Eureka health checks，这种发送应用状态给Eureka的行为将触发Eureka的健康检查，
    因此其他每个应用程序在其他状态下不会给应用程序发送通信然后才‘UP’。
    警告：eureka.client.healthcheck.enabled=true应该只在application.yml中被设置。
        如果设置在bootstrap.yml将会引起不可预知的影响比如注册eureka出现unknown status。
    如果你需要更多的配置关于health checks，你可能考虑实现你自己的com.netflix.appinfo.HealthCheckHandler。
    eureka.instance.metadataMap.instanceId: ${spring.application.name}:${random.value}
    instanceId 表示eureka instance 标识，需要唯一，如果不配置，多个节点最终只会有一个生效
    默认情况下一个eureka服务使用主机名称注册，那么只能一个主机一个服务。通过eureka.instance.metadataMap.instanceId你可以修改这个实例ID


# 检查： http://localhost:8002/