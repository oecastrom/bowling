package com.brighthealth.bowling.controller;

import com.brighthealth.bowling.service.BowlingGameService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BowlingGameControllerTest {

    @InjectMocks
    BowlingGameController bowlingGameController;

    @Mock
    BowlingGameService bowlingGameService;

    @Test
    public void postRolls_returns_202_responseCode() {
        int[] rolls = new int[] {0,0,  0,0,  0,0,  0,0,  0,0,  0,0,  0,0,  0,0,  0,0,  0,0};
        doAnswer((Answer<Void>) invocation -> null).when(bowlingGameService).roll(rolls);
        assertEquals(202, bowlingGameController.postRolls(rolls).getStatusCodeValue());
    }

    @Test(expected = Exception.class)
    public void postRolls_catchesException() {
        when(bowlingGameController.postRolls()).thenThrow(new Exception());
    }

    @Test
    public void getScore_returns_200_responseCode () {
        when(bowlingGameService.score()).thenReturn(300);
        assertEquals(200, bowlingGameController.getScore().getStatusCodeValue());
        assertEquals(300, bowlingGameController.getScore().getBody());
    }
}