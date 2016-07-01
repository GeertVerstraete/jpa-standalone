package com.realdolmen.course.domain;

import javax.persistence.*;

/**
 * Created by aryastark on 01/07/16.
 */
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer price;

    @ManyToOne
    @JoinTable(name = "ticket_passenger",
            inverseJoinColumns = @JoinColumn(name = "id_t"),
            joinColumns = @JoinColumn(name = "id_p"),
            foreignKey = @ForeignKey(name = "ticket_to_person")
    )
    private Passenger passenger;

    public Ticket(Integer price, Passenger passenger) {

        this.price = price;
        this.passenger = passenger;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}

