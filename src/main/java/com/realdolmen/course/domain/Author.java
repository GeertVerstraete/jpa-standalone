package com.realdolmen.course.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by aryastark on 01/07/16.
 */
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    String name;

    @ManyToMany(mappedBy = "authors")
//    @JoinTable(name = "book_author")
    private Collection<Book> books = new ArrayList<>();
}

