package com.jxj.demo;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

@SpringBootTest
public class BaiduAuto {
    @Test
    void test() throws InterruptedException {
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://www.baidu.com");
        Thread.sleep(2000);
        Cookie cookie = new Cookie("BDUSS", "ZjOUswWUNOTmVpdlk4QmowNWt1eDk2cUloRW0yUmpFWFFvbjBMSFNMUi0wZXBlSVFBQUFBJCQAAAAAAAAAAAEAAACNQKA70MfSuWp4agAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAH5Ew15-RMNeY1");
        webDriver.manage().addCookie(cookie);
        Thread.sleep(2000);
        webDriver.navigate().refresh();
    }
}
