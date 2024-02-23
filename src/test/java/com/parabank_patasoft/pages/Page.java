package com.parabank_patasoft.pages;

import com.parabank_patasoft.util.Genaral;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.util.List;

public abstract class Page {
    WebDriver driver;
    WebDriverWait wait; //implicit wait
    public Page(WebDriver driver){
        //constructor respective testcase
        this.driver = driver; //set writeonly
        wait = new WebDriverWait(driver, Duration.ofSeconds(Genaral.WAIT_Time)); // reassign kora jai na declare korte hoy final diye.
    }
    //Abstract method implementation child
    public abstract String getPageTitle(); //not implementation
    public abstract WebElement getWebElement(By Locator); //Action use
    public abstract List<WebElement> getWebElements(By Selector);
    public abstract void waitForWebElement(By Locator); //For Waiting locator or Selector
    //parameter a je class pathabo se class reture korbo
    //wildcard
    public <T extends BasePage> T getInstance (Class<T> tClass) {
        try {
            return tClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}
