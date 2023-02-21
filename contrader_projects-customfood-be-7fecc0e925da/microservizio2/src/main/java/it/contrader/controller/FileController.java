package it.contrader.controller;

import it.contrader.dto.FileDTO;
import it.contrader.service.FileService;
import it.contrader.service.IngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/file")
@CrossOrigin(origins = "http://localhost:4200")
public class FileController extends AbstractController<FileDTO>{
    @Autowired
    private FileService fileService;


    @PostMapping("/uploadPic")
    public ResponseEntity<?> uploadImageToFileSystem (@RequestParam("file") MultipartFile file) throws IOException {
        String uploadFile ;
        try {
             uploadFile = fileService.uploadImageToFileSystem(file);
            return ResponseEntity.status(HttpStatus.OK).body(uploadFile);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(file);

        }
    }

    @GetMapping("/DownloadPic")
    public FileDTO downloadImageFromFileSystem(@RequestParam("id") Integer id ) throws IOException {
        FileDTO fileData = fileService.downloadImage(id);
        return fileData;
    }


}
