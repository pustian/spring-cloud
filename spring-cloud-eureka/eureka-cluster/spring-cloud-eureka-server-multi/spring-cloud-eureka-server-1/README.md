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
        port: 8102
    spring:
        application:
            name: spring-cloud-eureka-server
    eureka:
        instance:
            hostname: pustian.eureka.server0
            metadataMap:
                instanceId: ${spring.application.name}:${spring.application.instance_id:${random.value}}
        client:
            serviceUrl:
                defaultZone: http://pustian.eureka.server1:8202/eureka/


# 检查：     
    http://localhost:8102/
    http://localhost:8102/eureka/apps