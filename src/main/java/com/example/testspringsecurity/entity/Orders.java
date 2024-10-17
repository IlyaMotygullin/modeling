package com.example.testspringsecurity.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Orders {

    @Id
    @Column(name = "id_order")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "title_order")
    String title;

    @Column(name = "description_order")
    String description;

    @ManyToOne
    @JoinColumn(name = "id_user")
    Users users;
}
