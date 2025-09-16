package com.inetbanking.stepDefinitions;

import com.inetbanking.testCases.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import java.time.Duration;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks {
    @Before
    public void setUp() {
        if (BaseClass.driver == null) {
            System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            BaseClass.driver = new ChromeDriver(options);
            BaseClass.driver.manage().window().maximize();
            BaseClass.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
    }

    @After
    public void tearDown() {
        if (BaseClass.driver != null) {
            BaseClass.driver.quit();
            BaseClass.driver = null;
        }
    }
}