package it.contrader.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import it.contrader.model.File;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToOne;
import java.io.Serializable;
//DTO Molto semplice ... È uguale alla classe di riferimento, senza l'annotation @Entity
/**
 * A DTO for the {@link it.contrader.model.Ricetta} entity
 */
/*Per chiarimenti Andare a vedere la Classe UserDTO*/
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id",scope = RicettaDTO.class)

public class RicettaDTO {
    private  Integer id;
    private  String nome;
    private  Integer t_preparazione;
    private  Integer t_cottura;
    private  Integer dose;
    private  String preparazione;
    private  Boolean pubblico;
    private UserDTO user;
    private FileDTO file;


    public RicettaDTO(String nome, Integer tPreparazione, Integer tCottura, Integer dose, String preparazione, boolean pubblico, UserDTO user, FileDTO file) {
        this.nome           = nome;
        this.t_preparazione = tPreparazione;
        this.t_cottura      = tCottura;
        this.dose           = dose;
        this.preparazione   = preparazione;
        this.pubblico       = pubblico;
        this.user           = user;
        this.file           = file;
    }


}