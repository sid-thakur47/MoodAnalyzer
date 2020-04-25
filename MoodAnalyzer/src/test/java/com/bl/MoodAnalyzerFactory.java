package com.bl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerFactory {

    public static MoodAnalyzer createMoodAnalyzer(String className, String message, Class constName) {
        try {
            Class<?> moodAnalyzerClass = Class.forName( className );
            Constructor<?> moodAnalyzerConstructor = moodAnalyzerClass.getConstructor( constName );
            Object moodObj = moodAnalyzerConstructor.newInstance( message );
            return (MoodAnalyzer) moodObj;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
        } catch (ClassNotFoundException e) {
            throw new MoodAnalyzerException( MoodAnalyzerException.ExceptionEnum.WRONG_CLASS.getExceptionMessage() );
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyzerException( MoodAnalyzerException.ExceptionEnum.WRONG_METHOD.getExceptionMessage() );
        }
        return null;
    }
    public static MoodAnalyzer createMoodAnalyzer(String message) {
        return createMoodAnalyzer( "com.bl.MoodAnalyzer", message, String.class );
    }
}