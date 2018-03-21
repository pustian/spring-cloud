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
        │       ├── bootstrap.yml
        │       └── application.yml
        └── test
            └── java

# 相比与基本项目修改
    pom.xml 中增加
        <dependency>  
            <groupId>org.springframework.boot</groupId>  
            <artifactId>spring-boot-starter-security</artifactId>  
        </dependency>  
    新增bootstrap.yml 配置文件，内容如下。 也可以将这部分内容放到application.yml中
        security:
          basic:
            enabled: true
          user:
            name: pusen
            password: tian
    修改application.yml中 
        eureka.client.serviceUrl.defaultZone: http://pusen:tian@localhost:8002/eureka/ 
    defaultZong:http://username:password@localhost:8002/eureka/ 其中name, password 根据security中修改
# 检查：
    http://localhost:8002 可以查看eureka注册服务信息
    会要求输入用户名密码 security
