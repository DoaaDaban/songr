package com.d4coders.songr;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class HelloWorldRouteTest {

    @Autowired
    MainController mainControllerTest;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testLoading() throws Exception{
        assertThat(mainControllerTest).isNotNull();
    }

    @Test
    void helloWorldTestIntegration() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/hello")
                        .param("name", "Doaa"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/html;charset=UTF-8"));

    }

}

