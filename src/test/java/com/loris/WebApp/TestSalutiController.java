package com.loris.WebApp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/* Questo permetterà alla classe di eseguire test springboot */
@SpringBootTest
/*  */
@ContextConfiguration(classes = SalutiWebServiceApplication.class)
public class TestSalutiController {

    private MockMvc mvc;

    /* é un code injection di questo specific elemento */
    @Autowired
    private WebApplicationContext wac;

    /* Va a specificare che prima di ciascun unit test verrà eseguito questo metodo che andrà
        a creare il contest del nostro unit test.   */
    @BeforeEach
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(wac)
                .build();
    }

    @Test
    public void testGetSaluti() throws Exception{
        mvc.perform(get("/api/saluti")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$")
                    .value("Saluti, sono il tuo webService"))
                .andDo(print());
    }


}
