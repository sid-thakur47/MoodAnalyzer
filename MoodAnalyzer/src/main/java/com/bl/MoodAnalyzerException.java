package com.bl;

public class MoodAnalyzerException extends RuntimeException {
    String message;

    public MoodAnalyzerException() {
    }

    public MoodAnalyzerException(String message) {
        super( message );
    }
    public enum ExceptionEnum {
        EMPTY( "Mood cannot be empty" ),
        NULL( "Mood cannot be null" ),
        WRONG_CLASS( "no such class error" ),
        WRONG_METHOD( "no such method error" ),
        WRONG_FIELD("no such field");

        private final String exceptions;
        ExceptionEnum(String exceptions) {
            this.exceptions = exceptions;
        }
        public String getExceptionMessage() {
            return exceptions;
        }
    }  
}