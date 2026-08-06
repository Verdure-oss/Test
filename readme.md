# Test

## 项目描述

Test 是一个基于 Spring Boot 2.2.7 的示例工程，用于演示后端接口开发、自动化测试与部署上线的完整流程。项目提供 RESTful API 服务，集成 Selenium 进行浏览器自动化测试，使用百度 OCR 识别验证码，并包含常用排序算法的实现示例。

## 功能实现

- REST API 接口：基于 Spring Boot 提供 HTTP 接口，展示 Controller、Service、Repository 分层实现。
- Selenium 自动化测试：通过浏览器自动化脚本覆盖核心业务流程。
- 百度 OCR 验证码识别：调用百度 OCR 服务自动识别验证码。
- 排序算法示例：提供常见排序算法的 Java 实现。

## 技术栈

- Java 8
- Spring Boot 2.2.7
- Maven
- Selenium
- 百度 OCR API
- Docker / Jenkins

## 构建与部署

执行以下命令即可构建并启动服务：

mvn clean package

mvn spring-boot:run

也可通过 Docker 构建镜像并使用 Jenkins 流水线完成持续集成与部署。

## 目录结构

- src/main/java：业务源码
- src/main/resources：配置与静态资源
- src/test/java：单元及自动化测试
- Dockerfile / Jenkinsfile：容器化与 CI/CD 配置（如存在）
