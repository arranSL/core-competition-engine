package com.scottlogic.competition_engine.application;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import static org.hamcrest.CoreMatchers.endsWith;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.MockMvc;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserServiceImplTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void EmptyTokenExceptionThrown() throws Exception {
        this.mockMvc.perform(get("/users/authorise")).andDo(print()).andExpect(status().isOk())
                .andExpect(status().isInternalServerError())
                .andExpect(content().string("Supplied empty token"));
    }

    @Test
    public void DefaultMessageReturned() throws Exception {
        this.mockMvc.perform(get("/users/authorise/message")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(endsWith("message")));
    }
}