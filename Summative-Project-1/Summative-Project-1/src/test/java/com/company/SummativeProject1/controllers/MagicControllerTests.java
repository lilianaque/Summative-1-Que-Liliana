package com.company.magic8ball.controllers;

@WebMvcTest(MagicController.class)
public class MagicControllerTests {
    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper mapper = new ObjectMapper();
}
