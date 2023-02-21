package it.contrader.converter;

import it.contrader.dto.PivotDTO;
import it.contrader.model.Pivot;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PivotConverter extends AbstractConverter<Pivot, PivotDTO>{

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Pivot toEntity(PivotDTO pivotDTO) {
        Pivot pivot = null;
        if (pivotDTO != null) {
            pivot = modelMapper.map(pivotDTO, Pivot.class);
        }
        return pivot;
    }




    @Override
    public PivotDTO toDTO(Pivot pivot) {
        PivotDTO pivotDTO = null;
        if (pivot != null) {
            pivotDTO = modelMapper.map(pivot, PivotDTO.class);
        }
        return pivotDTO;
    }
}
