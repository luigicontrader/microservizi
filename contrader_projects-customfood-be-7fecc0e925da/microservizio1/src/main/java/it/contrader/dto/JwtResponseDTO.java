package it.contrader.dto;


import it.contrader.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@AllArgsConstructor

public class JwtResponseDTO  {

    private final String token;

    private final UserDTO user;

}
