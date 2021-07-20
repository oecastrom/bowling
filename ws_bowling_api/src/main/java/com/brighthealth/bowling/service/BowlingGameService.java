package com.brighthealth.bowling.service;

import org.springframework.stereotype.Service;

import static com.brighthealth.bowling.constants.Constants.MAX_ROLL_COUNT;
import static com.brighthealth.bowling.constants.Constants.MAX_FRAME;

@Service
public class BowlingGameService implements BowlingGameInterface {

    private int roll = 0;
    private int[] rolls = new int[MAX_ROLL_COUNT];

    // Call this method in the controller
    public void roll(int ...rolls) {
        for (int pinsDown : rolls)
            roll(pinsDown);
    }

    @Override
    public void roll(int pinsDown) {
        rolls[roll++] = pinsDown;
    }

    @Override
    public int score() {
        // separate counter to keep track where we are in the rolls array
        int cursor = 0;
        int score = 0;

        for (int frame = 0;  frame < MAX_FRAME; frame++) {
            // check if spare
            if (isSpare(cursor)) {
                // Refer to read me for this equation
                score += 10 + rolls[cursor + 2] ;
                cursor += 2;
            } else if (isStrike(cursor)) {
                // Refer to read me for this equation
                score += 10 + rolls[cursor + 1] + rolls[cursor + 2];
                cursor++;
            } else {
                // 2 rolls per frame
                score += rolls[cursor] + rolls[cursor + 1];
                // Don't increase by 1 but by 2 since in line 24 we have accounted for the 2 rolls per frame
                cursor += 2;
            }
        }

        return score;
    }

    private boolean isSpare(int cursor) {
        return rolls[cursor] + rolls[cursor + 1] == 10;
    }

    private boolean isStrike(int cursor) {
        return rolls[cursor] == 10;
    }

}
