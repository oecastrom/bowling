package com.brighthealth.bowling.controller;

import com.brighthealth.bowling.service.BowlingGameService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@Controller
public class BowlingGameController {

    @Autowired
    BowlingGameService bowlingGameService;

    @PostMapping("/roll")
    public ResponseEntity postRolls(@RequestBody int ...rolls) {
        try {
            log.info("BowlingGameController.roll() called with the following payload: {}", rolls);
            bowlingGameService.roll(rolls);
        } catch (Exception e) {
            log.error("The following exception occurred: ", e);
        }
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/score")
    public ResponseEntity getScore() {
        return ResponseEntity.ok(bowlingGameService.score());
    }
}
