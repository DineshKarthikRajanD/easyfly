package com.easyfly;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.easyfly.model.FlightModel;
import com.easyfly.service.FlightService;
 
@SpringBootTest(
  webEnvironment = SpringBootTest.WebEnvironment.MOCK,
  classes = EasyflyApplication.class)
@AutoConfigureMockMvc
@ActiveProfiles("qa")
public class FlightControllerIntegrationTest {
    @Autowired
    private MockMvc mvc;
    
    @Autowired
    FlightService flightService;
     
    @Test
    public void addFlightDetailsStatus204() throws Exception {
    	FlightModel flightModel = new FlightModel("JA-506", "Pune", "Nagpur", "Running", 2.00, 2500);
        mvc
        .perform(post("/api-v1/flights/")
        .contentType(MediaType.APPLICATION_JSON)
        .content(JsonUtil.toJson(flightModel)))
        .andExpect(status().isCreated());
    }
    
    @Test
    public void getAllFlightsStatus200()
      throws Exception { 
        mvc.perform(get("/api-v1/flights/")
          .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk());            
    }
}
