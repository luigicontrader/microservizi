package it.contrader.controller;

import it.contrader.dto.LoginDTO;
import it.contrader.dto.PivotDTO;
import it.contrader.dto.RicettaDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.PivotService;
import it.contrader.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/pivot")
@CrossOrigin(origins = "http://localhost:4200")
public class PivotController extends AbstractController<PivotDTO>{
	@Autowired
	private PivotService pivotService;

	@GetMapping("/getIngrByRecipeId")
	private List<PivotDTO> getAllByUserId(@RequestParam("id") Integer id) {
		return pivotService.findIdRicetta(id);
	}

}