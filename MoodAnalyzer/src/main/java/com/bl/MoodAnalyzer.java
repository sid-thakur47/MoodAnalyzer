package com.bl;

public class MoodAnalyzer {
    public String analyzeMood(String message) {
        if (message.equals( "happy" )) {
            return "happy";
        } else {
            return "sad";
        }
    }
}