package com.artwork.dto;

import com.artwork.Model.NationalityDO;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
public class ArtistDTO {

    private String name;

    private String surname;

    private int birth_year;

    private int death_year;

    private String biography;

    private String image_url;

    private NationalityDO nation;
}
