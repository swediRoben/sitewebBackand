package com.site.siteweb.helpers;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date; 

public class DateHelper {
    private static String textConversion(Date date, String type) {
        String strDate = "";
        String format = "yyyy-MM-dd";

        if (type.equalsIgnoreCase("time")) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        if (date != null) {
            try {
                DateFormat dateFormat = new SimpleDateFormat(format);
                strDate = dateFormat.format(date);
            } catch (Exception e) {
                System.out.println("can not be converted to text:" + e.getMessage());
            }

        }
        return strDate;
    }

    public static Date toDate(String date_as_string) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date convert = null;
        try {
            if (date_as_string != null && !date_as_string.equals("")) {
                convert = format.parse(date_as_string);
            }
   
        } catch (ParseException e) {
            System.out.println("Fail to convert to date: " + e.getMessage());
        }
        return convert;
    }







    public static String toText(Date date) {
        return textConversion(date, "");
    }


    public static Date now() {
        Date date = new Date();
        return date;
    }

     public static LocalDate convertStringToLocalDate(String string) {
		return LocalDate.parse(string,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}

	public static boolean verifyDate(String dateDebut,String dateFin)
	{
		LocalDate date1=convertStringToLocalDate(dateDebut);
		LocalDate date2=convertStringToLocalDate(dateFin);

		 if(date1.isEqual(date2)) {
			return false;
		}else if (date1.isBefore(date2)) {
			return true;
		}else{
			return false;
		}
	}

}
