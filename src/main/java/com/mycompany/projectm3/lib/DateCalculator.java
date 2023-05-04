package com.mycompany.projectm3.lib;

import java.util.Calendar;
import java.util.Date;

/**
 * Aux class to handle dates
 */
public class DateCalculator {
    /**
     * Adds years to the current date
     * @param years
     * @return Date with the years added
     */
    public static Date addYears(int years){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, years);
        return calendar.getTime();
    }

    /**
     * Checks if the date is before the current date
     * @param date
     * @return true if the date is before the current date
     */
    public static boolean isValid(Date date){
        Calendar calendar = Calendar.getInstance();
        Date current = calendar.getTime();
        return current.after(date);
    }

    /**
     * Converts a date to a string
     * @param date
     * @return String with the date in the format YYYY-MM-DD
     */
    public static String timeToString(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-" + calendar.get(Calendar.DAY_OF_MONTH);
    }
}
