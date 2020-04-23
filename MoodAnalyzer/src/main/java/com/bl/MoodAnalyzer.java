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

    public String analyzeMood(String message) {
        if (message.equals( "im in sad mood" )) {
            return "SAD";
        } else if (message.equals( "im in happy mood" )) {
            return "HAPPY";
        } else {
            return "SAD";
        }
    }
    public String analyzeMood() {
        return analyzeMood( this.message );
    }
}
