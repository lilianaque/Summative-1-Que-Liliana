package com.company.SummativeProject1.controllers;
import com.company.SummativeProject1.controller.WordController;
import com.company.SummativeProject1.model.Definition;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(WordController.class)
public class WordControllerTests {
    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper mapper = new ObjectMapper();
    private List<Definition> wordsOfTheDay;

    @Test
    public void shouldGiveWordAndDefinitionOfTheDay() throws Exception {


        mockMvc.perform(get("/word"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.word").isString())
                .andExpect(jsonPath("$.definition").isString());

    }

}

