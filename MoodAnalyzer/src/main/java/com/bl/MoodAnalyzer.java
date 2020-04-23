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

    public String analyzeMood() {

        if (message == null) {
            return "HAPPY";
        } else if (message.equals( "im in sad mood" )) {
            return "SAD";
        } else if (message.equals( "im in happy mood" )) {
            return "SAD";
        } else {
            return "HAPPY";
        }
    }
}