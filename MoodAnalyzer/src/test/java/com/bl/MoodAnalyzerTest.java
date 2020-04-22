package com.bl;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {
    @Test
    public void given_Message_IamInSadMood_ShouldReturnHappyOrSad() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        String message = moodAnalyzer.analyzeMood( "i am in sad mood" );
        Assert.assertEquals( "SAD", message );
    }
    @Test
    public void given_Message_IamInAnyMood_ShouldReturnHappy() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        String message = moodAnalyzer.analyzeMood( "i am in any mood" );
        Assert.assertEquals( "HAPPY", message );
    }
}