package br.com.sistema.sistemabancario.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sistema.sistemabancario.dto.ContaDTO;
import br.com.sistema.sistemabancario.entity.Conta;
import br.com.sistema.sistemabancario.entity.Extrato;
import br.com.sistema.sistemabancario.model.SaldoResponse;
import br.com.sistema.sistemabancario.repository.ContaRepository;
import br.com.sistema.sistemabancario.repository.ExtratoRepository;

@Service
public class ContaService {

	@Autowired
	private ContaRepository contaRepository;

	@Autowired
	private ExtratoRepository extratoRepository;

	public SaldoResponse verificarSaldo(Long id) {
		Optional<Conta> conta = contaRepository.findById(id);
		SaldoResponse saldo = new SaldoResponse(conta.get().getNumero(), conta.get().getTitular() , conta.get().getSaldo());
		
		return saldo;
	}

	public void transferir(Long origem, Long destino, double valor) {
		Optional<Conta> contaOrigem = contaRepository.findById(origem);
		Optional<Conta> contaDestino = contaRepository.findById(destino);

		if (contaOrigem.get().getSaldo() >= valor) {
			contaOrigem.get().transferir(valor);
			contaDestino.get().receberTransferencia(valor);

			contaRepository.save(contaOrigem.get());
			contaRepository.save(contaDestino.get());

			Extrato log = new Extrato(contaDestino.get().getId(), contaOrigem.get().getId(), LocalDateTime.now(),
					valor);

			extratoRepository.save(log);
		} else {
			throw new RuntimeException("NÃ£o foi possivel realizar a transferencia, verifique os valores inseridos");
		}

	}

	public ContaDTO criarConta(ContaDTO dto) {
		Conta conta = dto.criarConta();	
		
		boolean existsByNumero = contaRepository.existsByNumero(conta.getNumero());
		if(existsByNumero) {
			throw new RuntimeException("Conta existente");
		}
		else {
			contaRepository.save(conta);
			return new ContaDTO(conta);
		}
	}
	
}