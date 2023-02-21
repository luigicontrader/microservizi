package it.contrader.converter;
import it.contrader.dto.IngredienteDTO;
import it.contrader.model.Ingrediente;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IngredienteConverter extends AbstractConverter<Ingrediente, IngredienteDTO>{
    @Autowired
    ModelMapper modelMapper;
    @Override
    public Ingrediente toEntity(IngredienteDTO ingredienteDTO) {
        Ingrediente ingrediente = null;
        if (ingredienteDTO != null) {
            ingrediente = modelMapper.map(ingredienteDTO, Ingrediente.class);;
        }
        return ingrediente;
    }

    @Override
    public IngredienteDTO toDTO(Ingrediente ingrediente) {
        IngredienteDTO ingredienteDTO = null;
        if (ingrediente != null) {
            ingredienteDTO = modelMapper.map(ingrediente, IngredienteDTO.class);;
        }
        return ingredienteDTO;
    }
}
