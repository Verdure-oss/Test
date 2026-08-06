# Demo

一个基于 **Spring Boot 2.2.7** 的示例项目（Java 8 / Maven），用于演示 Web 接口开发、浏览器自动化测试、图片验证码识别以及 Docker/Jenkins 持续集成部署流程。

## 项目描述

本项目是一个 Spring Boot 演示工程（`groupId: com.jxj`，`artifactId: demo`），核心用途：

- 提供一个简单的 REST 接口服务，验证 Spring Boot Web 应用的基本能力。
- 集成 Selenium（ChromeDriver）实现浏览器自动化操作。
- 集成百度 AI OCR（`com.baidu.aip:java-sdk`）实现图片文字/验证码识别。
- 演示通过 Dockerfile + Jenkinsfile 实现「构建 -> 打包镜像 -> 运行容器」的自动化部署。

## 功能实现

### 1. Web 接口（`com.jxj.demo.controller.TestConrtoller`）

| 接口 | 参数 | 说明 |
| --- | --- | --- |
| `/test/test` | 无 | 返回字符串 `访问成功`，用于验证服务是否正常启动 |
| `/test/test1` | `name`、`pwd`（必填） | 回显传入的 `name` 和 `pwd` 参数 |

### 2. 浏览器自动化测试（Selenium）

- `DemoApplicationTests`：模拟移动端（Pixel 2）访问 `wap.yypt.com`，自动完成登录流程（输入账号密码、截图验证码、识别后提交）。
- `WzAuto`：通过 Cookie 注入模拟登录态访问移动端页面。
- `BaiduAuto`：通过注入 `BDUSS` Cookie 模拟百度账号登录态。
- `IndexEntity`：使用 Page Object 模式封装页面登录元素。

### 3. 百度 OCR 验证码识别（`BaiduOcr`）

调用百度 AI 开放平台的 OCR 接口，对验证码图片进行识别，并将识别结果用于自动化登录流程。

### 4. 排序算法示例（`Sf`）

包含冒泡排序、选择排序、插入排序三种经典排序算法的实现示例。

## 技术栈

- Java 8
- Spring Boot 2.2.7（spring-boot-starter-web）
- Maven（spring-boot-maven-plugin、dockerfile-maven-plugin）
- Selenium 4.0.0-alpha-5（ChromeDriver）
- 百度 AI OCR SDK 4.1.1
- Docker / Jenkins

## 构建与部署

### 本地构建

```bash
mvn clean package
```

### Docker 镜像构建

项目通过 `dockerfile-maven-plugin` 构建镜像，`Dockerfile` 使用 `openjdk:14-jdk` 基础镜像运行打包好的 jar：

```bash
mvn clean package -Dmaven.test.skip=true dockerfile:build
```

### Jenkins 流水线

`Jenkinsfile` 定义了一条完整的 CI/CD 流水线：

1. `pull code`：拉取 master 分支代码
2. `docker container stop and rm`：停止并删除旧的 `demo` 容器
3. `docker images rmi`：删除旧的 `demo` 镜像
4. `build`：执行 `mvn clean package dockerfile:build` 构建并打包镜像
5. `docker run`：以 `-p 8080:8080` 启动 `demo` 容器

## 目录结构

```
├── Dockerfile                  # 容器镜像定义
├── Jenkinsfile                 # Jenkins CI/CD 流水线
├── pom.xml                     # Maven 构建配置
└── src
    ├── main
    │   ├── java/com/jxj/demo
    │   │   ├── DemoApplication.java        # 应用启动入口
    │   │   └── controller/TestConrtoller.java  # REST 接口
    │   └── resources/application.properties
    └── test/java/com/jxj/demo
        ├── BaiduOcr.java       # 百度 OCR 验证码识别
        ├── BaiduAuto.java      # 百度 Cookie 自动化
        ├── WzAuto.java         # 移动端 Cookie 自动化
        ├── IndexEntity.java    # Page Object 页面元素封装
        ├── Sf.java             # 排序算法示例
        └── DemoApplicationTests.java  # 登录自动化测试
```
