package it.contrader.model;

import javax.persistence.Entity;

import javax.persistence.*;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * Model dell'entità User. Contiene l'enum che definisce gli usertype (salvati come interi
 * a partire da 0 sul db).
 * 
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 * @see UserDTO
 */

//READ ME //
//CLASSE USER -> QUESTA CLASSE GENERA UN @Entity ovvero una tabella in un database
//Le colonne della tabella corrispondono agli attributi dichiarati sotto l'annotazione @Column
//Per indicare a hibernate che un attibuto corrisponde alla chiave primaria della tabella si utilizza @Id
//@GeneratedValue si utilizza per inserire automaticamente i valori della chiave primaria.

//@AllArgsConstructor @NoArgsConstructor,
// si utilizzano per  autogenerare il costruttire della classe con zero argomenti e
// uno con tutti gli argomenti, ovvero con TUTTI gli attributi della classe.@Data
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(unique = true)
	private String username;
	
	private String password;

	private String usertype;
	
}
