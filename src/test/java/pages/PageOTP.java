package pages;

import base.Keywords;
import base.Test;
import constants.Keys;
import constants.OS;
import exceptions.ApplicationException;
import helper.PropertyReader;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

public class PageOTP extends Keywords {

    public void enterOTP() throws ApplicationException {
        if(Test.attributes.get(Keys.OS).equalsIgnoreCase(OS.ANDROID)){
            if(get.elementBy(By.id("com.unionbankph.getgopay.qat:id/ivCircle1")).isDisplayed()){
                AndroidDriver aDriver= (AndroidDriver) driver;
                aDriver.pressKeyCode(7);
                aDriver.pressKeyCode(7);
                aDriver.pressKeyCode(7);
                aDriver.pressKeyCode(7);
                aDriver.pressKeyCode(7);
                aDriver.pressKeyCode(7);
            }
        }else if(Test.attributes.get(Keys.OS).equalsIgnoreCase(OS.iOS)){
            try {
                if (get.elementBy(By.xpath("//XCUIElementTypeStaticText[@name='We’ll be sending you a 6 digit password to your mobile number ending in 0000. Please enter the code below.']/parent::*/XCUIElementTypeOther")).isDisplayed()) {
                    type.data(By.xpath("//XCUIElementTypeStaticText[@name='We’ll be sending you a 6 digit password to your mobile number ending in 0000. Please enter the code below.']/parent::*/XCUIElementTypeOther"), PropertyReader.testDataOf("OTP"));
                }
            }
            catch (Exception e)
            {
                if (get.elementBy(By.xpath("//XCUIElementTypeStaticText[contains(@name,'OTP')]/parent::*/XCUIElementTypeOther")).isDisplayed()) {
                    type.data(By.xpath("//XCUIElementTypeStaticText[contains(@name,'OTP')]/parent::*/XCUIElementTypeOther"), PropertyReader.testDataOf("OTP"));
                }
            }

        }
    }
}
