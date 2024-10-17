package com.example.testspringsecurity.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Roles {

    @Id
    @Column(name = "id_role")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "name_role")
    String nameRole;

    @ManyToMany(fetch = FetchType.EAGER)
    Set<Users> usersSet = new HashSet<>();

    @Override
    public String toString() {
        return "Roles{" +
                "id=" + id +
                ", nameRole='" + nameRole + '\'' +
                '}';
    }
}
