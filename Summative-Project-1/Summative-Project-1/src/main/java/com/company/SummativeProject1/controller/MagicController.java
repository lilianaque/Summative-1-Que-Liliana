package com.company.SummativeProject1.controller;

import com.company.SummativeProject1.model.Answer;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class MagicController {

    private static Map<String, Integer> answerMap = new LinkedHashMap<>();

    static {
        List<String> answers = Arrays.asList(
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
        );

        for (int i = 0; i < answers.size(); i++) {
            answerMap.put(answers.get(i), i+1);  // Assigning unique id starting from 1
        }
    }

    private Random random = new Random();

    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Answer magic(@RequestBody Optional<JsonNode> requestBodyOpt) throws Exception {
        List<String> keys = new ArrayList<>(answerMap.keySet());
        String answer = keys.get(random.nextInt(keys.size()));
        int id = answerMap.get(answer);

        String question = null;

        if(requestBodyOpt.isPresent()){
            JsonNode requestBody = requestBodyOpt.get();
            if (requestBody.has("question")) {
                question = requestBody.get("question").asText();
            }
        }

        return new Answer(id, question, answer);
    }
}
