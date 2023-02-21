package it.contrader.service;

import it.contrader.dao.FileRepository;
import it.contrader.dto.FileDTO;
import it.contrader.model.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

@Service
public class FileService extends AbstractService<File, FileDTO> {

    @Autowired
    FileRepository fileRepository;

    java.io.File file = new java.io.File("src/main/FileUploaded/");
    private final String FolderPath = file.getAbsolutePath();

    public String uploadImageToFileSystem(MultipartFile file)throws IOException{
        String filePath = FolderPath + file.getOriginalFilename();
        FileDTO fileDto = new FileDTO();
                fileDto.setNome(file.getOriginalFilename());
                fileDto.setType(file.getContentType());
                fileDto.setPath(filePath);
        file.transferTo(new java.io.File(filePath));
        fileRepository.save(converter.toEntity(fileDto));

                if(fileDto != null ){
                    return "file uploaded succesfully  : "+ filePath;
                }


        return "Error Uploading File  : "+filePath;
    }



    public FileDTO downloadImage(Integer  id) throws IOException {
        Optional<File> image = fileRepository.findById(id);
        String filePath = image.get().getPath();
        return converter.toDTO(image.get());
    }


}
