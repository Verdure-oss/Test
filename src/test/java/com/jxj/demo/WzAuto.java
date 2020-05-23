package com.jxj.demo;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

@SpringBootTest
public class WzAuto {
    @Test
    void Test() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", Collections.singletonMap("deviceName", "Pixel 2"));
        ChromeDriver chromeDriver = new ChromeDriver(chromeOptions);
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://wap.yypt.com/");
        Thread.sleep(1000);
        chromeDriver.manage().addCookie(new Cookie("BSFIT_EXPIRATION", "1591320244303"));
        chromeDriver.manage().addCookie(new Cookie("BSFIT_DEVICEID", "keH15XRJR3MdjMgz6sphAkN4L7bAzCdksY5MljPIfvGzGxv7YfpTnV6lpdZXHPl3PWKR1ATV-FdHd8zKKh_g_VEAiQczwbNkYlaEkv0ZKyeniT6sMtoyQMkkcNhgzsEbaQGXXfZ-k0a-3OqSRqylKOwThfg3R5jD"));
        chromeDriver.manage().addCookie(new Cookie("sensorsdata2015jssdkcross", "%7B%22distinct_id%22%3A%22010119447077%22%2C%22%24device_id%22%3A%22171e412344940-06b62c278fa109-24532b0e-300441-171e412344a2cd%22%2C%22props%22%3A%7B%22platform%22%3A%22%E5%BE%AE%E7%AB%99%22%2C%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_referrer%22%3A%22%22%2C%22%24latest_referrer_host%22%3A%22%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22isLogin%22%3Atrue%7D%2C%22first_id%22%3A%22171e412344940-06b62c278fa109-24532b0e-300441-171e412344a2cd%22%7D"));
        chromeDriver.manage().addCookie(new Cookie("SESSION", "a5f1211a-37dc-44ce-bc87-fdde0284f6bf"));
        chromeDriver.manage().addCookie(new Cookie("TOKEN", "ac2a3e53-46fa-4dc0-b843-12dd7648ea78"));
        Thread.sleep(2000);
        chromeDriver.navigate().refresh();
    }
}
