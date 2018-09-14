package pages;

import base.Keywords;
import exceptions.ApplicationException;
import xpath.Matching;

public class PageFAQ extends Keywords {

    private String keyLblPageTitle = "Getgo.FAQ.LblPageTitle";
    private String keyBtnClose = "Getgo.FAQ.BtnClose";
    private String keyLblPageContent = "Getgo.FAQ.LblPageContent";
    private String keyBtnquestion1 = "Getgo.FAQ.Btnquestion1";
    private String keyBtnquestion2 = "Getgo.FAQ.Btnquestion2";
    private String keyBtnquestion3 = "Getgo.FAQ.Btnquestion3";


    private String keyLblquestion1firstblock = "Getgo.TAC.Lblquestion1firstblock";
    private String keyLblquestion1secondblock = "Getgo.TAC.Lblquestion1secondblock";

    private String keyLblquestion2content = "Getgo.TAC.Lblquestion2content";
    private String keyLblquestion2firstlist = "Getgo.TAC.Lblquestion2firstlist";
    private String keyLblquestion2secondlist = "Getgo.TAC.Lblquestion2secondlist";
    private String keyLblquestion2thirdlist = "Getgo.TAC.Lblquestion2thirdlist";
    private String keyLblquestion2fourthlist = "Getgo.TAC.Lblquestion2fourthlist";
    private String keyLblquestion2fifthlist = "Getgo.TAC.Lblquestion2fifthlist";
    private String keyLblquestion2sixthlist = "Getgo.TAC.Lblquestion2sixthlist";
    private String keyLblquestion2seventhlist = "Getgo.TAC.Lblquestion2seventhlist";
    private String keyLblquestion2eightlist = "Getgo.TAC.Lblquestion2eightlist";
    private String keyLblquestion2ninelist = "Getgo.TAC.Lblquestion2ninelist";
    private String keyLblquestion2tenlist = "Getgo.TAC.Lblquestion2tenlist";
    private String keyLblquestion2elevenlist = "Getgo.TAC.Lblquestion2elevenlist";
    private String keyLblquestion2twelvelist = "Getgo.TAC.Lblquestion2twelvelist";
    private String keyLblquestion2thirteenlist = "Getgo.TAC.Lblquestion2thirteenlist";
    private String keyLblquestion2fourteenlist = "Getgo.TAC.Lblquestion2fourteenlist";
    private String keyLblquestion2fifteenlist = "Getgo.TAC.Lblquestion2fifteenlist";
    private String keyLblquestion2sixteenlist ="Getgo.TAC.Lblquestion2sixteenlist";
    private String keyLblquestion2severteenlist ="Getgo.TAC.Lblquestion2severteenlist";
    private String keyLblquestion2eighteenlist ="Getgo.TAC.Lblquestion2eighteenlist";
    private String keyLblquestion2nighteenlist ="Getgo.TAC.Lblquestion2nighteenlist";
    private String keyLblquestion2twentylist ="Getgo.TAC.Lblquestion2twentylist";
    private String keyLblquestion2twentyonelist ="Getgo.TAC.Lblquestion2twentyonelist";
    private String keyLblquestion2twentytwolist ="Getgo.TAC.Lblquestion2twentytwolist";
    private String keyLblquestion2twentythreelist ="Getgo.TAC.Lblquestion2twentythreelist";

    private String keyLblquestion3content ="Getgo.TAC.Lblquestion3content";

    public void verifyPageTitle(String ititle) throws ApplicationException {
        WAIT.forSeconds(5);
            verify.elementTextContains(keyLblPageTitle, ititle);

    }
    public void doespagecontainsquestions() throws ApplicationException {
            verify.elementIsPresent(keyBtnClose);
            verify.elementIsPresent(keyLblPageContent);
            verify.elementIsPresent(keyBtnquestion1);
            verify.elementIsPresent(keyBtnquestion2);
            verify.elementIsPresent(keyBtnquestion3);
        }


    public void verifyfirstquestion() throws ApplicationException {

        click.elementBy(keyBtnquestion1);
        verify.elementIsPresent(keyLblquestion1firstblock);
        verify.elementIsPresent(keyLblquestion1secondblock);
        click.elementBy(keyBtnquestion1);
    }


    public void verifysecondquestion() throws ApplicationException {


        click.elementBy(keyBtnquestion2);
        swipe.vertical(2,0.8,0.6,3);

        verify.elementIsPresent(keyLblquestion2content);
        verify.elementIsPresent(keyLblquestion2firstlist);
        verify.elementIsPresent(keyLblquestion2secondlist);
        verify.elementIsPresent(keyLblquestion2thirdlist);
        verify.elementIsPresent(keyLblquestion2fourthlist);
       // verify.elementIsPresent(keyLblquestion2fifthlist);
        verify.elementIsPresent(keyLblquestion2sixthlist);
        verify.elementIsPresent(keyLblquestion2seventhlist);
        verify.elementIsPresent(keyLblquestion2eightlist);
        //verify.elementIsPresent(keyLblquestion2ninelist);
        verify.elementIsPresent(keyLblquestion2tenlist);
        swipe.vertical(2,0.8,0.6,3);

        verify.elementIsPresent(keyLblquestion2elevenlist);
        verify.elementIsPresent(keyLblquestion2twelvelist);
        verify.elementIsPresent(keyLblquestion2thirteenlist);
        verify.elementIsPresent(keyLblquestion2fourteenlist);
        //verify.elementIsPresent(keyLblquestion2fifteenlist);
        verify.elementIsPresent(keyLblquestion2sixteenlist);
        swipe.vertical(2,0.8,0.6,3);

        verify.elementIsPresent(keyLblquestion2severteenlist);
        verify.elementIsPresent(keyLblquestion2eighteenlist);
        verify.elementIsPresent(keyLblquestion2nighteenlist);
        verify.elementIsPresent(keyLblquestion2twentylist);
        verify.elementIsPresent(keyLblquestion2twentyonelist);
        verify.elementIsPresent(keyLblquestion2twentytwolist);
        verify.elementIsPresent(keyLblquestion2twentythreelist);
        swipe.vertical(2,0.6,0.8,3);
        swipe.vertical(2,0.6,0.8,3);
        swipe.vertical(2,0.6,0.8,3);

        click.elementBy(keyBtnquestion2);
    }

    public void verifythirdquestion() throws ApplicationException {
        click.elementBy(keyBtnquestion3);
        verify.elementIsPresent(keyLblquestion3content);

        click.elementBy(keyBtnquestion3);

        WAIT.forSeconds(3);

    }

}


