# 构建Config Server 
    spring-cloud-config-server
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
        port: 8001
    spring:
        application:
            name: spring-cloud-config-server
        cloud:
            config:
                server:
                    git:
                        uri: https://github.com/pustian/spring-cloud.git
                        searchPaths: ./spring-cloud-config/spring-cloud-config-repo

# application.yml 说明：
    spring.cloud.config.server.git.uri：配置git仓库位置
    spring.cloud.config.server.git.searchPaths：配置仓库路径下的相对搜索位置，可以配置多个
    spring.cloud.config.server.git.username：访问git仓库的用户名
    spring.cloud.config.server.git.password：访问git仓库的用户密码

# 启动测试配置服务：
    http://localhost:8001/{application}/{profile}/{label}
    {application} 匹配客户端的 “spring.application.name”
    {profile} 匹配客户端的”spring.active.profiles”
    {label} 如果是svn匹配trunk/branchs等.
    例如：http://localhost:8001/spring-cloud-config-client/default  展示的是spring-cloud-config-client.yml中的内容

# 配置文件中的内容
    spring-cloud-config-client.yml
    spring-cloud-config-client-dev.yml
    spring-cloud-config-client-test.yml
    spring-cloud-config-client-uat.yml
    spring-cloud-config-client-prod.yml
