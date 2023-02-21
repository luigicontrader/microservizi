package it.contrader.service;

import it.contrader.converter.PivotConverter;
import it.contrader.dao.PivotRepository;
import it.contrader.dto.PivotDTO;
import it.contrader.model.Pivot;
import it.contrader.model.Ricetta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PivotService extends AbstractService<Pivot, PivotDTO> {

    @Autowired
    private PivotConverter converter;
    @Autowired
    private PivotRepository repository;

    public List<PivotDTO> findIdRicetta(Integer id)  {
        return converter.toDTOList(repository.getAllByRicettaId(id));
    }


    public PivotDTO findByIdPivot(Integer id){
        return converter.toDTO(repository.findByIdPivot(id));
    }




}
