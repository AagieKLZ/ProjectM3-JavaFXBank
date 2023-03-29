package com.mycompany.projectm3;

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
}
