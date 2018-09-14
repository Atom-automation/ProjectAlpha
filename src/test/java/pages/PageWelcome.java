package pages;

import base.Keywords;
import exceptions.ApplicationException;
import exceptions.EnvironmentException;
import helper.Device;
import helper.PropertyReader;
import org.openqa.selenium.By;
import xpath.Matching;

public class PageWelcome extends Keywords {

    String alreadyLoginEmail;

    private String keyBtnLogin="Getgo.Welcome.BtnLogin";
    private String keyBtnSignUp="Getgo.Welcome.BtnSignUp";

    private String keyLblPageContent="Getgo.ProductFeatureWelcomePage.LblPageContent";
    private String keyImgWelcome="Getgo.ProductFeatureWelcomePage.ImgWelcome";
    private String keyLblToogleIndicator1="Getgo.ProductFeatureWelcomePage.LblToogleIndicator1";
    private String keyLblToogleIndicator2="Getgo.ProductFeatureWelcomePage.LblToogleIndicator2";
    private String keyLblToogleIndicator3="Getgo.ProductFeatureWelcomePage.LblToogleIndicator3";
    private String keyLblToogleIndicator4="Getgo.ProductFeatureWelcomePage.LblToogleIndicator4";
    private String keyLblToogleIndicator5="Getgo.ProductFeatureWelcomePage.LblToogleIndicator5";
    private String keyBtnNext="Getgo.ProductFeatureWelcomePage.BtnNext";


    public void launchGetgo() throws EnvironmentException, ApplicationException {
	    launchApplication();


    }

    public void launchGetgoFresh() throws EnvironmentException, ApplicationException {
        driver=null;
        launchApplication();


    }

    public void doesPageContains(String loginBtnTxt,String signUpBtnTxt,String captionTxt) throws ApplicationException
    {
        if(Device.isAndroid()) {
            //click.elementBy(xpathOf.button(Matching.youDecide("NEXT")));
            //click.elementBy(xpathOf.button(Matching.youDecide("NEXT")));
            //click.elementBy(xpathOf.button(Matching.youDecide("NEXT")));
            //click.elementBy(xpathOf.button(Matching.youDecide("NEXT")));
            //click.elementBy(xpathOf.button(Matching.youDecide("GET STARTED")));
            verify.elementIsPresent("Getgo.Welcome.ImgLogo");
            verify.elementTextMatching("Getgo.Welcome.LblCaption", captionTxt);
            verify.elementTextMatching(keyBtnLogin, loginBtnTxt);
            verify.elementTextMatching(keyBtnSignUp, signUpBtnTxt);
        }
        else
        {
            verify.elementIsPresent("Getgo.Welcome.ImgLogo");
            verify.elementTextMatching("Getgo.Welcome.LblCaption", captionTxt);
            verify.elementTextMatching(keyBtnLogin, loginBtnTxt);
            verify.elementTextMatching(keyBtnSignUp, signUpBtnTxt);
        }
    }

    public void clickLogin() throws ApplicationException {
        if(Device.isAndroid()) {

            try {
                click.elementBy(xpathOf.button(Matching.youDecide("NEXT")));
                click.elementBy(xpathOf.button(Matching.youDecide("NEXT")));
                click.elementBy(xpathOf.button(Matching.youDecide("NEXT")));
                click.elementBy(xpathOf.button(Matching.youDecide("NEXT")));
                click.elementBy(xpathOf.button(Matching.youDecide("GET STARTED")));
                click.elementBy(keyBtnLogin);
            } catch (Exception e) {

                click.elementBy(keyBtnLogin);
            }
        }
        else
        {
            try {
                click.elementBy(keyBtnLogin);
            } catch (Exception e) {
               // boolean ivalue=driver.findElementByAccessibilityId("ic_profile_landing").isDisplayed();
                        try
                        {
                            boolean ivalue1 = driver.findElementByAccessibilityId("USE PASSWORD").isDisplayed();
                            if (driver.findElementByAccessibilityId("USE PASSWORD").isDisplayed()) {
                                alreadyLoginEmail = get.elementText(By.xpath("(//XCUIElementTypeStaticText)[2]"));

                                click.elementBy(xpathOf.button(Matching.name("USE PASSWORD")));
                            }
                        }
                        catch(Exception ex)
                        {
                            iosProductFeature();

                            click.elementBy(keyBtnLogin);
                        }

            }
        }

    }

    public void clickSignUp() throws ApplicationException {

        try{
        click.elementBy(keyBtnSignUp);}
        catch(Exception e)
        {
            /*click.elementBy(xpathOf.button(Matching.youDecide("NEXT")));
            click.elementBy(xpathOf.button(Matching.youDecide("NEXT")));
            click.elementBy(xpathOf.button(Matching.youDecide("NEXT")));
            click.elementBy(xpathOf.button(Matching.youDecide("NEXT")));
            click.elementBy(xpathOf.button(Matching.youDecide("GET STARTED")));*/
            iosProductFeature();
            click.elementBy(keyBtnSignUp);
        }
    }

