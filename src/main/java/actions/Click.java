package actions;

import base.Keywords;
import exceptions.ApplicationException;
import helper.PropertyReader;
import io.appium.java_client.MobileElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class Click extends Keywords{

    private static Logger log=Logger.getLogger(Click.class);

    public void elementBy(String locatorKey) throws ApplicationException {
        screenshot.attachScreenshot("Screenshot for the locator "+locatorKey);
        log.info("Click element ["+locatorKey+"]");
        try{
            get.elementBy(locatorKey).click();
        }catch (StaleElementReferenceException ex){
            get.elementBy(locatorKey).click();
        }
        log.info("Click Successful!");
    }

    public void elementBy(By locator) throws ApplicationException {
        screenshot.attachScreenshot("Screenshot for the locator "+locator);
        log.info("Click element ["+locator+"]");
        try{
            get.elementBy(locator).click();
        }catch (StaleElementReferenceException ex){
            get.elementBy(locator).click();
        }
        log.info("Click Successful!");
    }

    public void elementsValuesBy(String locatorKey,String ivalue) throws ApplicationException {
        boolean blogic=false;
        screenshot.attachScreenshot("Screenshot for the locator "+locatorKey);
        log.info("Click elementsByValues ["+locatorKey+"]");
        try{
            //get.elementBy(locatorKey).click();
            List<WebElement> a=driver.findElements(PropertyReader.locatorOf(locatorKey));

            for (int i = 0; i <a.size(); i++) {
                if((a.get(i).getText().trim()).contentEquals(ivalue.trim()))
                {
                    a.get(i).click();
                    log.info("Clicked on the element " + locatorKey);
                    blogic=true;
                    break;
                }

            }
            if(blogic==true)
            {
                log.info("Click is Successful!");
            }
            else
            {
                throw new ApplicationException("cannot able to click the element in the list.Kindly check the input value");
            }

        }catch (StaleElementReferenceException ex){
            get.elementBy(locatorKey).click();
        }

    }
}
