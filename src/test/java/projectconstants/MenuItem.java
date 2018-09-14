package projectconstants;

import helper.Device;

public final class MenuItem {

    public static String MyCard(){
        return "My Card";
    }
    public static String CardTransfer(){
        if(Device.isAndroid())
            {
                return "Card transfer";
            }
        else
            {
            return "Card Transfer";
            }
    }
    public static String CurrencyConverter(){
        return "Currency Converter";
    }
    public static String Beneficiaries(){
        return "Beneficiaries";
    }
    public static String Settings(){
        return "Settings";
    }
    public static String LoadPartners(){
        return "Load Partners";
    }
    public static String DistributionPartners() {
        return "Distribution Partners";
    }
    public static String More(){
        return "More";
    }
}
