package com.bl;

import org.junit.Assert;
import org.junit.Test;

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
        try {
            MoodAnalyzer moodAnalyzer = MoodAnalyzerFactory.createMoodAnalyzer( "im in sad mood" );
            Assert.assertEquals( mood, moodAnalyzer );
        } catch (MoodAnalyzerException e) {
            System.out.println( e.toString() );
        }
    }
}

