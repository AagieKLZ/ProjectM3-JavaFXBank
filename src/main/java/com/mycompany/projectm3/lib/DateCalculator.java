package com.mycompany.projectm3.lib;

import java.util.Calendar;
import java.util.Date;

public class DateCalculator {
    public static Date addYears(int years){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, years);
        return calendar.getTime();
    }

    public static boolean isValid(Date date){
        Calendar calendar = Calendar.getInstance();
        Date current = calendar.getTime();
        return current.after(date);
    }

    public static String timeToString(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-" + calendar.get(Calendar.DAY_OF_MONTH);
    }
}
