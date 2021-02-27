package com.api.dto;

import com.api.Model.NationalityDO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

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
