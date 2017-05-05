服务注册发现
https://github.com/pustian/spring-cloud.git

构建eureka server 
    只要在SpringBoot应用使用@EnableEurekaServe注解，就可以配置此应用为一个Eureka服务器了，用来提供服务注册/发现中心。
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
application.yml 中内容
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
                defaultZone: http://localhost:${server.port}/eureka/

# 每个Eureka Server同时也是一个Eureka Client。
# registerWithEureka、fetchRegistry表示要不要将自己注册到Eureka Server中，
# 因为目前是单机模式，所以配置false
    http://localhost:8002/

构建eureka client
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
application.yml 中内容
    server:
        port: 7002
    Spring:
        application:
            name: spring-cloud-eureka-client
    eureka:
        client:
            serviceUrl:
                defaultZone: http://localhost:8002/eureka/
        registerWithEureka: true
        fetchRegistry: true
        instance:
            preferIpAddress: true
# eureka.client.serviceUrl.defaultZone 配置eureka服务地址,指定注册中心的地址
# eureka.instance.preferIpAddress表示将自己的IP地址注册到Eureka上
启动后 查看    http://localhost:8002/  中的Instances currently registered with Eureka部分
    服务 http://localhost:7002/discovery

参考：
