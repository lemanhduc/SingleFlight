package com.cognizant.singleFlight;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import org.springframework.http.MediaType;
import static org.hamcrest.Matchers.is;


import org.springframework.http.MediaType;

@WebMvcTest(SingleFlightController.class)
public class SingleFlightTest {

    @Autowired
    MockMvc mvc;

    @Test
    public void testSingleFlight_Should_Return_JsonString() throws Exception{

        RequestBuilder req = get("/flights/flight")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(req)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.tickets[0].passenger.firstName", is("Peter")))
                .andExpect(jsonPath("$.tickets[0].passenger.lastName", is("Le")));

    }
}
