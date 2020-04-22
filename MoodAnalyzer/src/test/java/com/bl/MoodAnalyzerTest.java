package com.bl;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {
    @Test
    public void given_Message_IamInSadMood_ShouldReturnSad() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer( "im in sad mood" );
        String mood = moodAnalyzer.analyzeMood();
        Assert.assertEquals( "SAD", mood );
    }
    @Test
    public void given_Message_IamInAnyMood_ShouldReturnHappy() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer( "im in any mood" );
        String mood = moodAnalyzer.analyzeMood();
        Assert.assertEquals( "HAPPY", mood );
    }
}