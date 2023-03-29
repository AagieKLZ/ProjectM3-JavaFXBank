package com.mycompany.projectm3;

import java.util.Random;
public class RandomNumberGenerator {
    private Random random = new Random();
    public static long generateCardNumber(){
        Random random = new Random();
        long number = (long) (random.nextDouble() * 9000000000000000L) + 1000000000000000L;
        return number;
    }

    public static int generateSecurityNumber(){
        Random random = new Random();
        return random.nextInt(900) + 100;
    }


}
