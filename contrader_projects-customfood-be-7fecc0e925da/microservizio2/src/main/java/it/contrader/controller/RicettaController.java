package it.contrader.controller;

import it.contrader.converter.RicettaConverter;
import it.contrader.dto.IngredienteDTO;
import it.contrader.dto.PivotDTO;
import it.contrader.dto.RicettaDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.IngredienteService;
import it.contrader.service.PivotService;
import it.contrader.service.RicettaService;
import it.contrader.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("/ricetta")
@CrossOrigin(origins = "http://localhost:4200")
public class RicettaController extends AbstractController<RicettaDTO> {
    @Autowired
    private RicettaService ricettaService;

    @GetMapping("/getallMyRecipes")
    private List<RicettaDTO> getAllByUserId(@RequestParam("id") Integer id) {
        return ricettaService.getAllByUserId(id);
    }

    @GetMapping("/getallPublicRecipes")
    private List<RicettaDTO> getAllByPublic() {
        return ricettaService.getAllPublic();
    }

    @GetMapping("/getLastInsert")
    private RicettaDTO getLastInsert() {
        RicettaDTO res = new RicettaDTO();
        List<RicettaDTO>list = (List<RicettaDTO>) ricettaService.getAll();
        if(list.size()==1)
        {
            res = list.get(0);
        }else{
           res = list.get(list.size() - 1);
        }
        return res;
    }
    @GetMapping("/getMaxIndex")
    private RicettaDTO getMaxIndex() {
        List<RicettaDTO> listRicette = (List<RicettaDTO>) ricettaService.getAll();
        RicettaDTO ricetta = listRicette.get(listRicette.size()-1);
        return ricetta;
    }
}