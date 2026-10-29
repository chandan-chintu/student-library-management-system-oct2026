package com.example.student_library_management_system.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name="transaction_details")
@Data
public class Transaction {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="transaction_date", nullable = false)
    private Date transactionDate;

    @Column(name="due_date")
    private String dueDate;

    @Column(name="transaction_type", nullable = false)
    private String transactionType;

}
