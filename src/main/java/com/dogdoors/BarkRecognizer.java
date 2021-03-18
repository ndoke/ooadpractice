package com.dogdoors;

import java.util.List;

public class BarkRecognizer {
    public static boolean recognizeBark(Bark bark, List<Bark> allowedBarks) {
        for (Bark b : allowedBarks) {
            if (b == bark) {
                return true;
            }
        }

        System.out.println("BarkRecognizer not recognized..");
        System.out.println("Door won't open.");
        return false;
    }
}
