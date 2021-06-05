package com.shop.portfolio.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User extends AbstractEntity {

    @Column(nullable = false)
    private String email;


    @Column(nullable = false)
    private String name;


    @Column(nullable = false)
    private String surname;


    @Column(nullable = false)
    private LocalDateTime dateOfBirth;


    @Column(nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "roleId")
    private Role role;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "cartId")
    private Cart cart;

}
