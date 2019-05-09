package com.spartaglobal.automationpractice_eng28.AutomationPractice.SeleniumConfig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class SeleniumConfig
{


    private WebDriver driver;
    private SeleniumPropertiesReader seleniumProperties = new SeleniumPropertiesReader();


    public SeleniumConfig(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", seleniumProperties.getChromeDriverPath());
            this.driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", seleniumProperties.getFirefoxDriverPath());
            this.driver = new FirefoxDriver();
        }

        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        this.driver.manage().window().maximize();

    }

    public WebDriver getDriver()
    {
        return driver;
    }

    public void quitDriver()
    {
        this.driver.quit();
    }

    private Actions actionOnWebElement(){
        return new Actions(driver);
    }

    public void moveToElement(By byFinder){
        actionOnWebElement().moveToElement(driver.findElement(byFinder));
    }


}
