package it.contrader.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
//DTO Molto semplice ... é uguale alla classe di riferimento, senza l'annotation @Entity

/**
 * A DTO for the {@link it.contrader.model.Ingrediente} entity
 *
 */
/*Per chiarimenti Andare a vedere la Classe UserDTO*/
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id",scope = IngredienteDTO.class)
public class IngredienteDTO {
    private  Integer id;
    private  String nome;

    public IngredienteDTO(String nome) {
        this.nome = nome;
    }
}