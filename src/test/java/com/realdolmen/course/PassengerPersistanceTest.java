package com.realdolmen.course;

import com.realdolmen.course.domain.Book;
import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.domain.PassengerType;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by aryastark on 30/06/16.
 */
public class PassengerPersistanceTest extends DataSetPersistenceTest {
    @Test
    public void passengercanBePersisted() throws Exception {
        Passenger barry = new Passenger(1, "Barry", "Batspak", "5", 1000,
                Date.from(Instant.now()),
                LocalDate.now(),
                PassengerType.OCCASIONAL);

        entityManager().persist(barry);
        assertNotNull(barry.getId());
    }

    @Test
    public void PassengerCanBeRetrievedById() throws Exception {
        assertEquals("larry", entityManager().find(Passenger.class, 2).getFirstName());
    }
    @Test
    public void passengerCanStoreManyEmails() throws Exception {
        Passenger passenger = new Passenger(1, "Barry", "Batspak", "5", 1000,
                Date.from(Instant.now()),
                LocalDate.now(),
                PassengerType.OCCASIONAL);
        passenger.addEmail("blablbaemail");
        passenger.addEmail("blablbaemail2");
        entityManager().persist(passenger);

    }

}
