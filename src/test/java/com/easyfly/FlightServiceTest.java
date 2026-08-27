package com.easyfly;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.easyfly.dao.FlightDaoWrapper;
import com.easyfly.model.FlightModel;
import com.easyfly.service.FlightServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class FlightServiceTest {

	@Mock
	FlightDaoWrapper flightDaoWrapper;

	@InjectMocks
	FlightServiceImpl flightService;

	@Test
	public void testGetFlightById() {
		FlightModel mockFlight = new FlightModel(1, "AI-501", "Mumbai", "Dubai", "Delayed", 2.4, 15000);

		Mockito.when(flightDaoWrapper.getFlightById(1)).thenReturn(mockFlight);

		FlightModel result = flightService.getFlightById(1);
		assertNotNull(result);
		assertEquals(1, result.getFlightId());
		assertEquals("AI-501", result.getFlightNumber());
		assertEquals("Mumbai", result.getSource());
		assertEquals("Dubai", result.getDestination());
		assertEquals("Delayed", result.getStatus());
		assertEquals(2.4, result.getDuration());
		assertEquals(15000, result.getFare());
	}
}
