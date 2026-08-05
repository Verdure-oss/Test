# Spring Boot Demo Project

这是一个基于 Spring Boot 2.2.7 的演示项目，展示了 Web 服务开发、Selenium 自动化测试、百度 OCR 图片识别以及常用排序算法的实现。

## 📋 项目概述

本项目是一个 Maven 多模块的 Spring Boot 应用，主要包含以下功能模块：

- **REST API 服务** - 提供简单的 HTTP 接口测试
- **Web 自动化测试** - 基于 Selenium 实现的百度、网站自动化登录测试
- **百度 OCR 识别** - 集成百度 AI 开放平台的通用文字识别服务
- **排序算法演示** - 冒泡排序、选择排序、插入排序的 Java 实现

## 🛠 技术栈

| 技术 | 版本 | 说明 |
|------|------|------|
| Java | 1.8 | 编程语言 |
| Spring Boot | 2.2.7.RELEASE | 应用框架 |
| Spring Web | 2.2.7 | Web MVC 框架 |
| Selenium | 4.0.0-alpha-5 | Web 自动化测试框架 |
| 百度 AI Java SDK | 4.1.1 | OCR 文字识别客户端 |
| JUnit 5 | - | 单元测试框架 |
| Maven | - | 构建工具 |
| Docker | - | 容器化部署支持 |

## 📁 项目结构

```
demo/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/jxj/demo/
│   │   │       ├── DemoApplication.java        # Spring Boot 启动类
│   │   │       └── controller/
│   │   │           └── TestConrtoller.java     # REST 控制器
│   │   └── resources/
│   │       └── application.properties          # 配置文件
│   └── test/
│       └── java/com/jxj/demo/
│           ├── BaiduOcr.java           # 百度 OCR 识别工具类
│           ├── WzAuto.java             # 网站自动化测试 (移动端模拟)
│           ├── BaiduAuto.java          # 百度自动化登录测试
│           ├── Sf.java                 # 排序算法演示
│           └── DemoApplicationTests.java # 基础测试类
├── pom.xml                              # Maven 配置文件
├── Dockerfile                           # Docker 镜像构建
├── Jenkinsfile                          # Jenkins 流水线配置
└── README.md                            # 本文件
```

## 🚀 快速开始

### 环境要求

- JDK 1.8+
- Maven 3.6+
- Chrome 浏览器 (用于 Selenium 测试)
- ChromeDriver (需与 Chrome 版本匹配)

### 编译打包

```bash
# 编译项目
mvn clean compile

# 运行测试
mvn test

# 打包为 JAR
mvn clean package

# 跳过测试打包
mvn clean package -DskipTests
```

### 运行应用

```bash
# 方式 1: 使用 Maven 运行
mvn spring-boot:run

# 方式 2: 直接运行 JAR 包
java -jar target/demo-0.0.1.jar
```

应用启动后默认监听 `http://localhost:8080`

## 📡 API 接口文档

### 基础路径
```
/test
```

### 接口列表

| 接口 | 方法 | 参数 | 返回示例 | 说明 |
|------|------|------|----------|------|
| `/test/test` | GET | 无 | `访问成功-------0523` | 健康检查接口 |
| `/test/test1` | GET | `name` (String), `pwd` (String) | `name:张三 pwd:123456` | 参数回显测试 |

### 请求示例

```bash
# 测试基础接口
curl http://localhost:8080/test/test

# 测试带参数接口
curl "http://localhost:8080/test/test1?name=张三&pwd=123456"
```

## 🤖 自动化测试模块

### 1. 百度自动化登录 (`BaiduAuto.java`)

使用 Selenium WebDriver 自动打开百度首页并通过 Cookie 实现自动登录。

```java
@Test
void test() throws InterruptedException {
    WebDriver webDriver = new ChromeDriver();
    webDriver.get("https://www.baidu.com");
    // 添加 BDUSS Cookie 实现免登录
    webDriver.manage().addCookie(new Cookie("BDUSS", "..."));
    webDriver.navigate().refresh();
}
```

**注意**: 测试中使用的 Cookie 为示例值，实际使用请替换为有效的登录 Cookie。

### 2. 移动端网站自动化 (`WzAuto.java`)

模拟移动端设备 (Pixel 2) 访问指定网站并通过 Cookie 实现自动登录。

```java
@Test
void Test() throws InterruptedException {
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.setExperimentalOption("mobileEmulation", 
        Collections.singletonMap("deviceName", "Pixel 2"));
    ChromeDriver chromeDriver = new ChromeDriver(chromeOptions);
    // 添加多个 Cookie 实现登录状态
    chromeDriver.manage().addCookie(new Cookie("SESSION", "..."));
    chromeDriver.manage().addCookie(new Cookie("TOKEN", "..."));
}
```

