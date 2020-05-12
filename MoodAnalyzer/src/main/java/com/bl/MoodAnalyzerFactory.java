package com.bl;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MoodAnalyzerFactory {

    public static MoodAnalyzer createMoodAnalyzer(String className, String message, Class constName) {
        try {
            Class<?> moodAnalyzerClass = Class.forName( className );
            Constructor<?> moodAnalyzerConstructor = moodAnalyzerClass.getConstructor( constName );
            Object moodObj = moodAnalyzerConstructor.newInstance( message );
            return (MoodAnalyzer) moodObj;
        } catch (MoodAnalyzerException e) {
            throw new MoodAnalyzerException( MoodAnalyzerException.ExceptionEnum.EMPTY.getExceptionMessage() );
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
    public static MoodAnalyzer createMoodAnalyzer() {
        return createMoodAnalyzer( "com.bl.MoodAnalyzer", "im in happy mood", String.class );
    }

    public static String factoryMethod(MoodAnalyzer moodAnalyzerReflection, String methodName) throws InvocationTargetException {
        try {
            Method method = moodAnalyzerReflection.getClass().getDeclaredMethod( methodName );
            return (String) method.invoke( moodAnalyzerReflection );
        } catch (NoSuchMethodException | IllegalAccessException e) {
            throw new MoodAnalyzerException( MoodAnalyzerException.ExceptionEnum.WRONG_METHOD.getExceptionMessage() );
        }
    }
    public static String changeMood(MoodAnalyzer moodAnalyzerReflection, String message, String fieldName) throws InvocationTargetException {
        try {
            Field field = moodAnalyzerReflection.getClass().getDeclaredField( fieldName );
            field.set( moodAnalyzerReflection, message );
            return factoryMethod( moodAnalyzerReflection, "analyzeMood" );
        } catch (NullPointerException e) {
            throw new MoodAnalyzerException( MoodAnalyzerException.ExceptionEnum.NULL_FILED.getExceptionMessage() );
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new MoodAnalyzerException( MoodAnalyzerException.ExceptionEnum.WRONG_FIELD.getExceptionMessage() );
        }
    }
}