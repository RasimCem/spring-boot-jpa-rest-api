package com.artwork.dto;

import com.artwork.Model.AddressDO;
import lombok.Data;

@Data
public class UserDTO {
    private String userName;

    private String name;

    private String surname;

    private String email;

    private AddressDO address;
}
