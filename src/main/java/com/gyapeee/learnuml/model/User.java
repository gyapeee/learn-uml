package com.gyapeee.learnuml.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(unique = true, length = 45)
    private String email;

    @NotNull
    @Column(length = 64)
    private String password;

    @NotNull
    @Column(name = "first_name", length = 20)
    private String firstName;

    @NotNull
    @Column(name = "last_name", length = 20)
    private String lastName;
}
