package helper;

import java.text.*;
import java.time.LocalDateTime;
import java.util.*;

public class Tools {

    private Random random = new Random(System.currentTimeMillis());

    public String REMOVE_MULTIPLE_SPACES_AND_NEW_LINES(String text){
        String i = text.replace("\n"," ").replaceAll("\\s{2,}", " ").replaceAll("\\u00A0","").trim();
        return i;
    }

    public String nbspRemove(String text)
    {
        return text.trim().replaceAll("\\u00A0","");
    }

    public String convertToLetterCase(String text) {
        String firstLetter = text.substring(0,1);
        String exceptFirstLetter = text.substring(1,text.length());
        return firstLetter.toUpperCase() + exceptFirstLetter.toLowerCase();
    }

    public ArrayList<String> getDate(String date)
    {
        ArrayList<String> i = new ArrayList<>(3);
        LocalDateTime now = LocalDateTime.now();
        String day = date.trim().replace("today","");
        if(day.equalsIgnoreCase(""))
        {
            i.add(Integer.toString(now.getDayOfMonth()));
            i.add(Integer.toString(now.getMonthValue()));
            i.add(Integer.toString(now.getYear()));
        }else{
            long d = Integer.parseInt(day.replace("+",""));
            i.add(Integer.toString(now.plusDays(d).getDayOfMonth()));
            i.add(Integer.toString(now.plusDays(d).getMonthValue()));
            i.add(Integer.toString(now.plusDays(d).getYear()));
        }
        return i;
    }

    public String fixAmountIssue(String amount){
        String[] amtSplit=amount.split(" ");
        String amt=amtSplit[0]+" "+amtSplit[amtSplit.length-1];
        return amt;
    }

    public String pesoAmount(double amount)
    {
        NumberFormat n = NumberFormat.getCurrencyInstance(Locale.CHINA);
        String s = n.format(amount / 1);
        return s.replaceAll("￥","PHP ");
    }

    public String getDateInFormat(String day,String month,String year,String format) throws ParseException {
        String inputPattern="yyyy-M-dd";
        if(month.trim().length()>1){
            inputPattern="yyyy-MM-dd";
        }
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern); // or "YYYY-MM-DDThh:mm:ss±0000"
        String dateInString = year+"-"+month+"-"+day;
        Date date = inputFormat.parse(dateInString);
        SimpleDateFormat outputFormat = new SimpleDateFormat(format);
        return outputFormat.format(date);
    }

    public String currencyFormatter(double amount){
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        DecimalFormatSymbols decimalFormatSymbols = ((DecimalFormat) nf).getDecimalFormatSymbols();
        decimalFormatSymbols.setCurrencySymbol("");
        ((DecimalFormat) nf).setDecimalFormatSymbols(decimalFormatSymbols);
        return nf.format(amount).trim();
    }

    public String upto2Decimals(String amount){
        return new DecimalFormat("#0.00").format(amount);
    }




    public String cardgenerator(String bin, int length) {

                int randomNumberLength = length - (bin.length() + 1);

                StringBuilder builder = new StringBuilder(bin);
                for (int i = 0; i < randomNumberLength; i++) {
                    int digit = this.random.nextInt(10);
                    builder.append(digit);
                }

                // Do the Luhn algorithm to generate the check digit.
                int checkDigit = this.getCheckDigit(builder.toString());
                builder.append(checkDigit);

                return builder.toString();
            }


            private int getCheckDigit(String number) {


                int sum = 0;
                for (int i = 0; i < number.length(); i++) {

                    // Get the digit at the current position.
                    int digit = Integer.parseInt(number.substring(i, (i + 1)));

                    if ((i % 2) == 0) {
                        digit = digit * 2;
                        if (digit > 9) {
                            digit = (digit / 10) + (digit % 10);
                        }
                    }
                    sum += digit;
                }

                // The check digit is the number required to make the sum a multiple of
                // 10.
                int mod = sum % 10;
                return ((mod == 0) ? 0 : 10 - mod);
            }


    public String DisplayMonthFully(String idata) {


        String selectdata[]=idata.split(" ");
        String month=selectdata[0];
        String date=selectdata[1];
        String year=selectdata[2];

        HashMap<String,String> map=new LinkedHashMap<String,String>();
        map.put("Jan","January");
        map.put("Feb","February");
        map.put("Mar","March");
        map.put("Apr","April");
        map.put("May","May");
        map.put("Jun","June");
        map.put("Jul","July");
        map.put("Aug","August");
        map.put("Sep","September");
        map.put("Oct","October");
        map.put("Nov","November");
        map.put("Dec","December");

        return map.get(month)+" "+date+" "+year;


    }
}