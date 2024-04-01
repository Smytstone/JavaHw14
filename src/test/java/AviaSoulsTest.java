import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AviaSoulsTest {

    @Test
    public void shouldCompareByPriceTestCase1() {
        Ticket ticket = new Ticket(
                "Moscow",
                "Saint-Petersburg",
                200,
                1,
                2
        );
        Ticket ticket2 = new Ticket(
                "Omsk",
                "Kastroma",
                100,
                5,
                10
        );

        Assertions.assertEquals(1, ticket.compareTo(ticket2));
    }

    @Test
    public void shouldCompareByPriceTestCase2() {
        Ticket ticket = new Ticket(
                "Moscow",
                "Saint-Petersburg",
                100,
                1,
                2
        );
        Ticket ticket2 = new Ticket(
                "Omsk",
                "Kastroma",
                200,
                5,
                10
        );

        Assertions.assertEquals(-1, ticket.compareTo(ticket2));
    }

    @Test
    public void shouldCompareByPriceTestCase3() {
        Ticket ticket = new Ticket(
                "Moscow",
                "Saint-Petersburg",
                200,
                1,
                2
        );
        Ticket ticket2 = new Ticket(
                "Omsk",
                "Kastroma",
                200,
                5,
                10
        );

        Assertions.assertEquals(0, ticket.compareTo(ticket2));
    }

    @Test
    public void shouldSortArrayByPrice() {
        Ticket ticket = new Ticket(
                "Moscow",
                "Saint-Petersburg",
                200,
                1,
                2
        );
        Ticket ticket2 = new Ticket(
                "Moscow",
                "Saint-Petersburg",
                100,
                5,
                10
        );
        Ticket ticket3 = new Ticket(
                "Moscow",
                "Saint-Petersburg",
                400,
                4,
                7
        );
        Ticket ticket4 = new Ticket(
                "Moscow",
                "Saint-Petersburg",
                50,
                5,
                18
        );
        Ticket ticket5 = new Ticket(
                "Moscow",
                "Saint-Petersburg",
                150,
                9,
                17
        );

        AviaSouls manager = new AviaSouls();
        manager.add(ticket);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] expected = {ticket4, ticket2, ticket5, ticket, ticket3 };
        Ticket[] actual = manager.search("Moscow", "Saint-Petersburg");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCompareByTimeComparator() {
        Ticket ticket = new Ticket(
                "Moscow",
                "Saint-Petersburg",
                200,
                1,
                2
        );
        Ticket ticket2 = new Ticket(
                "Omsk",
                "Kastroma",
                200,
                5,
                10
        );

        TicketTimeComparator comparator = new TicketTimeComparator();

        Assertions.assertEquals(-1, comparator.compare(ticket, ticket2));
    }

    @Test
    public void shouldSortArrayByTime() {
        Ticket ticket = new Ticket(
                "Moscow",
                "Saint-Petersburg",
                200,
                1,
                2
        );
        Ticket ticket2 = new Ticket(
                "Moscow",
                "Saint-Petersburg",
                100,
                5,
                10
        );
        Ticket ticket3 = new Ticket(
                "Moscow",
                "Saint-Petersburg",
                400,
                4,
                7
        );
        Ticket ticket4 = new Ticket(
                "Moscow",
                "Saint-Petersburg",
                50,
                5,
                18
        );
        Ticket ticket5 = new Ticket(
                "Moscow",
                "Saint-Petersburg",
                150,
                9,
                17
        );

        AviaSouls manager = new AviaSouls();
        manager.add(ticket);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        TicketTimeComparator comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket, ticket3, ticket2, ticket5, ticket4 };
        Ticket[] actual = manager.searchAndSortBy("Moscow", "Saint-Petersburg", comparator);
        Assertions.assertArrayEquals(expected, actual);
    }
}
