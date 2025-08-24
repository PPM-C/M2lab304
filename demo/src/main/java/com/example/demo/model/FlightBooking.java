package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "flight_bookings")
public class FlightBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer BookingId;

    @ManyToOne
    @JoinColumn(name="customer_id",nullable=false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="flight_id", nullable=false)
    private Flight flight;

    public FlightBooking() {
    }
    public FlightBooking(Customer customer, Flight flight) {
        this.customer = customer;
        this.flight = flight;
    }
}
