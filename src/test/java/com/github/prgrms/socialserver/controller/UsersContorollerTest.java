package com.github.prgrms.socialserver.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.prgrms.socialserver.dto.UserJoinDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UsersContorollerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getUsersInfoTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/users"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getUserInfoTest() throws Exception {
        for(int i = 0;i<4;i++)
        {
            mockMvc.perform(MockMvcRequestBuilders.get("/api/users/" + (i+1)))
                    .andDo(print())
                    .andExpect(status().isOk());
        }
    }

    @Test
    @Transactional
    void joinUserTest() throws Exception {

        String content = objectMapper.writeValueAsString(new UserJoinDto("abc@naver.com", "1234"));
        mockMvc.perform(MockMvcRequestBuilders.post("/api/users/join")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/users/" + 5))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.post("/api/users/join")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isAccepted());
    }

}