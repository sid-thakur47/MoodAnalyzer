package com.bl;

public class MoodAnalyzerException extends Exception {
    String message;

    public MoodAnalyzerException() {
    }

    public MoodAnalyzerException(String message) {
        super( message );
    }
    public enum ExceptionEnum {
        EMPTY( "Mood cannot be empty" ), NULL( "Mood cannot be null" );

        private final String exceptions;
        ExceptionEnum(String exceptions) {
            this.exceptions = exceptions;
        }
        public String getExceptionMessage() {
            return exceptions;
        }
    }
}
