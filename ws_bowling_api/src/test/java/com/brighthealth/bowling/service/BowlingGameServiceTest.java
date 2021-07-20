package com.brighthealth.bowling.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BowlingGameServiceTest {

    BowlingGameService bowlingGameService;

    @BeforeEach
    void setup() {
        bowlingGameService = new BowlingGameService();
    }

    @Test
    public void scoreFor_anAllGutterBallGame() {
        bowlingGameService.roll( 0,0,  0,0,  0,0,  0,0,  0,0,  0,0,  0,0,  0,0,  0,0,  0,0);
        assertEquals(0, bowlingGameService.score());
    }

    @Test
    public void scoreFor_aGameOf_allOnes() {
        bowlingGameService.roll( 1,1,  1,1,  1,1,  1,1,  1,1,  1,1,  1,1,  1,1,  1,1,  1,1);
        assertEquals(20, bowlingGameService.score());
    }

    @Test
    public void scoreFor_aSpare_followedBy_oneMoreThrow() {
        bowlingGameService.roll( 5,5,  7,0,  0,0,  0,0,  0,0,  0,0,  0,0,  0,0,  0,0,  0,0);
        assertEquals(24, bowlingGameService.score());
    }

    @Test
    public void ScoreFor_aStrike_followedBy_twoMoreThrows() {
        bowlingGameService.roll( 10,  4,4,  0,0,  0,0,  0,0,  0,0,  0,0,  0,0,  0,0,  0,0);
        assertEquals(26, bowlingGameService.score());
    }

    @Test
    public void scoreFor_aPerfectGame() {
        bowlingGameService.roll( 10,10,  10,10,  10,10,  10,10,  10,10,  10,10,  10,10,  10,10,  10,10,  10,10);
        assertEquals(300, bowlingGameService.score());
    }
}
