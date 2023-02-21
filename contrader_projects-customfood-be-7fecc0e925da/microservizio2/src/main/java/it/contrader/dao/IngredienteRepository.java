package it.contrader.dao;

import it.contrader.model.Ingrediente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

//Ora il dao della nostra applicazione è diventato un interfaccia.
// La potenza di spring con hibernate sta nel
// autogenerare delle Query semplicemente chiamando il metodo con l'azione che vorremmo facesse.
//ad esempio : Ingrediente getById(Integer id) get  : azione che vuoi effettuare sulla tabella
//                            |               + ById : indichiamo secondo quale attributo della tabella
//                            |                         vogliamo selezionare un istanza  in questo caso "ByID"
//                            v
//  Query Corrispondente : "SELECT * FROM ingrediente WHERE id = ?;"
@Repository
@Transactional
public interface IngredienteRepository extends CrudRepository<Ingrediente, Integer> {

    Ingrediente getByNome(String nome);
    Ingrediente getFirstByNome(String nome);


    Ingrediente getById(Integer id);
    Boolean existsByNome(String nome);



}
