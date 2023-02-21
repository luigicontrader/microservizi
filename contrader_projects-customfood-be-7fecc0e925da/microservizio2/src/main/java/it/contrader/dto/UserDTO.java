package it.contrader.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import it.contrader.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO della classe User. Ha gli stessi attributi di User
 * 
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 *@see User
 */



//@JsonIdentityInfo è utilizzato per indicare che questa classe ha una relazione
// di tipo Padre-Figlio con un altra classe, in particolare viene utilizzato per indicare che
// l'identity della classe verrà utilizzata nel processo di serializzazione / de-serializzazione
//The ObjectIdGenerators.PropertyGenerator is an abstract place-holder class to
// denote a case where Object Identifier to use comes from a POJO property.
//L'uscita di questa annotation sarà un file JSON in cui ci sarà:
//{
// "Id" : 1,
// "username" : "user",
// "password" : "user",
// "usertype" : "USER"
//}
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id",scope = UserDTO.class)//Questo è differente da Spring Boot
@Data//@Data è utilizzato per generare automaticamente i getter e setter per tutti gli attributi della classe
@AllArgsConstructor//Costruttore con tutti i parametri
@NoArgsConstructor//Costruttore senza nessun parametro
public class UserDTO {

	private Integer id;
	
	private String username;
	
	private String password;

	private String usertype;
	

}
