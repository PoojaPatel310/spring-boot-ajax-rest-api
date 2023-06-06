package com.example.BookRestApiAjax.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "title", nullable = false, length = 45)
    private String title;
    @Column(name = "author", nullable = false, length = 45)
    private String author;
    @Column(name = "price", nullable = false, length = 45)
    private double price;
}
