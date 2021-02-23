package com.artwork.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="users")
public class UserDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable=false,unique=true)
    private String userName;

    private String name;

    private String surname;

    @Column(nullable=false,unique=true)
    private String email;

    @Column(nullable=false)
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="address_id")
    private AddressDO address;
}
