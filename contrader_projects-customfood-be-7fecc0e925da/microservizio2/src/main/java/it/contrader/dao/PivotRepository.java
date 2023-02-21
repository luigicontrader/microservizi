package it.contrader.dao;

import it.contrader.model.Pivot;
import it.contrader.model.Ricetta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/*Vedere userRepository Per chiarimenti su come funziona il DAO*/
@Repository
@Transactional
public interface PivotRepository extends CrudRepository<Pivot, Integer> {


        Pivot findByIdPivot(Integer id);



        List<Pivot> getAllByRicettaId(Integer id);

}
