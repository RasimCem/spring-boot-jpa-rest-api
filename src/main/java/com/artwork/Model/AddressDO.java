package com.artwork.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="address")
public class AddressDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String country;

    private String city;
}
