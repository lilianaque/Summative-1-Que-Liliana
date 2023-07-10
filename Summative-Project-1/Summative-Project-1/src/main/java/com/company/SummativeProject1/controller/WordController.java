package com.company.SummativeProject1.controller;
import com.company.SummativeProject1.model.Definition;
import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class WordController {

    private static int idCounter = 1;
    private static List<Definition> wordsOfTheDay = new ArrayList<>(Arrays.asList(
            new Definition(idCounter++, "whimsical", "playfully quaint or fanciful" ),
            new Definition(idCounter++,"flabbergasted", "greatly surprised or astonished"),
            new Definition(idCounter++,"euphoria","a feeling or state of intense excitement and happiness" ),
            new Definition(idCounter++,"saudade", "a feeling of longing, melancholy, or nostalgia"),
            new Definition(idCounter++,"compathy", "shared feeling (as of joy or sorrow)"),
            new Definition(idCounter++,"eloquence", "fluent or persuasive speaking or writing"),
            new Definition(idCounter++,"gregarious", " fond of company; sociable"),
            new Definition(idCounter++,"optimism", "hopefulness and confidence about the future or the successful outcome of something"),
            new Definition(idCounter++,"hooly",  "in a slow, careful, or gentle manner"),
            new Definition(idCounter++, "harmony", "agreement or concord")
    ));

    private Random random = new Random();

    // URI: /word
    // Method: GET
    // Request Body: NONE
    // Response Body: Defintion
    @RequestMapping(value = "/word", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)

    public Definition getWordOfDay() {
        int definition = random.nextInt(wordsOfTheDay.size());
        return wordsOfTheDay.get(definition);
        //return new Definition(idCounter++, definition.get(), definition);
    }
}
