package br.com.sistema.sistemabancario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistema.sistemabancario.dto.ContaDTO;
import br.com.sistema.sistemabancario.model.SaldoResponse;
import br.com.sistema.sistemabancario.model.transferenciaRequest;
import br.com.sistema.sistemabancario.service.ContaService;

@RestController
@RequestMapping("/api/conta")
public class ContaController {
	@Autowired
	private ContaService contaService;

	@GetMapping(path = "/saldo/{id}")
	public ResponseEntity<?> consultarSaldo(@PathVariable Long id) {
		try {
			SaldoResponse saldo = contaService.verificarSaldo(id);
			return new ResponseEntity<SaldoResponse>(saldo, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@PostMapping(path = "/cadastrar")
	public ResponseEntity<?> criarConta(@RequestBody ContaDTO dto) {
		try {
			ContaDTO contaDTO = contaService.criarConta(dto);
			return new ResponseEntity<ContaDTO>(contaDTO, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	

	@PostMapping(path = "/transferir")
	public ResponseEntity<String> transferir(@RequestBody transferenciaRequest request) {
		try {
			contaService.transferir(request.getIdOrigem(), request.getIdDestino(), request.getValor());
			return new ResponseEntity<String>("Transferencia realizada com sucesso", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
