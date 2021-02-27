package com.api.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="nation")
public class NationalityDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String country;

    private String city;
}
