package pages;

import base.Keywords;
import base.Test;
import com.cucumber.listener.Reporter;
import constants.Keys;
import constants.OS;
import exceptions.ApplicationException;
import helper.Device;
import org.junit.Assert;
import xpath.Matching;

import java.text.ParseException;

public class PageSettings extends Keywords {

    private String keySettingsPageTitle="Getgo.Settings.LblTitle";
    private String keyPasswordOption="Getgo.Settings.LblPassword";
    private String keyMenuBtn="Getgo.Settings.Menu";



    public void verifyPageTitle(String ititle) throws ApplicationException {
        if(Device.isAndroid()) {
            verify.elementTextMatching(xpathOf.textView(Matching.text("Settings")), ititle);
        }
        else
        {
            verify.elementTextMatching(xpathOf.textView(Matching.name("Settings")), ititle);
        }

        WAIT.forSeconds(5);
    }

    public void clickPasswordOption() throws ApplicationException {


        if(Device.isAndroid()) {
            click.elementBy(xpathOf.textView(Matching.text("Password")));
        }
        else
        {
            click.elementBy(xpathOf.textView(Matching.name("Password")));
        }
    }


    public void clickOption(String ioptions) throws ApplicationException {

        click.elementBy(xpathOf.textView(Matching.youDecide(ioptions)));

    }

    public void clickMenu() throws ApplicationException {
      click.elementBy(keyMenuBtn);

    }

}