package com.mhacard.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class DateTimeUtil {
    public static String dateTimeZoneToDate(String dateData) {
      
        String[] dateOrigin = dateData.split("T");
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyy", Locale.ENGLISH);
        LocalDate date = LocalDate.parse(dateOrigin[0], inputFormatter);
        return outputFormatter.format(date);
    }

    public static Date strToDate(String date) throws Exception{
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(date);  
        return date1;
    }

    public static Date toYYYYMMdd(String startDateString) throws Exception{
        //String startDateString = "08-12-2017";
        String[] arrDate = startDateString.split("-");
        String newDateFormat = arrDate[2] + "-" + arrDate[1] + "-" + arrDate[0];
        System.out.print(newDateFormat);
        DateFormat yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd");

        Date date =(Date)yyyyMMdd.parse(newDateFormat);

        return date;
    }

   
}
