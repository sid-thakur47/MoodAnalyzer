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
    @Test
    public void givenWithDefaultConstMoodAnalyzerClass_WhenProper_ShouldReturnObject() {
        MoodAnalyzer mood = new MoodAnalyzer( "im in sad mood" );
        MoodAnalyzer moodAnalyzer = MoodAnalyzerFactory.createMoodAnalyzer( "im in sad mood" );
        Assert.assertEquals( mood, moodAnalyzer );
    }

    @Test
    public void givenClass_WhenImproper_Should_ThrowsMoodAnalyzerException() {
        try {
            MoodAnalyzerFactory.createMoodAnalyzer( "com.mood", "im in sad mood", String.class );
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals( "no such class error", e.getMessage() );
        }
    }
    @Test
    public void givenConstructor_WhenImproper_Should_ThrowException() {
        try {
            MoodAnalyzerFactory.createMoodAnalyzer( "com.bl.MoodAnalyzer", "im in sad mood", Integer.class );
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals( "no such method error", e.getMessage() );
        }
    }
    @Test
    public void givenWithConstMoodAnalyzerClass_WhenProper_ShouldReturnObject() {
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
        }
    }
    @Test
    public void givenConstructor_WhenImproper_Should_ThrowsMoodAnalyzerException() {
        try {
            MoodAnalyzerFactory.createMoodAnalyzer( "com.bl.MoodAnalyzer", "im in sad mood", Integer.class );
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals( "no such method error", e.getMessage() );
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
    public void givenHappyMethodInReflection_WhenImProper_Should_ReturnHappy() {
        try {
            MoodAnalyzer moodAnalyzerReflection = MoodAnalyzerFactory.createMoodAnalyzer();
            MoodAnalyzerFactory.factoryMethod( moodAnalyzerReflection, "analyzeMood" );
        } catch (MoodAnalyzerException | InvocationTargetException e) {
            Assert.assertEquals( "no such method error", e.getMessage() );
        }
    }
    @Test
    public void givenHappyMessageInReflection_WhenImProper_Should_ReturnHappy() {
        try {
            MoodAnalyzer moodAnalyzerReflection = MoodAnalyzerFactory.createMoodAnalyzer();
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals( "Mood cannot be empty", e.getMessage() );
        }
    }
    @Test
    public void settingHappyMessageWithReflector_Should_ReturnHappy() throws InvocationTargetException {
        MoodAnalyzer moodAnalyzerReflection = MoodAnalyzerFactory.createMoodAnalyzer();
        String field = MoodAnalyzerFactory.changeMood( moodAnalyzerReflection, "im in happy mood", "message" );
        Assert.assertEquals( "HAPPY", field );
    }
    @Test
    public void field_WhenSetImproper_Should_ThrowMoodAnalyzerException() {
        try {
            MoodAnalyzer moodAnalyzerReflection = MoodAnalyzerFactory.createMoodAnalyzer();
            MoodAnalyzerFactory.changeMood( moodAnalyzerReflection, "im in happy mood", "abc" );
        } catch (MoodAnalyzerException | InvocationTargetException e) {
            Assert.assertEquals( "no such field", e.getMessage() );
        }
    }
    @Test
    public void settingNullMessage_Should_ThrowMoodAnalyzerException() {
        try {
            MoodAnalyzer moodAnalyzerReflection = MoodAnalyzerFactory.createMoodAnalyzer();
            MoodAnalyzerFactory.changeMood( moodAnalyzerReflection, "im in happy mood", null );
        } catch (MoodAnalyzerException | InvocationTargetException e) {
            Assert.assertEquals( "field cannot be null", e.getMessage() );
        }
    }
}
