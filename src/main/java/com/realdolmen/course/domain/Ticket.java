package com.realdolmen.course.domain;

import javax.persistence.*;

/**
 * Created by aryastark on 01/07/16.
 */
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @ManyToOne
    @JoinTable(name = "ticket_passenger",
            inverseJoinColumns = @JoinColumn(name = "id_t"),
            joinColumns = @JoinColumn(name = "id_p"),
            foreignKey = @ForeignKey(name = "ticket_to_person")
    )
    private Integer price;


}

