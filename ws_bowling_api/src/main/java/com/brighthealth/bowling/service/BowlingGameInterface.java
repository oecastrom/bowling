package com.brighthealth.bowling.service;

public interface BowlingGameInterface {
    // Method specifying how many pins have been knocked down
    void roll(int pinsDown);

    // Method specifying a players score
    int score();
}
