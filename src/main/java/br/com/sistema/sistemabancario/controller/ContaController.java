package br.com.sistema.sistemabancario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/conta")
@Api(tags = "Conta", description = "Operações de Contas bancarias")
public class ContaController {
	@Autowired
	private ContaService contaService;

	@ApiOperation(value = "Retorna as informações referentes a conta selecionada")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Saldo da conta retornado com sucesso"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	})
	@GetMapping(path = "/saldo/{numeroConta}/{numeroAgencia}")
	public ResponseEntity<?> consultarSaldo(@PathVariable Integer numeroConta, @PathVariable Integer numeroAgencia) {
		try {
			SaldoResponse saldo = contaService.verificarSaldo(numeroConta, numeroAgencia);
			return new ResponseEntity<SaldoResponse>(saldo, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "Cadastra uma conta")
	@PostMapping(path = "/cadastrar")
	public ResponseEntity<?> criarConta(@RequestBody ContaDTO dto) {
		try {
			ContaDTO contaDTO = contaService.criarConta(dto);
			return new ResponseEntity<ContaDTO>(contaDTO, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@ApiOperation(value = "Transfere valores entre contas")
	@PostMapping(path = "/transferir")
	public ResponseEntity<String> transferir(@RequestBody transferenciaRequest request) {
		try {
			contaService.transferir(request.getContaOrigemNumero(), request.getContaOrigemAgencia(),
					request.getContaDestinoNumero(), request.getContaDestinoAgencia(), request.getValor());
			return new ResponseEntity<String>("Transferencia realizada com sucesso", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@ApiOperation(value = "Deleta a conta")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Conta excluida com sucesso"),
			@ApiResponse(code = 404, message = "Conta não encontrada"),
	})
	@DeleteMapping(path = "/deletar/{id}")
	public ResponseEntity<String> deletar(@PathVariable Long id){
		try {
			contaService.deletarConta(id);
			return new ResponseEntity<String>("Conta deleta com sucesso", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}	
	}
}
