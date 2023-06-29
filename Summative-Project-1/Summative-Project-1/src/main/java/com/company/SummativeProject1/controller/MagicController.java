package com.company.magic8ball.controllers;

import com.company.magic8ball.models.Answer;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class MagicController {
    private static List<String> answerList = new ArrayList<>(Arrays.asList(
            "It is certain.",
            "As I see it, yes.",
            "Reply hazy, try again.",
            "Don't count on it.",
            "My sources say no.",
            "Outlook not so good.",
            "Better not tell you now.",
            "Very doubtful.",
            "Yes - definitely.",
            "Signs point to yes."
    ));

    // URI: /magic
    // Method: POST
    // Request Body: Question
    // Response Body: Answer
    // The POST request for the Magic 8 Ball endpoint should include a user-provided question.
}
