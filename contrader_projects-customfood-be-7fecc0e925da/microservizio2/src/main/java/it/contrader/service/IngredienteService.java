package it.contrader.service;


import it.contrader.converter.IngredienteConverter;
import it.contrader.dao.IngredienteRepository;
import it.contrader.dto.IngredienteDTO;
import it.contrader.model.Ingrediente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredienteService extends AbstractService<Ingrediente, IngredienteDTO> {

    @Autowired
    private IngredienteConverter converter;
    @Autowired
    private IngredienteRepository repository;

    public IngredienteDTO findIngByNome(String nome)  {
        return converter.toDTO(repository.getFirstByNome(nome));
    }

    public IngredienteDTO getById(Integer id){
        return converter.toDTO(repository.getById(id));
    }
    public Boolean exist(String nome){
        return repository.existsByNome(nome);
    }




}
