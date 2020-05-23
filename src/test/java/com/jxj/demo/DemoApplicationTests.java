package com.jxj.demo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

@SpringBootTest
class DemoApplicationTests {

    private static ChromeDriver chromeDriver;
    private static WebDriverWait wait;

    @BeforeAll
    static void ready() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", Collections.singletonMap("deviceName", "Pixel 2"));
        chromeDriver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(chromeDriver, 5);
    }

    @Test
    void contextLoads() {
        try {
            chromeDriver.manage().window().maximize();
            chromeDriver.get("https://wap.yypt.com/");
            IndexEntity indexEntity = new IndexEntity(chromeDriver);
            wait.until(ExpectedConditions.visibilityOf(indexEntity.getLoginButton()));
            indexEntity.getLoginButton().click();
            Thread.sleep(2000);
            indexEntity.getUser().sendKeys("17501691006");
            indexEntity.getPasswd().sendKeys("993820Jxj");
            //Actions action = new Actions(chromeDriver);
            byte[] bs = indexEntity.getCapImg().getScreenshotAs(OutputType.BYTES);
            String code = BaiduOcr.imgOcr(bs);
            System.out.println(code);
            if (code.matches("^\\d{4}$")) {
                System.out.println("验证码通过");
                indexEntity.getCode().sendKeys(code);
                Thread.sleep(1000);
                indexEntity.getLoginSubmit().click();
            }
        } catch (Exception e) {
            System.out.println("错误打印开始----------start\n" + e);
            System.out.println("错误打印结束----------end\n");
        }

    }

    @AfterAll
    static void over() throws InterruptedException {
        Thread.sleep(10000);
        System.out.println("浏览器关闭-------------");
        if (chromeDriver != null) {
            chromeDriver.quit();
        }
    }

}
