package com.cognizant.singleFlight;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/flights")
public class SingleFlightController {

    @GetMapping("/flight")
    public Flight get() {
        Flight flight = new Flight();
        flight.tickets = new ArrayList<Tickets>();
        flight.tickets.add(new Tickets());
        flight.tickets.get(0).passenger = new Passenger();
        flight.tickets.get(0).passenger.firstName = "Peter";
        flight.tickets.get(0).passenger.lastName = "Le";
        return flight;
    }

    public static class Flight {
        private Date departs;

        public List<Tickets> getTickets() {
            return tickets;
        }

        public void setTickets(List<Tickets> tickets) {
            this.tickets = tickets;
        }

        private List<Tickets> tickets;

        public Date getDepart() {
            return departs;
        }

        public void setDepart(Date depart) {
            this.departs = depart;
        }
    }
    public static class Passenger {
        private String firstName;
        private String lastName;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }
    public class Tickets {
        private Passenger passenger;

        public int getPrice() {
            return Price;
        }

        public void setPrice(int price) {
            Price = price;
        }

        private int Price;

        public Passenger getPassenger() {
            return passenger;
        }

        public void setPassenger(Passenger _passenger) {
            passenger = _passenger;
        }
    }


}
