package it.contrader.converter;

import it.contrader.dto.FileDTO;
import it.contrader.model.File;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileConverter extends AbstractConverter<File, FileDTO>{
    @Autowired
    ModelMapper modelMapper;
    @Override
    public File toEntity(FileDTO fileDTO) {
        File file = null;
        if (fileDTO != null) {
            file = modelMapper.map(fileDTO, File.class);;
        }
        return file;
    }

    @Override
    public FileDTO toDTO(File file) {
        FileDTO fileDTO = null;
        if (file != null) {
            fileDTO = modelMapper.map(file, FileDTO.class);;
        }
        return fileDTO;
    }
}
