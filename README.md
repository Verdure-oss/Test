# Spring Boot Demo Project

这是一个基于 Spring Boot 2.2.7 的演示项目，集成了 Web 服务、Selenium 自动化测试、百度 OCR 识别以及排序算法示例。

## 项目概述

- **框架**: Spring Boot 2.2.7.RELEASE
- **语言**: Java 1.8
- **构建工具**: Maven
- **打包方式**: JAR / Docker 镜像

## 功能模块

### 1. Web 服务 (`src/main/java/com/jxj/demo/controller/TestConrtoller.java`)

提供两个 RESTful API 接口：

| 接口 | 方法 | 参数 | 说明 |
|------|------|------|------|
| `/test/test` | GET | 无 | 返回固定字符串 "访问成功-------0523" |
| `/test/test1` | GET | name, pwd | 回显传入的用户名和密码 |

### 2. Selenium 自动化测试

#### WzAuto (`src/test/java/com/jxj/demo/WzAuto.java`)
- 模拟移动端 (Pixel 2) 访问 `https://wap.yypt.com/`
- 通过 Cookie 实现自动登录
- 适用于 Web 自动化测试场景

#### BaiduAuto (`src/test/java/com/jxj/demo/BaiduAuto.java`)
- 使用 ChromeDriver 访问百度首页
- 通过 Cookie 实现自动登录
- 演示基础的 Selenium WebDriver 操作

### 3. 百度 OCR 文字识别 (`src/test/java/com/jxj/demo/BaiduOcr.java`)

集成百度 AI 开放平台 OCR 服务：
- 使用 `webImage` 接口进行通用文字识别
- 支持传入字节数组格式的图片
- 返回识别出的文字内容

**配置信息** (已在代码中硬编码，生产环境建议外部化配置)：
- APP_ID: 19755251
- API_KEY: wzdcXqFvzIiEkMmniUqS9OVh
- SECRET_KEY: SEGVlXnXKwMUHVrIWxD4rPAnk4MGUbcY

### 4. 排序算法示例 (`src/test/java/com/jxj/demo/Sf.java`)

实现了三种经典排序算法：
- **冒泡排序** (Test1) - 双重循环比较相邻元素
- **选择排序** (Test2) - 每次选择最小元素放到前面
- **插入排序** (Test3) - 将元素插入已排序序列中

测试数据: `{1, 9, 4, 3, 6, 5, 11, 2, 20}`

## 依赖管理

```xml
<!-- 核心依赖 -->
spring-boot-starter-web          # Web MVC 框架
spring-boot-starter-test         # 测试支持

<!-- Selenium 自动化 -->
selenium-java:4.0.0-alpha-5      # Web 自动化测试

<!-- 百度 OCR -->
java-sdk:4.1.1                   # 百度 AI Java SDK
```

## 构建与运行

### Maven 构建
```bash
mvn clean package
```

### 运行应用
```bash
java -jar target/demo-0.0.1.jar
```

应用启动后默认监听 8080 端口，可通过以下地址访问：
- http://localhost:8080/test/test
- http://localhost:8080/test/test1?name=xxx&pwd=xxx

### Docker 构建
```bash
docker build -t demo .
docker run -p 8080:8080 demo
```

## 运行测试

```bash
mvn test
```

测试类包括：
- `DemoApplicationTests` - Spring Boot 上下文加载测试
- `WzAuto` - Web 自动化测试 (需 ChromeDriver)
- `BaiduAuto` - 百度自动化测试 (需 ChromeDriver)
- `BaiduOcr` - OCR 识别测试
- `Sf` - 排序算法测试

## 项目结构

```
src/
├── main/
│   ├── java/
│   │   └── com/jxj/demo/
│   │       ├── DemoApplication.java      # 启动类
│   │       └── controller/
│   │           └── TestConrtoller.java   # REST 控制器
│   └── resources/
│       └── application.properties        # 配置文件 (空)
└── test/
    └── java/
        └── com/jxj/demo/
            ├── BaiduAuto.java      # 百度自动化
            ├── BaiduOcr.java       # 百度 OCR
            ├── DemoApplicationTests.java
            ├── IndexEntity.java
            ├── Sf.java             # 排序算法
            └── WzAuto.java         # 网站自动化
```

## 注意事项

1. **ChromeDriver**: 运行 Selenium 测试需要安装对应版本的 ChromeDriver 并配置到 PATH 中
2. **百度 OCR**: 使用的 API 密钥为演示用途，生产环境请申请自己的密钥并通过配置文件管理
3. **Cookie 失效**: 自动化测试中的 Cookie 有时效性，失效后需重新获取
4. **端口冲突**: 确保 8080 端口未被占用

## 许可证

Demo project for Spring Boot
