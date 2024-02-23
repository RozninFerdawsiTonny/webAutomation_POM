package com.parabank_patasoft.testcases;

import com.parabank_patasoft.pages.BasePage;
import com.parabank_patasoft.pages.Page;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Objects;

public class BaseTest {
    WebDriver driver;
    Page page;
    @BeforeMethod
    public void setupBrowser() {
        String browserName = "chrome";
        if (Objects.equals(browserName, "chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else if (Objects.equals(browserName, "firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (Objects.equals(browserName, "headless")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else {
            System.out.println("Provide correct browsername");
        }
        driver.manage().window().maximize();
        driver.get("");
        page = new BasePage(driver);
    }
        @AfterMethod
        public void closeBrowser(){

        }

    }

