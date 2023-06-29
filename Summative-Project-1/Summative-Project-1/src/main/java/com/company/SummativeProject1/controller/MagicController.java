package com.company.magic8ball.controllers;

import com.company.magic8ball.models.Answer;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class MagicController {
    private static List<Answer> answerList = new ArrayList<>(Arrays.asList(

    ));

    // URI: /magic
    // Method: POST
    // Request Body: Question
    // Response Body: Answer
    // The POST request for the Magic 8 Ball endpoint should include a user-provided question.
}
