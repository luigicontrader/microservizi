package it.contrader.converter;

import it.contrader.dto.RicettaDTO;
import it.contrader.model.Ricetta;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//@Component is an annotation that allows Spring to automatically detect our custom beans.
//
//		In other words, without having to write any explicit code, Spring will:
//
//		Scan our application for classes annotated with @Component
//		Instantiate them and inject any specified dependencies into them
//		Inject them wherever needed
@Component
public class RicettaConverter extends AbstractConverter<Ricetta, RicettaDTO>{
                //Autowired serve per iniettare a momento di runtime i @Bean/@component che ha inserito nel Application Context
    @Autowired  //verrà iniettato direttamente in questo converter.
    private ModelMapper modelMapper;

    @Override
    public Ricetta toEntity(RicettaDTO ricettaDTO) {
        Ricetta ricetta = null;
        if (ricettaDTO != null) {
            ricetta = modelMapper.map(ricettaDTO, Ricetta.class);
        }
        return ricetta;
    }

    @Override
    public RicettaDTO toDTO(Ricetta ricetta) {RicettaDTO ricettaDTO = null;
        if (ricetta != null) {
            ricettaDTO = modelMapper.map(ricetta, RicettaDTO.class);
        }
        return ricettaDTO;
    }
}
