package it.contrader.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
//READ ME //
//CLASSE PIVOT -> QUESTA CLASSE GENERA UN @Entity ovvero una tabella in un database
//Le colonne della tabella corrispondono agli attributi dichiarati sotto l'annotazione @Column
//Per indicare a hibernate che un attibuto corrisponde alla chiave primaria della tabella si utilizza @Id
//@GeneratedValue si utilizza per inserire automaticamente i valori della chiave primaria.

//@AllArgsConstructor @NoArgsConstructor,
// si utilizzano per autogenerate il costruttore della classe con zero argomenti e
// uno con tutti gli argomenti, ovvero con TUTTI gli attributi della classe.
*/

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Ingrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;


}
