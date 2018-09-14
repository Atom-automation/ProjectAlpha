package actions;

import base.Keywords;
import base.Test;
import exceptions.ApplicationException;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Verify extends Keywords{

    private static Logger log=Logger.getLogger(Verify.class);

    public void elementIsPresent(String locatorKey) throws ApplicationException {
        log.info("Verify element ["+locatorKey+"] is present");        
        get.elementBy(locatorKey);
        log.info("Element is present!");
    }

    public void elementIsPresent(By locator) throws ApplicationException {
        log.info("Verify element ["+locator+"] is present");
        get.elementBy(locator);
        log.info("Element is present!");
    }

    public void elementTextMatching(String locatorKey,String expectedValue) throws ApplicationException {
        log.info("Verify element ["+locatorKey+"] text is matching with ["+expectedValue+"]");
        String actualValue=Test.tools.REMOVE_MULTIPLE_SPACES_AND_NEW_LINES(get.elementBy(locatorKey).getText().trim());
        try{
            isMatching(expectedValue,actualValue);
        }catch (Exception ex){
            log.error(ex);
            throw new ApplicationException(ex.getMessage());
        }
        log.info("Condition verified!");
    }

    public void elementTextContains(String locatorKey,String expectedValue) throws ApplicationException {
        log.info("Verify element ["+locatorKey+"] text is matching with ["+expectedValue+"]");
        String actualValue=Test.tools.REMOVE_MULTIPLE_SPACES_AND_NEW_LINES(get.elementBy(locatorKey).getText().trim());
        try{
            Assert.assertTrue(actualValue.contains(expectedValue.trim()));
        }catch (AssertionError ex){
            log.error("Actual value ["+actualValue+"] not matching with the Expected value["+expectedValue+"]");
            throw new ApplicationException("Actual value ["+actualValue+"] not matching with the Expected value["+expectedValue+"]");
        }
        log.info("Condition verified!");
    }

    public void elementTextMatching(By locator,String expectedValue) throws ApplicationException {
        log.info("Verify element ["+locator+"] text is matching with ["+expectedValue+"]");
        String actualValue=Test.tools.REMOVE_MULTIPLE_SPACES_AND_NEW_LINES(get.elementBy(locator).getText().trim());
        try{
            isMatching(expectedValue,actualValue);
        }catch (Exception ex){
            log.error(ex);
            throw new ApplicationException(ex.getMessage());
        }
        log.info("Condition verified!");
    }

    public void elementTextContains(By locator,String expectedValue) throws ApplicationException {
        log.info("Verify element ["+locator+"] text is matching with ["+expectedValue+"]");
        String actualValue=Test.tools.nbspRemove(get.elementBy(locator).getText().trim());
        try{
            Assert.assertTrue(actualValue.contains(expectedValue.trim()));
        }catch (AssertionError ex){
            log.error("Actual value ["+actualValue+"] don't contain the Expected value["+expectedValue+"]");
            throw new ApplicationException("Actual value ["+actualValue+"] don't contain the Expected value["+expectedValue+"]");
        }
        log.info("Condition verified!");
    }

    public void isMatching(String expected,String actual) throws ApplicationException {
        try{
            Assert.assertEquals(Test.tools.nbspRemove(actual).toLowerCase(),expected.trim().toLowerCase());
        }catch (AssertionError ex){
            log.info(ex);
            throw new ApplicationException(ex.getMessage());
        }
        log.info("Expected value ["+expected+"] is matching with the actual ["+actual+"]");
    }

    public void isMatchingPartial(String expected,String actual) throws ApplicationException {
        try{
            Assert.assertTrue(Test.tools.nbspRemove(actual).toLowerCase().contains(expected.trim().toLowerCase()));
        }catch (AssertionError ex){
            log.info(ex);
            throw new ApplicationException(ex.getMessage());
        }
        log.info("Expected value ["+expected+"] is matching with the actual ["+actual+"]");
    }

    public void isMatching(double expected,double actual) throws ApplicationException {
        try{

            Assert.assertEquals(actual,expected,1);
        }catch (AssertionError ex){
            log.info(ex);
            throw new ApplicationException(ex.getMessage());
        }
        log.info("Expected value ["+expected+"] is matching with the actual ["+actual+"]");
    }

    public void elementAttributeMatching(String locatorKey, String whichAttribute,String expectedValue) throws ApplicationException {
        log.info("Verify if the element ["+locatorKey+"] attribute ["+whichAttribute+"] is matching with the value ["+expectedValue+"]");
        try{
            Assert.assertEquals(get.elementAttribute(locatorKey,whichAttribute),expectedValue.trim());
        }catch (AssertionError ex){
            log.error(ex);
            throw new ApplicationException(ex.getMessage());
        }
    }

    public void elementAttributeMatching(By locator, String whichAttribute,String expectedValue) throws ApplicationException {
        log.info("Verify if the element ["+locator+"] attribute ["+whichAttribute+"] is matching with the value ["+expectedValue+"]");
        try{
            Assert.assertEquals(get.elementAttribute(locator,whichAttribute),expectedValue.trim());
        }catch (AssertionError ex){
            log.error(ex);
            throw new ApplicationException(ex.getMessage());
        }
    }

    public String verifyDOBinreviewpage(String idata) {


        String selectdata[]=idata.split("-");
        String year=selectdata[0];
        String month=selectdata[1];
        String date=selectdata[2];

        HashMap<String,String> map=new LinkedHashMap<String,String>();
        map.put("01","Jan");
        map.put("02","Feb");
        map.put("03","Mar");
        map.put("04","Apr");
        map.put("05","May");
        map.put("06","Jun");
        map.put("07","Jul");
        map.put("08","Aug");
        map.put("09","Sep");
        map.put("10","Oct");
        map.put("11","Nov");
        map.put("12","Dec");

        return map.get(month)+" "+date+", "+year;


    }

}