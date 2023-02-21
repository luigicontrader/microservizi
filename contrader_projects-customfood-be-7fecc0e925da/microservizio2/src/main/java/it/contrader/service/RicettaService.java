package it.contrader.service;

import it.contrader.converter.RicettaConverter;
import it.contrader.dao.RicettaRepository;
import it.contrader.dto.RicettaDTO;
import it.contrader.model.Ricetta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RicettaService extends AbstractService<Ricetta, RicettaDTO> {

    @Autowired
    private RicettaConverter converter;
    @Autowired
    private RicettaRepository repository;
    Boolean b = true;

    public RicettaDTO findRicettaById(Integer id)  {
        return converter.toDTO(repository.findRicettaById(id));
    }


    public List<RicettaDTO> getAllByUserId(Integer id) {
        return converter.toDTOList(repository.findAllByUserId(id));
    }

    public List<RicettaDTO> getAllPublic() {
        return converter.toDTOList(repository.findAllByPubblico(b));
    }

}
