package br.com.sistema.sistemabancario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistema.sistemabancario.entity.Extrato;
import br.com.sistema.sistemabancario.service.ExtratoService;

@RestController
@RequestMapping("/consulta-extrato")
public class ExtratoController {
	@Autowired
	private ExtratoService extratoService; 

	@GetMapping(path = "/{numeroConta}")
	public ResponseEntity<?> consultaExtrato(@PathVariable Long numeroConta){
		try {
			List<Extrato> extratos = extratoService.consultaExtrato(numeroConta);
			return new ResponseEntity<List<Extrato>>(extratos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}	
		
	}
}
