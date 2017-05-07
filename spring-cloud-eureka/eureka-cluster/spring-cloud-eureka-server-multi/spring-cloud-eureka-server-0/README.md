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
        port: 8202
    spring:
        application:
            name: spring-cloud-eureka-server
    eureka:
        instance:
            hostname: pustian.eureka.server1
            metadataMap:
                instanceId: ${spring.application.name}:${spring.application.instance_id:${random.value}}
        client:
            serviceUrl:
                defaultZone: http://pustian.eureka.server0:8102/eureka/

# application.yml说明

# 检查： 
    http://localhost:8202/
    http://localhost:8202/eureka/apps