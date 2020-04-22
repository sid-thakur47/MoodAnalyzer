package com.bl;

public class MoodAnalyzer {
    public String analyzeMood(String message) {
        if (message.equals( "i am in sad mood" )) {
            return "SAD";
        } else {
            return "HAPPY";
        }
    }
}