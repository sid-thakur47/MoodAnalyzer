package com.bl;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {
    @Test
    public void given_Message_InConstructor_IamInSadMood_ShouldReturnSad() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer( "im in sad mood" );
        String mood = moodAnalyzer.analyzeMood();
        Assert.assertEquals( "SAD", mood );
    }
    @Test
    public void given_Message_InMethod_ShouldReturnSad() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        String mood = moodAnalyzer.analyzeMood( "im in sad mood" );
        Assert.assertEquals( "SAD", mood );
    }
    @Test
    public void given_Message_InConstructor_IamInHappyMood_ShouldReturnHappy() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer( "im in happy mood" );
        String mood = moodAnalyzer.analyzeMood();
        Assert.assertEquals( "HAPPY", mood );
    }
    @Test
    public void given_Message_InMethod_ShouldReturnHappy() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        String mood = moodAnalyzer.analyzeMood( "im in happy mood" );
        Assert.assertEquals( "HAPPY", mood );
    }
}