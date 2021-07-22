package com.brighthealth.bowling.service;

import org.springframework.stereotype.Service;

import static com.brighthealth.bowling.constants.Constants.MAX_ROLL_COUNT;
import static com.brighthealth.bowling.constants.Constants.MAX_FRAME;

@Service
public class BowlingGameService implements BowlingGameInterface {

    private int roll = 0;
    private int[] rolls = new int[MAX_ROLL_COUNT];

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
        int cursor = 0;
        int score = 0;
        for (int frame = 0;  frame < MAX_FRAME; frame++) {
            if (isSpare(cursor)) {
                score += 10 + rolls[cursor + 2] ;
                cursor += 2;
            } else if (isStrike(cursor)) {
                score += 10 + rolls[cursor + 1] + rolls[cursor + 2];
                cursor++;
            } else {
                score += rolls[cursor] + rolls[cursor + 1];
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
