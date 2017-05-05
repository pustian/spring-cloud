Spring Cloud Config
    配置管理工具包，让你可以把配置放到远程服务器，集中化管理集群配置，
    前支持本地存储、Git以及Subversion。

构建Config Server 见 https://github.com/pustian/spring-cloud-config-server.git
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

application.yml 中内容
server:
    port: 8001
spring:
    application:
        name: spring-cloud-config-server
    cloud:
        config:
            server:
                git:
                    uri: https://github.com/pustian/spring-cloud-config.git
                    # searchPaths: ./
                    # username:
                    # password:
# spring.cloud.config.server.git.uri：配置git仓库位置
# spring.cloud.config.server.git.searchPaths：配置仓库路径下的相对搜索位置，可以配置多个
# spring.cloud.config.server.git.username：访问git仓库的用户名
# spring.cloud.config.server.git.password：访问git仓库的用户密码

配置文件中的内容 https://github.com/pustian/spring-cloud-config.git
    spring-cloud-config-client.yml
    spring-cloud-config-client-dev.yml
    spring-cloud-config-client-test.yml
    spring-cloud-config-client-uat.yml
    spring-cloud-config-client-prod.yml

启动测试配置服务：
    启动服务
    url调用：
        http://localhost:8001/spring-cloud-config-client/default 
            展示 spring-cloud-config-client.yml中内容
        http://localhost:8001/spring-cloud-config-client/dev     
            展示 spring-cloud-config-client.yml + spring-cloud-config-client-dev.yml中内容
        http://localhost:8001/spring-cloud-config-client/test
            展示 spring-cloud-config-client.yml + spring-cloud-config-client-test.yml中内容
        http://localhost:8001/spring-cloud-config-client/uat
            展示 spring-cloud-config-client.yml + spring-cloud-config-client-uat.yml中内容
        http://localhost:8001/spring-cloud-config-client/prod
            展示 spring-cloud-config-client.yml + spring-cloud-config-client-prod.yml中内容
        


构建Config Client 见 https://github.com/pustian/spring-cloud-config-client.git
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

bootstrap.yml中内容：
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



# spring.application.name：对应前配置文件中的{application}部分
# spring.cloud.config.profile：对应前配置文件中的{profile}部分
# spring.cloud.config.label：对应前配置文件的git分支 默认为master分支
# spring.cloud.config.uri：配置中心的地址

# spring.profiles.avtive： 方便快速的切换环境。


注意：.yml文件可以换为.properties 文件
注意：上面这些属性必须配置在 bootstrap.properties 中，config部分内容才能被正确加载。
因为config的相关配置会先于 application.properties ，而 bootstrap.properties 的加载也是先于 application.properties 。 



参考：
    http://www.tuicool.com/articles/uyqqe27


