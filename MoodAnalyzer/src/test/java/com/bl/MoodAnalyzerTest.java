package com.bl;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerTest {
    @Test
    public void given_Message_InConstructor_IamInSadMood_ShouldReturnSad() throws MoodAnalyzerException {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer( "im in sad mood" );
        String mood = moodAnalyzer.analyzeMood();
        Assert.assertEquals( "SAD", mood );
    }
    @Test
    public void given_Message_InMethod_ShouldReturnSad() throws MoodAnalyzerException {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        String mood = moodAnalyzer.analyzeMood( "im in sad mood" );
        Assert.assertEquals( "SAD", mood );
    }
    @Test
    public void given_Message_InConstructor_IamInHappyMood_ShouldReturnHappy() throws MoodAnalyzerException {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer( "im in happy mood" );
        String mood = moodAnalyzer.analyzeMood();
        Assert.assertEquals( "HAPPY", mood );
    }
    @Test
    public void given_Message_InMethod_ShouldReturnHappy() throws MoodAnalyzerException {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        String mood = moodAnalyzer.analyzeMood( "im in happy mood" );
        Assert.assertEquals( "HAPPY", mood );
    }
    @Test
    public void given_Null_ShouldReturn_NullExceptionMessage() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        try {
            String mood = moodAnalyzer.analyzeMood( null );
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals( "Mood cannot be null", e.getMessage() );
        }
    }
    @Test
    public void given_Empty_ShouldReturn_EmptyExceptionMessage() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        try {
            String mood = moodAnalyzer.analyzeMood( "" );
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals( "Mood cannot be empty", e.getMessage() );
        }
    }
    //5.1
    @Test
    public void givenWithDefaultConstMoodAnalyzerClass_WhenProper_ShouldReturnObject() {
        MoodAnalyzer mood = new MoodAnalyzer( "im in happy mood" );
        MoodAnalyzer moodAnalyzer = MoodAnalyzerFactory.createMoodAnalyzer( "im in happy mood" );
        Assert.assertEquals( mood, moodAnalyzer );
    }
    @Test
    public void givenClassName_WhenImproper_Should_ThrowsMoodAnalyzerException() {
        try {
            MoodAnalyzerFactory.createMoodAnalyzer( "com.mood", "im in sad mood", String.class );
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals( "no such class error", e.getMessage() );
            System.out.println( e.toString() );
        }
    }
    @Test
    public void givenConstructor_WhenImproper_Should_ThrowsMoodAnalyzerException() {
        try {
            MoodAnalyzerFactory.createMoodAnalyzer( "com.bl.MoodAnalyzer", "im in sad mood", Integer.class );
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals( "no such method error", e.getMessage() );
            System.out.println( e.toString() );
        }
    }
    @Test
    public void givenHappyMessageInReflection_WhenProper_Should_ReturnHappy() {
        try {
            MoodAnalyzer moodAnalyzerReflection = MoodAnalyzerFactory.createMoodAnalyzer( "im in happy mood" );
            String mood = MoodAnalyzerFactory.factoryMethod( moodAnalyzerReflection, "analyzeMood" );
            Assert.assertEquals( "HAPPY", mood );
        } catch (MoodAnalyzerException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenHappyMessageInReflection_WhenImProper_Should_ReturnHappy() {
        try {
            MoodAnalyzer moodAnalyzerReflection = MoodAnalyzerFactory.createMoodAnalyzer( "" );
            String mood = MoodAnalyzerFactory.factoryMethod( moodAnalyzerReflection, "analyzeMookkkd" );
        }catch (InvocationTargetException e){
            Assert.assertEquals( "Mood cannot be empty",e.getTargetException().getMessage() );
        }
        catch (MoodAnalyzerException e) {
            Assert.assertEquals( "no such method error", e.getMessage() );
            System.out.println( e.toString() );
        }
    }
}
