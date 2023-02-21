package it.contrader.dao;

import it.contrader.model.Ricetta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
/*Vedere userRepository Per chiarimenti su come funziona il DAO*/
@Repository
@Transactional
public interface RicettaRepository extends CrudRepository<Ricetta, Integer>{

    Ricetta findRicettaById(Integer id);
    List<Ricetta> findAllByUserId(Integer id);

    List<Ricetta> findAllByPubblico(Boolean b);


}
