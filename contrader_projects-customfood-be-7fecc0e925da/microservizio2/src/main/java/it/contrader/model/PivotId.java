package it.contrader.model;


import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class PivotId implements Serializable {
//!!!!!CLASSE  NON UTILIZATA!!!!!, PRIMA IDEATA PER CREARE UN ID EMBEDDED NELLA CLASSE PIVOT
    @Column(name = "ricetta_id")
    private Integer ricettaId;

    @Column(name = "ingrediente_id")
    private Integer ingredienteId;


}
