package com.bl;

public class MoodAnalyzer extends MoodAnalyzerException {

    String message;

    public MoodAnalyzer() {
        this.message = "HAPPY";
    }
    public MoodAnalyzer(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

    public String analyzeMood(String message) throws MoodAnalyzerException {
        try {
            if (message.equals( " " )) {
                throw new MoodAnalyzerException( ExceptionEnum.EMPTY,"Mood cannot be empty");

            }
            if (message.equals( "im in happy mood" )) {
                return "HAPPY";
            } else {
                return "SAD";
            }
        } catch (NullPointerException e) {
            throw new MoodAnalyzerException( ExceptionEnum.NULL,"Mood cannot be null");
        }
    }
    public String analyzeMood() throws MoodAnalyzerException {
        return analyzeMood( this.message );
    }
}