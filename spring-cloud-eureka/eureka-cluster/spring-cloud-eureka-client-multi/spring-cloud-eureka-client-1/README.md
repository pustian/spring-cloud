# 构建eureka client
    spring-cloud-eureka-client
    ├── pom.xml
    └── src
        ├── main
        │   ├── java
        │   │   └── tian
        │   │       └── pusen
        │   │           └── Application.java
        │   │           └── web
        │   │               └── EurekaClientController.java
        │   └── resources
        │       └── application.yml
        └── test
            └── java
# application.yml 中内容
    server:
        port: 7202
    Spring:
        application:
            name: spring-cloud-eureka-client
    eureka:
        client:
            serviceUrl:
                defaultZone: http://pustian.eureka.server0:8102/eureka/,http://pustian.eureka.server1:8202/eureka/
        registerWithEureka: true
        fetchRegistry: true
        instance:
            appname: spring-cloud-eureka-client-1
            preferIpAddress: true

# application.yml说明
    eureka.client.serviceUrl.defaultZone 配置eureka服务地址,指定注册中心的地址 
    eureka.instance.preferIpAddress表示将自己的IP地址注册到Eureka上
    eureka.instance.appname 在eureka服务器上名称



# 检查：
    启动后查看
    注册到eureka服务器 http://localhost:7202/
    本地服务状况 http://localhost:7202/discovery