    public void iosProductFeature() throws ApplicationException {
        click.elementBy(xpathOf.button(Matching.youDecide("NEXT")));
        click.elementBy(xpathOf.button(Matching.youDecide("NEXT")));
        click.elementBy(xpathOf.button(Matching.youDecide("NEXT")));
        click.elementBy(xpathOf.button(Matching.youDecide("NEXT")));
        click.elementBy(xpathOf.button(Matching.youDecide("GET STARTED")));
        WAIT.forSeconds(2);

    }

    public void welcomepageone() throws ApplicationException {
        if(Device.isAndroid()) {
            verify.elementTextMatching(keyLblPageContent, "Nam porttitor blandit accumsan. Ut vel dictum sem, a pretium dui.");
            verify.elementIsPresent(keyImgWelcome);
        verify.elementIsPresent(keyLblToogleIndicator1);
        verify.elementIsPresent(keyLblToogleIndicator2);
        verify.elementIsPresent(keyLblToogleIndicator3);
        verify.elementIsPresent(keyLblToogleIndicator4);
        verify.elementIsPresent(keyLblToogleIndicator5);
            verify.elementIsPresent(keyBtnNext);
            verify.elementTextMatching(keyBtnNext, "NEXT");
        verify.elementAttributeMatching(keyLblToogleIndicator1,"selected","true");
        verify.elementAttributeMatching(keyLblToogleIndicator2,"selected","false");
        verify.elementAttributeMatching(keyLblToogleIndicator3,"selected","false");
        verify.elementAttributeMatching(keyLblToogleIndicator4,"selected","false");
        verify.elementAttributeMatching(keyLblToogleIndicator5,"selected","false");
        }
        else
        {
            verify.elementTextMatching(keyLblPageContent, "Nam porttitor blandit accumsan. Ut vel dictum sem, a pretium dui.");
            verify.elementIsPresent(keyImgWelcome);
            verify.elementIsPresent(keyLblToogleIndicator1);
            verify.elementIsPresent(keyBtnNext);
            verify.elementTextMatching(keyBtnNext, "NEXT");
            verify.elementAttributeMatching(keyLblToogleIndicator1,"enabled","true");

        }

        WAIT.forSeconds(2);

    }

    public void welcomepagetwo() throws ApplicationException {
        if (Device.isAndroid())
        {
            verify.elementTextMatching(keyLblPageContent, "Nam porttitor blandit accumsan. Ut vel dictum sem, a pretium dui.");
        verify.elementIsPresent(keyImgWelcome);
        verify.elementIsPresent(keyLblToogleIndicator1);
        verify.elementIsPresent(keyLblToogleIndicator2);
        verify.elementIsPresent(keyLblToogleIndicator3);
        verify.elementIsPresent(keyLblToogleIndicator4);
        verify.elementIsPresent(keyLblToogleIndicator5);
        verify.elementIsPresent(keyBtnNext);
        verify.elementTextMatching(keyBtnNext, "NEXT");

        verify.elementAttributeMatching(keyLblToogleIndicator1,"selected","false");
        verify.elementAttributeMatching(keyLblToogleIndicator2,"selected","true");
        verify.elementAttributeMatching(keyLblToogleIndicator3,"selected","false");
        verify.elementAttributeMatching(keyLblToogleIndicator4,"selected","false");
        verify.elementAttributeMatching(keyLblToogleIndicator5,"selected","false");

    }
    else
        {
            verify.elementTextMatching(keyLblPageContent, "Nam porttitor blandit accumsan. Ut vel dictum sem, a pretium dui.");
            verify.elementIsPresent(keyImgWelcome);
            verify.elementIsPresent(keyLblToogleIndicator2);
            verify.elementIsPresent(keyBtnNext);
            verify.elementTextMatching(keyBtnNext, "NEXT");
            verify.elementAttributeMatching(keyLblToogleIndicator2,"enabled","true");

        }

        WAIT.forSeconds(2);
    }

