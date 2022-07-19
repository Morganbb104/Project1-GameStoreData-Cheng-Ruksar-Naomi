package com.example.M4SummativeChengChienRuksarNaomi.controller;

import com.example.M4SummativeChengChienRuksarNaomi.models.Games;
import com.example.M4SummativeChengChienRuksarNaomi.repository.GameRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.awt.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(GameController.class)
public class GameControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {

    }


    @Test
    public void shouldAddGame() {
    }

    @Test
    public void shouldGetAllGames() throws Exception {
        Games games = new Games();
        games.setTitle("Cheng");
        games.setDescription("This is wonderful book");
        String inputString = mapper.writeValueAsString(games);

        Games output = new Games(1, "4.5", "Higher destination", "Go behind the horizon", new BigDecimal("4.59"), "Canningtown", 4);
//        Mockito.when(games.getDescription()).thenReturn(output);
        String outputString = mapper.writeValueAsString(output);

        this.mockMvc.perform(get("/game")) //Act
//                .content(inputString)
//                .contentType(MediaType.APPLICATION_JSON)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().json(outputString));
    }

    @Test
    public void shouldGetGameById() {
    }

    @Test
    public void shouldUpdateGame() {
    }

    @Test
    public void shouldDeleteGame() {
    }
}