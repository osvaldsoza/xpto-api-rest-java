package br.com.xpto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.xpto.dto.StateDTO;
import br.com.xpto.service.StateService;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/xpto/estados")
public class StateController {

	@Autowired
	private StateService stateService;

	@PostMapping("/load-file")
	public ResponseEntity readFileStateCSV(@RequestParam("file") MultipartFile file) {
		try {
			List<StateDTO> stateDTOS = stateService.readFileStateCSV(file);
			return new ResponseEntity<>(stateDTOS, HttpStatus.OK);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/*
	 * Retorna todos as informações da base de dados
	 */
	@GetMapping()
	public ResponseEntity<Page<StateDTO>> listAllCities(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size) {
		Page<StateDTO> stateDTOPage = stateService.listAllCities( page, size);
		return new ResponseEntity<>(stateDTOPage, HttpStatus.OK);
	}
}
