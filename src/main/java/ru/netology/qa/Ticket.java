package ru.netology.qa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ticket implements Comparable<Ticket> {
    private int Id;
    private int cost;
    private String departureAirport;
    private String arrivalAirport;
    private int travelTime;

    @Override
    public int compareTo(Ticket o) {
        if (getCost() < o.cost) {
            return -1;
        } else if (getCost() > o.cost) {
            return 1;
        } else {
            return 0;
        }
    }

    public boolean matches(String from, String to) {
        if (getDepartureAirport().equals(from)) {
            if (getArrivalAirport().equals(to)) {
                return true;
            }
        }
        return false;
    }

}

