package com.company.magic8ball.controllers;

import com.company.SummativeProject1.model.Answer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MagicController.class)
public class MagicControllerTests {
    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void shouldReturnAnswerAndQuestionWhenQuestionProvided() throws Exception {
        String question = "Test Question";
        mockMvc.perform(post("/magic")
            .contentType("application/json")
            .content(mapper.writeValueAsString(question)))

            .andExpect(status().isOk())
            .andExpect(jsonPath("$.question").value(question))
            .andExpect(jsonPath("$.answer").exists());
    }

    @Test
    public void shouldReturnAnswerEvenWithoutQuestion() throws Exception {
        mockMvc.perform(post("/magic")
            .contentType("application/json")
            .content(""))

            .andExpect(status().isOk())
            .andExpect(jsonPath("$.question").doesNotExist())
            .andExpect(jsonPath("$.answer").exists());
    }

    @Test
    public void shouldReturnAnswerEvenWithoutRequestBody() throws Exception {
        mockMvc.perform(post("/magic")
            .contentType("application/json"))

            .andExpect(status().isOk())
            .andExpect(jsonPath("$.answer").exists());
    }
}