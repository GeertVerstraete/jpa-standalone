package com.realdolmen.course;

import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.domain.PassengerType;
import com.realdolmen.course.domain.Ticket;
import org.junit.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

import static org.junit.Assert.assertNotNull;

/**
 * Created by aryastark on 01/07/16.
 */
public class TicketTest extends DataSetPersistenceTest {
    @Test
    public void ticketCanBePersisted() throws Exception {

        Passenger p = entityManager().find(Passenger.class, 2);
        Ticket barcelona = new Ticket(20, p);
        entityManager().persist(barcelona);

        assertNotNull(barcelona.getId());
    }
}

