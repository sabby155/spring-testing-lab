package com.flatiron.spring.FlatironSpring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultHandler;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BitcoinController.class)
class BitcoinControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BitCoinService bitcoinService;

    @WithMockUser(username = "fake", authorities = "admin")
    @Test
    void price() throws Exception {
        String name = "bitcoin";
        String result = bitcoinService.getBitcoinPrice(name);
        mockMvc.perform(get("/price")
                .param("targetName", name))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Price: " + result)));
    }


}