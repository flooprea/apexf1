package com.example.apexf1.controller;

import com.example.apexf1.service.ResultService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResultController {

    @Autowired
    ResultService resultService;

    ObjectMapper objectMapper = new ObjectMapper();

//  Get race results based on year and race number
    @GetMapping("/results")
    public JsonNode getJsonResults(
            @RequestParam(name="year") String year,
            @RequestParam(name="raceNum") String raceNum) throws JsonProcessingException {

        String result = resultService.findResultWithYearAndRaceNumber(year,raceNum);

        JsonNode jsonNode = objectMapper.readValue(result,JsonNode.class);
        return jsonNode;

    }
}

