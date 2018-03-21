# Spring Cloud Config
  配置管理工具包，让你可以把配置放到远程服务器，集中化管理集群配置，前支持本地存储、Git以及Subversion。

    spring-cloud
    └── spring-cloud-config
        ├── spring-cloud-config-server
        ├── spring-cloud-config-client
        └── spring-cloud-config-repo

# 说明： 通过下面命令可以刷新配置，指的是GIT端修改后如何在客户端生效(未验证)
    curl -X POST http://localhost:8080/refresh
    curl -X POST http://localhost:8080/restart

参考: http://www.tuicool.com/articles/uyqqe27