    public void welcomepagethree() throws ApplicationException {

        if(Device.isAndroid()) {
            verify.elementTextMatching(keyLblPageContent, "Nam porttitor blandit accumsan. Ut vel dictum sem, a pretium dui.");
            verify.elementIsPresent(keyImgWelcome);
        verify.elementIsPresent(keyLblToogleIndicator1);
        verify.elementIsPresent(keyLblToogleIndicator2);
        verify.elementIsPresent(keyLblToogleIndicator3);
        verify.elementIsPresent(keyLblToogleIndicator4);
        verify.elementIsPresent(keyLblToogleIndicator5);
            verify.elementIsPresent(keyBtnNext);
            verify.elementTextMatching(keyBtnNext, "NEXT");
        verify.elementAttributeMatching(keyLblToogleIndicator1,"selected","false");
        verify.elementAttributeMatching(keyLblToogleIndicator2,"selected","false");
        verify.elementAttributeMatching(keyLblToogleIndicator3,"selected","true");
        verify.elementAttributeMatching(keyLblToogleIndicator4,"selected","false");
        verify.elementAttributeMatching(keyLblToogleIndicator5,"selected","false");
        }
        else
        {
            verify.elementTextMatching(keyLblPageContent, "Nam porttitor blandit accumsan. Ut vel dictum sem, a pretium dui.");
            verify.elementIsPresent(keyImgWelcome);
            verify.elementIsPresent(keyLblToogleIndicator3);
            verify.elementIsPresent(keyBtnNext);
            verify.elementTextMatching(keyBtnNext, "NEXT");
            verify.elementAttributeMatching(keyLblToogleIndicator3,"enabled","true");

        }
        WAIT.forSeconds(2);

    }
    public void welcomepagefour() throws ApplicationException {

        if(Device.isAndroid()) {
            verify.elementTextMatching(keyLblPageContent, "Nam porttitor blandit accumsan. Ut vel dictum sem, a pretium dui.");
            verify.elementIsPresent(keyImgWelcome);
       verify.elementIsPresent(keyLblToogleIndicator1);
        verify.elementIsPresent(keyLblToogleIndicator2);
        verify.elementIsPresent(keyLblToogleIndicator3);
        verify.elementIsPresent(keyLblToogleIndicator4);
        verify.elementIsPresent(keyLblToogleIndicator5);
            verify.elementIsPresent(keyBtnNext);
            verify.elementTextMatching(keyBtnNext, "NEXT");
        verify.elementAttributeMatching(keyLblToogleIndicator1,"selected","false");
        verify.elementAttributeMatching(keyLblToogleIndicator2,"selected","false");
        verify.elementAttributeMatching(keyLblToogleIndicator3,"selected","false");
        verify.elementAttributeMatching(keyLblToogleIndicator4,"selected","true");
        verify.elementAttributeMatching(keyLblToogleIndicator5,"selected","false");
        }
        else
        {
            verify.elementTextMatching(keyLblPageContent, "Nam porttitor blandit accumsan. Ut vel dictum sem, a pretium dui.");
            verify.elementIsPresent(keyImgWelcome);
            verify.elementIsPresent(keyLblToogleIndicator4);
            verify.elementIsPresent(keyBtnNext);
            verify.elementTextMatching(keyBtnNext, "NEXT");
            verify.elementAttributeMatching(keyLblToogleIndicator4,"enabled","true");

        }
        WAIT.forSeconds(2);

    }

    public void welcomepagefive() throws ApplicationException {
        if(Device.isAndroid()) {
            verify.elementTextMatching(keyLblPageContent, "Nam porttitor blandit accumsan. Ut vel dictum sem, a pretium dui.");
            verify.elementIsPresent(keyImgWelcome);
        verify.elementIsPresent(keyLblToogleIndicator1);
        verify.elementIsPresent(keyLblToogleIndicator2);
        verify.elementIsPresent(keyLblToogleIndicator3);
        verify.elementIsPresent(keyLblToogleIndicator4);
        verify.elementIsPresent(keyLblToogleIndicator5);
            verify.elementIsPresent(keyBtnNext);
            verify.elementTextMatching(keyBtnNext, "GET STARTED");
        verify.elementAttributeMatching(keyLblToogleIndicator1,"selected","false");
        verify.elementAttributeMatching(keyLblToogleIndicator2,"selected","false");
        verify.elementAttributeMatching(keyLblToogleIndicator3,"selected","false");
        verify.elementAttributeMatching(keyLblToogleIndicator4,"selected","false");
        verify.elementAttributeMatching(keyLblToogleIndicator5,"selected","true");
        }
        else
        {
            verify.elementTextMatching(keyLblPageContent, "Nam porttitor blandit accumsan. Ut vel dictum sem, a pretium dui.");
            verify.elementIsPresent(keyImgWelcome);
            verify.elementIsPresent(keyLblToogleIndicator5);
            verify.elementIsPresent(keyBtnNext);
            verify.elementTextMatching(keyBtnNext, "GET STARTED");
            verify.elementAttributeMatching(keyLblToogleIndicator5,"enabled","true");

        }
        WAIT.forSeconds(2);

    }

    public void clickWelcomePageNextBtn() throws ApplicationException {
        click.elementBy(keyBtnNext);
        WAIT.forSeconds(4);
    }



}
