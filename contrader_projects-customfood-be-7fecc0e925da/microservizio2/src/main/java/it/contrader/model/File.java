package it.contrader.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;     //Chiave primaria del file salvato
    private String nome;    //Nome del file, puramente simbolico
    private String type;    //Stringa che indica il tipo di file caricato { Immagine || Video }
    private String path; // Array di byte che rappresenta l'immagine o il video caricato nel database.
                          // il file caricato viene convertito e immagazzinato in questo modo
}
