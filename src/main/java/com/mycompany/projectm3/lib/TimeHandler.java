package com.mycompany.projectm3.lib;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Aux class to handle timestamps
 */
public class TimeHandler {
    /**
     * Converts a timestamp to a string
     * @param timestamp
     * @return String with the timestamp in the format YYYY-MM-DDTHH:MM:SS
     */
    public static String timestampToString(long timestamp) {
        Date date = new Date(timestamp);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(date);
    }

    /**
     * Gets the current timestamp
     * @return Current timestamp
     */
    public static long getCurrentTimestamp(){
        return System.currentTimeMillis();
    }
}
