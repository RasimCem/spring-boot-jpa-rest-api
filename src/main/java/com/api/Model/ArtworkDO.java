package com.api.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="artwork")
public class ArtworkDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private String description;

    @Column(nullable = false)
    private String imagePath;

    private int completion_year;

    private int value;

    @ManyToOne
    @JoinColumn(name="artist_id")
    private ArtistDO artist;
}
