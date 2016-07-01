package com.realdolmen.course.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by aryastark on 30/06/16.
 */
@Entity
public class Passenger {
    @Id
    private Integer id;

    @Column(name = "first_name", length = 50)
    private String firstName;
    @Column(name = "last_name", length = 50)
    private String lastName;
    @Column(nullable = false, updatable = false)
    private String ssn;
    private int frequentFlyerMiles;
    @Column(nullable = false, updatable = false)
    private Date dateOfBirth;
    private LocalDate lastFlight;
    @Transient
    private int age = 50;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PassengerType pastype;


    @ElementCollection
    @CollectionTable(name = "passenger_emails", joinColumns = @JoinColumn(name = "p_id"))
    @Column(name = "email")
    List<String> emails=new ArrayList<>();

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public void addEmail(String newEmail) {
        if (newEmail==null || newEmail.trim().length()==0) {
            throw new IllegalArgumentException("foute invoer");

        }
        emails.add(newEmail);
    }
    public Passenger(Integer id, String firstName, String lastName, String ssn, int frequentFlyerMiles, Date dateOfBirth, LocalDate lastFlight, PassengerType pastype) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.frequentFlyerMiles = frequentFlyerMiles;
        this.dateOfBirth = dateOfBirth;
        this.lastFlight = lastFlight;
        this.age = age;
        this.pastype = pastype;
    }

    public Passenger() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public int getFrequentFlyerMiles() {
        return frequentFlyerMiles;
    }

    public void setFrequentFlyerMiles(int frequentFlyerMiles) {
        this.frequentFlyerMiles = frequentFlyerMiles;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getLastFlight() {
        return lastFlight;
    }

    public void setLastFlight(LocalDate lastFlight) {
        this.lastFlight = lastFlight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public PassengerType getPastype() {
        return pastype;
    }

    public void setPastype(PassengerType pastype) {
        this.pastype = pastype;
    }

}
