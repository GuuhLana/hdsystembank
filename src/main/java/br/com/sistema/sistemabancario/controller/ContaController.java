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

import br.com.sistema.sistemabancario.entity.Conta;
import br.com.sistema.sistemabancario.model.transferenciaRequest;
import br.com.sistema.sistemabancario.service.ContaService;

@RestController
@RequestMapping("/hdbank")
public class ContaController {
	@Autowired
	private ContaService contaService;

	@GetMapping(path = "/{id}")
	public double consultarSaldo(@PathVariable Long id) {
		return contaService.verificarSaldo(id);
	}
	
	
	@PostMapping(path = "/criar-conta")
	public ResponseEntity<?> criaConta(@RequestBody Conta conta) {
		try {
			contaService.criarConta(conta);
			return new ResponseEntity<Conta>(conta, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	

	@PostMapping
	public ResponseEntity<String> transferir(@RequestBody transferenciaRequest request) {

		try {
			contaService.transferir(request.getIdOrigem(), request.getIdDestino(), request.getValor());
			return new ResponseEntity<String>("Transferencia realizada com sucesso", HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
