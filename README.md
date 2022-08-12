
# 项目介绍
<p>此项目是基于SpringBoot、Mybatis-Plus、Redis的轻量级Restful项目，附代码生成器，开箱即用，持续更新中，如果觉得好用请给个Star⭐️</p>
传送门：

* 地址: [项目 陆续完善中](https://github.com/huchuansai/spring-boot-restful-starter)

## 系统说明

- 基于 Spring Boot 2.4.2、Mybatis-Plus、符合Restful风格规范的轻量级 **后台脚手架项目**
- 基于knife4j生成接口文档，页面美观，方便操作
- 提供数据库迁移工具：Flyway的使用实践
- 提供跟项目配套的代码生成工具，Author is songlianquan
- 提供 lambda 、stream api 的生产实践
### 项目初衷
* 提供最简的轻量化脚手架，而不去做最全最重的脚手架
### 模块说明

```lua
spring-boot-restful-starter
└── src/main -- 系统公共模块
    └── java/com.hucs.top -- 系统公共模块
         └── config -- 配置类
         └── controller -- 控制器入口
         ├── dao -- 数据库访问层
         ├── entity -- 数据库实体类
         └── interceptor -- 拦截器
         └── job -- 定时任务层
         └── manager -- 业务处理层，是controller和service的中间层
         ├── model -- 业务类
         ├── service -- service层，仅与dao层做交互，不处理业务逻辑
         └── utils -- 工具类
      └── BootStartApplication -- 主启动类
    └── resources -- 系统公共模块
         ├── migration -- FlyWay迁移脚本
         ├── templates -- 代码生成模板
         ├── application.yml -- 配置文件
         ├── application-dev.yml -- 配置文件-本地开发(默认)
         ├── application-test.yml -- 配置文件-测试环境
         ├── application-prod.yml -- 配置文件-生产环境(慎重)
  
```
### 项目依赖Pom介绍：
``` code
        <jdk.version>1.8</jdk.version>
        <project.encoding>UTF-8</project.encoding>
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
        <!--    统一定义版本依赖，供子模块引入   -->
        <spring-boot.version>2.4.2</spring-boot.version>
        <fastjson.version>1.2.18</fastjson.version>
        <druid.version>1.1.10</druid.version>
        <mybatis-plus-generator.version>3.4.1</mybatis-plus-generator.version>
        <mybatis-plus.version>3.4.3.4</mybatis-plus.version>
        <velocity-engine-core.version>2.0</velocity-engine-core.version>
        <joda-time.version>2.7</joda-time.version>
        <slf4j.version>1.7.6</slf4j.version>
        <hutool.version>5.6.4</hutool.version>
        <flyway.version>5.2.1</flyway.version>
        <knife4j.version>2.0.9</knife4j.version>
        <pagehelper.version>1.2.5</pagehelper.version>
```
#### 推荐给大家一个好用的数据库迁移工具：Flyway
* 比如说你的user表里要加一个字段，那么你在测试、生产上都需要去修改数据库，而且有时候程序员是无法登录生产环境的数据库的，这个时候怎么办？又或者你们的项目是支持独立部署的，你有100个客户需要去部署系统，这个时候怎么办？假如说你就一个生产系统，但是你忘记做数据库的字段变化了，这个时候又该怎么办呢？所以这个时候就轮到FlyWay出场了
* [官网地址](https://flywaydb.org/documentation/)，FlyWay会在你的应用程序初始化时检测你的数据库迁移脚本，然后依次帮你执行，这样就减少了人工出错的机会了。
* FlyWay也在本项目中有使用，具体的使用方法请clone本项目后仔细阅读
##### 其中接口文档采用的是knife4j，样式和易用性上都比Swagger要好，也支持OpenApi3.0

### 项目使用说明、启动流程
* 先修改application-dev.yml中的Redis、Mysql配置
* 直接启动BootStartApplication，问：http://localhost:6004/api/doc.html#/home 后就可以看到接口文档了

### 代码生成工具使用 ⭐️⭐️
* GenerateCodeUtil类提供一键生成代码的入口，无需配置，直接生成Controller、Manager、Service、Dao、Vo、Param！
* 再次强调一下，建议同学们好好了解一下Dto、Vo、Bo、Do的概念，还是挺重要的
* 个性化配置项都在GeneratorBo类里，感谢本公司宋连全同学的配合让这个工具从0到1，逐步完善起来
![16602847700574](https://live-cloud-cvoon.oss-cn-hangzhou.aliyuncs.com/image/1660284779724-fb3e490c-b8db-4427.jpg)
## 内置接口
* 目前仅提供了UploadController接口，用做本地文件上传

如果你喜欢此文档，想让它变得更好，你可以：
1. 推荐，让更多的人知道。
2. 给我发反馈和建议：<huchuansai@foxmail.com>
