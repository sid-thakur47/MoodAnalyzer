package com.bl;

import java.io.IOException;

public class MoodAnalyzer {

    String message;

    public MoodAnalyzer()  {
        this.message="HAPPY";
    }
    public MoodAnalyzer(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

    public String analyzeMood(String message) {
        try {
            if (message.equals( "im in happy mood" )) {
                return "HAPPY";
            } else {
                return "SAD";
            }
        } catch (NullPointerException e) {
            return "HAPPY";
        }
    }
    public String analyzeMood() {
        return analyzeMood( this.message );
    }
}