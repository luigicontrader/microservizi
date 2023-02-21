package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.User;


/**
 * Estende CrudRepository ed eredita tutti i metodi di CRUD. 
 * Definisce il metodo di login.
 * 
 * @author Vittorio Valent & Girolamo Murdaca
 *
 * @see CrudRepository
 *
 */
//Ora il dao della nostra applicazione è diventato un interfaccia.
// La potenza di spring con hibernate sta nel
// autogenerare delle Query semplicemente chiamando il metodo con l'azione che vorremmo facesse.
//Ad esempio : User findByUsernameAndPassword(String username, String password)
// 												find: azione che vuoi effettuare sulla tabella
//                            |         + ByUsername: indichiamo secondo quale attributo della tabella
//                            |         + byPassword: se vogliamo utilizzare più di una chiave di ricerca,
//                            |						  interponiamo "And" tra le chiavi.
//                            v
//  Query Corrispondente: "SELECT * FROM ingrediente WHERE username = ? and password = ?;"
@Repository
//Questa annotation serve per ridurre al minimo le scritture di codice inutile nel ambito di gestione del'database.
//Meno Query.
// Nel service si utilizzeranno per la maggior parte i metodi della classe astratta
// CrudRepository che permetteranno di manipolare i dati direttamente nel database (insert , update, delete)
//
@Transactional //Serve per dichiarare che Questa interfaccia fa operazioni con il database
			   // quindi ne modifica il contesto e
			   // utilizza un Entity manager messo a
			   // disposizione da JPA per gestire il contesto delle persistenze attraverso hibernate
			   // (Vedere CrudRepository per chiarimenti)
public interface UserRepository extends CrudRepository<User, Integer>{

	User findByUsernameAndPassword(String username, String password);
	User findByUsername(String username);


}
