package com.bl;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {
    @Test
    public void given_Message_IamInSadMood_ShouldReturnSad() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer( "im in sad mood" );
        String mood = moodAnalyzer.analyzeMood();
        System.out.println( "sad mood:" + mood );
        Assert.assertEquals( "SAD", mood );
    }
    /*@Test
        public void Not_given_MessageShouldReturnSad() {
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
            String mood = moodAnalyzer.analyzeMood();
            System.out.println("sad mood:"+mood);
            Assert.assertEquals( "SAD", mood );
        }*/
    @Test
    public void given_Message_IamInHappyMood_ShouldReturnHappy() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer( "im in happy mood" );
        String mood = moodAnalyzer.analyzeMood();
        System.out.println( "Happy mood:" + mood );
        Assert.assertEquals( "SAD", mood );
    }
    @Test
    public void not_Given_Message_ShouldReturnHappy() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        String mood = moodAnalyzer.analyzeMood();
        System.out.println( "Mood is:" + mood );
        Assert.assertEquals( "HAPPY", mood );
    }
}