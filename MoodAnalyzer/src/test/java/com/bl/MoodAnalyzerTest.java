package com.bl;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {
    @Test
    public void given_Message_whenHappyOrSad_ShouldReturnHappyOrSad() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        String message = moodAnalyzer.analyzeMood( "i am in sad mood" );
        Assert.assertEquals( "SAD", message );
    }
}