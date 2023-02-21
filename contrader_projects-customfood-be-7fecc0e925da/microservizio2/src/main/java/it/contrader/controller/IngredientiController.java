package it.contrader.controller;

import it.contrader.dto.*;
import it.contrader.model.Ingrediente;
import it.contrader.service.IngredienteService;
import it.contrader.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/ingrediente")
@CrossOrigin(origins = "http://localhost:4200")
public class IngredientiController extends AbstractController<IngredienteDTO>{
	@Autowired
	private IngredienteService ingredienteService;

	@Override
	@PutMapping("/update")
	public IngredienteDTO update(@RequestBody IngredienteDTO dto)
	{
		if(!ingredienteService.exist(dto.getNome())){
			ingredienteService.update(dto);
		}
		return ingredienteService.findIngByNome(dto.getNome());
	}

	@Override
	@PostMapping("/insert")
	public IngredienteDTO insert (@RequestBody IngredienteDTO  dto) {
		if(!ingredienteService.exist(dto.getNome())) {
			ingredienteService.insert(dto);
		}
		return ingredienteService.findIngByNome(dto.getNome());
	}

	@GetMapping("/readByName")
	public IngredienteDTO readByName(@RequestParam("nome") String nome)
	{
		return ingredienteService.findIngByNome(nome);
	}

}