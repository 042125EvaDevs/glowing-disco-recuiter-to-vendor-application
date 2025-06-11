package xyz.catuns.recruiter_to_vendor.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import xyz.catuns.recruiter_to_vendor.dto.UserRegistrationDTO;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("should register user")
    void loginUserRegistrationStatusOk() throws Exception {
        /* GIVEN - user registration */
        UserRegistrationDTO user = new UserRegistrationDTO("jonjones", "password");
        String json = objectMapper.writeValueAsString(user);

        /* WHEN - login */
        mockMvc.perform(post("/auth/register").content(json))
                .andExpect(status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").exists());
    }

}