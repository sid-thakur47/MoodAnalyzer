package com.bl;

public class MoodAnalyzer {

    String message;

    public MoodAnalyzer() {
    }

    public MoodAnalyzer(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
    public String setMessage(String message) {
        this.message = message;
        return message;
    }

    public String analyzeMood() {
        if (message.equals( "im in sad mood" )) {
            return "SAD";
        } else {
            return "HAPPY";
        }
    }
}