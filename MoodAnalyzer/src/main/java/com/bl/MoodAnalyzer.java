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
        try {
            if (message.equals( "im in sad mood" )) {
                return "SAD";
            } else {
                return "HAPPY";
            }
        } catch (NullPointerException e) {
            return "SAD";
        }
    }
}