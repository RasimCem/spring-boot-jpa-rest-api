package com.artwork.dto;

import lombok.Data;

@Data
public class ArtworkDTO {
    private String name;

    private String description;

    private String imagePath;

    private ArtistDTO user;
}
