package br.com.sistema.sistemabancario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistema.sistemabancario.dto.ExtratoDTO;
import br.com.sistema.sistemabancario.model.extratoRequest;
import br.com.sistema.sistemabancario.service.ExtratoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/extrato")
@Api(tags = "Extrato", description = "Operações de extratos bancarios")
public class ExtratoController {
	@Autowired
	private ExtratoService extratoService; 
	
	@ApiOperation(value = "Retorna o extrato da conta selecionada")
	@GetMapping(path = "/consultar")
	public ResponseEntity<?> consultaExtrato(@RequestBody extratoRequest request){
		try {
			Integer nmrConta = request.getContaNumero();
			Integer nmrAgencia = request.getContaAgencia();
			
			List<ExtratoDTO> extratos = extratoService.consultaExtrato(nmrConta, nmrAgencia);
			return new ResponseEntity<List<ExtratoDTO>>(extratos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}
}
