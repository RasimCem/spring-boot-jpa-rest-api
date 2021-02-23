package com.artwork.Model;

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

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="user_id")
    private UserDO user;
}
