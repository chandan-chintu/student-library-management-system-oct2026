package com.example.student_library_management_system.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="book")
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="title", nullable = false)
    private String title;

    @Column(name="publisher_name", nullable = false)
    private String publisherName;

    @Column(name="published_date", nullable = false)
    private String publishedDate;

    @Column(name="pages", nullable = false)
    private int pages;

    @Column(name="availability", nullable = false)
    private Boolean availability;

    @Column(name="category", nullable = false)
    private String category;

    @Column(name="rack_no", nullable = false)
    private String rackNo;
}
