package pages;

import base.Keywords;
import exceptions.ApplicationException;
import helper.Device;

public class PageVirtualCardRegistrationReview extends Keywords {

    private String keyLblEmailAddress="Getgo.CreateVirtualCardReview.LblEmailAddress";
    private String keyLblFullName="Getgo.CreateVirtualCardReview.LblFullName";
    private String keyLblDOB="Getgo.CreateVirtualCardReview.LblDOB";
    private String keyLblNationality="Getgo.CreateVirtualCardReview.LblNationality";
    private String keyLblGender="Getgo.CreateVirtualCardReview.LblGender";
    private String keyLblMobile="Getgo.CreateVirtualCardReview.LblMobile";
    private String keyBtnSubmit="Getgo.CreateVirtualCardReview.BtnSubmit";


    public void reviewDetails(String emailID,String fullName,String dob, String mobile, String nationality, String gender) throws ApplicationException {
        if(Device.isAndroid()) {
            verify.elementTextMatching(keyLblEmailAddress, emailID);
            verify.elementTextMatching(keyLblFullName, fullName);
            swipe.vertical(2, 0.9, 0.4);
            verify.elementTextMatching(keyLblDOB, dob);
            verify.elementTextMatching(keyLblMobile, mobile);
            verify.elementTextMatching(keyLblNationality, nationality);
            verify.elementTextMatching(keyLblGender, gender);
        }
        else
        {
            verify.elementTextMatching(keyLblEmailAddress,emailID);
            verify.elementTextMatching(keyLblFullName,fullName);
            swipe.vertical(2,0.9,0.4);
            ////need to check the dob review
            String idob=verify.verifyDOBinreviewpage(dob);
            verify.elementTextMatching(keyLblDOB,idob);

            verify.elementTextMatching(keyLblMobile,mobile);
            verify.elementTextMatching(keyLblNationality,nationality);
            //verify.elementTextMatching(keyLblGender,gender);
        }
    }

    public void clickSubmit() throws ApplicationException {
        click.elementBy(keyBtnSubmit);
        WAIT.forSeconds(2);
    }
}
