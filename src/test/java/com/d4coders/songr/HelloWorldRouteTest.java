package com.d4coders.songr;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;




@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class HelloWorldRouteTest {

    @Autowired
    MainController mainControllerTest;

    @Test
    public void testLoading() throws Exception{
        assertThat(mainControllerTest).isNotNull();
    }

}

