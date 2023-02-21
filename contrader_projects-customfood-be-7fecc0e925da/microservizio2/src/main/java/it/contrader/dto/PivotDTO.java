package it.contrader.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
//DTO Molto semplice ... é uguale alla classe di riferimento, senza l'annotation @Entity
/**
 * A DTO for the {@link it.contrader.model.Pivot} entity
 */
/*Per chiarimenti Andare a vedere la Classe UserDTO*/
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="idPivot",scope = PivotDTO.class)
public class PivotDTO {

    private Integer idPivot;
    private Integer quantita;
    private String unita_di_misura;
    private RicettaDTO ricetta;
    private IngredienteDTO ingrediente;


}