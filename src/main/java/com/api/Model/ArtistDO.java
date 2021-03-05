package com.api.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(uniqueConstraints={
        @UniqueConstraint(columnNames = {"name", "surname","id"})
},name = "artist")
public class ArtistDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private String surname;

    private int birth_year;

    private int death_year;

    @Column(columnDefinition="TEXT")
    private String biography;

    private String image_url;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="nationality_id")
    private NationalityDO nation;

}