### 3. 百度 OCR 文字识别 (`BaiduOcr.java`)

集成百度 AI 开放平台的通用文字识别 (webImage) 接口。

```java
public static String imgOcr(byte[] img) throws JSONException {
    getClient();
    JSONObject jsonObject = client.webImage(img, null);
    JSONArray jSONArray = jsonObject.getJSONArray("words_result");
    return jSONArray.getJSONObject(0).getString("words");
}
```

**配置要求**:
- 需在百度 AI 控制台创建 OCR 应用
- 获取 `APP_ID`、`API_KEY`、`SECRET_KEY`
- 修改 `BaiduOcr.java` 中的常量值

## 🔢 排序算法演示 (`Sf.java`)

包含三种经典排序算法的实现和测试：

### 冒泡排序
- 时间复杂度: O(n²)
- 空间复杂度: O(1)
- 稳定排序

```java
@Test
void Test1() {
    // 两层循环，相邻元素比较交换
    for (int i = 0; i < ints.length; i++) {
        for (int j = 0; j < ints.length - i - 1; j++) {
            if (ints[j] > ints[j + 1]) {
                // 交换元素
            }
        }
    }
}
```

### 选择排序
- 时间复杂度: O(n²)
- 空间复杂度: O(1)
- 不稳定排序

```java
@Test
void Test2() {
    // 每轮选择最小元素放到有序区末尾
    for (int i = 0; i < ints.length; i++) {
        int min = ints[i];
        int minindex = i;
        for (int j = i + 1; j < ints.length; j++) {
            if (min > ints[j]) {
                min = ints[j];
                minindex = j;
            }
        }
        // 交换
    }
}
```

### 插入排序
- 时间复杂度: O(n²) (最好 O(n))
- 空间复杂度: O(1)
- 稳定排序

```java
@Test
void Test3() {
    // 将无序区元素插入有序区合适位置
    for (int i = 1; i < ints.length; i++) {
        for (int j = i; j > 0; j--) {
            if (ints[j - 1] > ints[j]) {
                // 交换
            }
        }
    }
}
```

**测试数据**: `{1, 9, 4, 3, 6, 5, 11, 2, 20}`
**排序结果**: `1,2,3,4,5,6,9,11,20,`

## 🐳 Docker 部署

项目包含 `Dockerfile` 和 `dockerfile-maven-plugin` 配置，支持容器化部署。

### 构建镜像

```bash
# 使用 Maven 插件构建
mvn dockerfile:build

# 或手动构建
docker build -t demo:0.0.1 .
```

### 运行容器

```bash
docker run -d -p 8080:8080 demo:0.0.1
```

### Dockerfile 说明

```dockerfile
# 基础镜像使用 OpenJDK 8
FROM openjdk:8-jre-alpine

# 设置工作目录
WORKDIR /app

# 复制打包好的 JAR 包
COPY target/demo-0.0.1.jar app.jar

# 暴露端口
EXPOSE 8080

# 启动命令
ENTRYPOINT ["java", "-jar", "app.jar"]
```

## ⚙️ Jenkins CI/CD

项目包含 `Jenkinsfile` 定义持续集成流水线，支持自动化构建、测试、镜像构建和部署。

## 📝 配置文件

### application.properties

当前为空配置文件，可根据需要添加以下常用配置：

```properties
# 服务端口
server.port=8080

# 应用名称
spring.application.name=demo

# 日志配置
logging.level.com.jxj.demo=DEBUG
```

## ⚠️ 注意事项

1. **Selenium 测试依赖**: 运行自动化测试需要本地安装 Chrome 浏览器和对应版本的 ChromeDriver
2. **百度 OCR 凭证**: `BaiduOcr.java` 中的 `APP_ID`、`API_KEY`、`SECRET_KEY` 为示例值，请替换为自己的百度 AI 应用凭证
3. **Cookie 失效**: 自动化测试中的 Cookie 具有有效期，失效后需要重新获取
4. **测试环境**: 部分测试用例标注了 `@SpringBootTest`，需要 Spring 上下文启动，执行时间较长

## 🤝 贡献指南

1. Fork 本仓库
2. 创建特性分支 (`git checkout -b feature/AmazingFeature`)
3. 提交更改 (`git commit -m 'Add some AmazingFeature'`)
4. 推送到分支 (`git push origin feature/AmazingFeature`)
5. 创建 Pull Request

## 📄 许可证

本项目采用 MIT 许可证 - 详见 [LICENSE](LICENSE) 文件

## 📞 联系方式

如有问题或建议，欢迎提交 Issue 或 Pull Request。

---

**项目维护者**: jxj  
**最后更新**: 2024
