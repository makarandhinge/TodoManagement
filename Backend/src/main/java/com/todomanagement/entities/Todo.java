package com.todomanagement.entities;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "todos")
public class Todo
    {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(name = "title",nullable = false)
        private String title;
        @Column(name = "description",nullable = false)
        private String description;
        @Column(name = "completed")
        private boolean completed;
    }
