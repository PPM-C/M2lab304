package com.example.demo;

import com.example.demo.model.Flight;
import com.example.demo.repository.FlightRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;


@SpringBootTest
public class FlightRepositoryTest {
    @Autowired
    private FlightRepository flightRepository;

    @Test
    void testCreateFlight() {
        Flight flight = new Flight("AA101","Boeing 737",180,600);
        flightRepository.save(flight);
        assertNotNull(flight.getFlightId());
    }
    @Test
    void testFindByFlightNumber() {
        flightRepository.save(new Flight("UA202", "Airbus A320", 150, 400));
        List<Flight> results = flightRepository.findByFlightNumber("UA202");
        assertFalse(results.isEmpty());
    }

    @Test
    void testFindByAircraftContaining() {
        flightRepository.save(new Flight("DL303", "Boeing 747", 300, 900));
        List<Flight> results = flightRepository.findByAircraftContaining("Boeing");
        assertFalse(results.isEmpty());
    }

    @Test
    void testFindByFlightMileageGreaterThan() {
        flightRepository.save(new Flight("SW404", "Embraer", 100, 550));
        List<Flight> results = flightRepository.findByFlightMileageGreaterThan(500);
        assertFalse(results.isEmpty());
    }
}
