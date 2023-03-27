package ru.netology.qa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.qa.TicketManager;
import ru.netology.qa.TicketRepository;

import java.util.Arrays;
import java.util.Comparator;

public class TicketManagerTest {
    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);

    Ticket ticket1 = new Ticket(1, 25_000, "DME", "LED", 60);
    Ticket ticket2 = new Ticket(2, 5_000, "LED", "ULV", 52);
    Ticket ticket3 = new Ticket(3, 2_000, "VKO", "REN", 125);
    Ticket ticket4 = new Ticket(4, 10_000, "VKO", "OVB", 180);
    Ticket ticket5 = new Ticket(5, 21_000, "LED", "ULV", 45);
    Ticket ticket6 = new Ticket(6, 35_000, "LED", "IKT", 250);
    Ticket ticket7 = new Ticket(7, 5_000, "LED", "ULV", 55);
    Ticket ticket8 = new Ticket(8, 80_000, "LED", "ULV", 48);
    Ticket ticket9 = new Ticket(9, 3_000, "LED", "ULV", 61);
    Ticket ticket10 = new Ticket(10, 12_000, "LED", "IKT", 238);

    @BeforeEach
    public void setUp() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
    }

    @Test
    public void shouldFindAllTickets() {

        Ticket[] expected = {ticket9, ticket2,ticket7, ticket5,ticket8};
        Ticket[] actual = manager.findAll("LED","ULV");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNoOneTicket() {

        Ticket[] expected = new Ticket[0];
        Ticket[] actual = manager.findAll("OGZ","FRU");

        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    public void shouldFindOneTicket() {

        Ticket[] expected = {ticket1};
        Ticket[] actual = manager.findAll("DME","LED");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSortByComparator() {
        Comparator<Ticket> comparator = new TicketByPriceAscComparator();

        Ticket[] expected = {ticket5, ticket8,ticket2, ticket7,ticket9};;
        Ticket[] actual = manager.findAll("LED","ULV",comparator);

        Assertions.assertArrayEquals(expected, actual);

    }
}
