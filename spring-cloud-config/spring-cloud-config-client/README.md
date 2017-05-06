# 构建Config Client
    spring-cloud-config-server
    ├── pom.xml
    └── src
        ├── main
        │   ├── java
        │   │   └── tian
        │   │       └── pusen
        │   │           └── Application.java
        │   │           └── web
        │   │               └── ConfigClientTestController.java
        │   └── resources
        │       └── bootstrap.yml
        └── test
            └── java

# bootstrap.yml中内容：
    server:
        port: 7001
    spring:
        application:
            name: spring-cloud-config-client
        profiles:
            active: prod
        cloud:
            config:
                uri:  http://localhost:8001
                profile: prod
                label：master
# bootstrap.yml中的说明
    spring.application.name：对应前配置文件中的{application}部分
    spring.cloud.config.profile：对应前配置文件中的{profile}部分
    spring.cloud.config.label：对应前配置文件的git分支 默认为master分支
    spring.cloud.config.uri：配置中心的地址
    spring.profiles.avtive： 方便快速的切换环境。

# 注意：
    resources下 bootstrap.yml和appliction.yml, 
        bootstrap.yml会在应用启动之前读取
        而spring.cloud.config.uri会影响应用启动
    上面这些属性必须配置在 bootstrap.properties 中，config部分内容才能被正确加载。
    因为config的相关配置会先于 application.properties。
    而 bootstrap.properties 的加载也是先于 application.properties。
