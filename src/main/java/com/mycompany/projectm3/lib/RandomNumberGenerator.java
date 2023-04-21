package com.mycompany.projectm3.lib;

import java.util.Random;

/**
 * Aux class to handle creation of random numbers
 */
public class RandomNumberGenerator {
    /**
     * Generates a random 16 digit card number
     * @return Random number
     */
    public static long generateCardNumber(){
        Random random = new Random();
        long number = (long) (random.nextDouble() * 9000000000000000L) + 1000000000000000L;
        return number;
    }

    /**
     * Generates a security number between 100 and 999
     * @return
     */
    public static int generateSecurityNumber(){
        Random random = new Random();
        return random.nextInt(900) + 100;
    }


}
