package com.bl;

public class MoodAnalyzer extends MoodAnalyzerException {

    String message;

    public MoodAnalyzer() {
//        this.message = "HAPPY";
    }
    public MoodAnalyzer(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

    public String analyzeMood(String message) throws MoodAnalyzerException {
        try {
            if (message.equals( "" )) {
                throw new MoodAnalyzerException( ExceptionEnum.EMPTY.getExceptionMessage() );
            }
            if (message.equals( "im in happy mood" )) {
                return "HAPPY";
            } else {
                return "SAD";
            }
        } catch (NullPointerException e) {
            throw new MoodAnalyzerException( ExceptionEnum.NULL.getExceptionMessage() );
        }
    }
    public String analyzeMood() throws MoodAnalyzerException {
        return analyzeMood( this.message );
    }
    @Override
    public boolean equals(Object obj) {
        MoodAnalyzer moodAnalyzer = (MoodAnalyzer) obj;
        if ((this.message == null) && (moodAnalyzer.message == null)) {
            return true;
        }
        return this.message.equals( moodAnalyzer.message );
    }
    @Override
    public String toString() {
        return "MoodAnalyzer{" +
                "message='" + message + '\'' +
                '}';
    }     
}