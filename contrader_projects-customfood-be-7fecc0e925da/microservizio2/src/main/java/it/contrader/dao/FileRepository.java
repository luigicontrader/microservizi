package it.contrader.dao;

import it.contrader.model.File;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface FileRepository extends CrudRepository<File, Integer> {

    Optional<File> findById(Integer i);
}
