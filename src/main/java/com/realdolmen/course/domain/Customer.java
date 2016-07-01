package com.realdolmen.course.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Created by aryastark on 01/07/16.
 */
@Entity
class Customer {
    @Id
    private Integer id;
    private String name;
    @OneToOne
    private Adress invoiceAdress;




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Adress getInvoiceAdress() {
        return invoiceAdress;
    }

    public void assignInvoiceAdress(Adress invoiceAdress) {
        this.invoiceAdress = invoiceAdress;
        invoiceAdress.setCustomer(this);
    }
}
@Entity
class Adress{
    @Id
    private Integer id;
    private String street;
    private String city;
    @OneToOne(mappedBy = "invoiceAdress")
    private Customer customer;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

class ExampleRunner {
    public static void main(String[] args) {
        Adress a=new Adress();
        Customer c= new Customer();
       c.assignInvoiceAdress(a);

    }
}