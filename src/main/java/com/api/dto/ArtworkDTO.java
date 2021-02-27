package com.api.dto;

import com.api.Model.ArtistDO;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
public class ArtworkDTO {

    private String name;

    private String description;

    private String imagePath;

    private int completion_year;

    private int value;

    private ArtistDO artist;
}
