package pages;

import base.Test;
import com.sun.jndi.toolkit.url.Uri;
import constants.Keys;
import exceptions.ApplicationException;
import helper.PropertyReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class OutlookValidation extends Test {


    public static void main(String[] args) throws ApplicationException, MalformedURLException {
        AppiumDriver browser;

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "ios");
        capabilities.setCapability("platformVersion", "11.4");
        capabilities.setCapability("deviceName", "iPhone X");
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("udid", "164bca6ea436744750bc6425ccfdb37001775230");
        capabilities.setCapability("bundleId", "com.apple.mobilemail");
        //capabilities.setCapability("app", "/Users/ubp/Documents/GetGopayCode/Mobile/src/test/resources/apps/Getgo.ipa");

        //capabilities.setCapability("autoWebview", "true");
        //capabilities.setCapability("safariInitialUrl", "https://www.google.com/");

        //capabilities.setCapability("useNewWDA", true);
        //capabilities.setCapability("realDeviceLogger", "idevicesyslog");
        //capabilities.setCapability("noReset", false);
        //capabilities.setCapability("clearSystemFiles", true);
        capabilities.setCapability("newCommandTimeout", 150000);
        capabilities.setCapability("webkitResponseTimeout", 150000);

        browser = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        //browser.




    }


}
