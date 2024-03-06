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

	public SaldoResponse verificarSaldo(Integer numeroConta, Integer numeroAgencia) {
		Optional<Conta> conta = contaRepository.findByNumeroAndAgencia(numeroConta, numeroAgencia);
		SaldoResponse saldo = new SaldoResponse(conta.get().getNumero(), conta.get().getTitular(),
				conta.get().getSaldo());

		return saldo;
	}

	public void transferir(Integer numeroContaOrigem, Integer numeroAgenciaOrigem, Integer numeroContaDestino,
			Integer numeroAgenciaDestino, double valor) {
		Optional<Conta> contaOrigem = contaRepository.findByNumeroAndAgencia(numeroContaOrigem, numeroAgenciaOrigem);
		Optional<Conta> contaDestino = contaRepository.findByNumeroAndAgencia(numeroContaDestino, numeroAgenciaDestino);

		if (contaOrigem.get().getSaldo() >= valor) {
			contaOrigem.get().transferir(valor);
			contaDestino.get().receberTransferencia(valor);

			contaRepository.save(contaOrigem.get());
			contaRepository.save(contaDestino.get());

			Extrato log = new Extrato(contaOrigem.get().getNumero(), contaOrigem.get().getAgencia(),
					contaDestino.get().getNumero(), contaDestino.get().getAgencia(), LocalDateTime.now(), valor);

			extratoRepository.save(log);
		} else {
			throw new RuntimeException("Não foi possivel realizar a transferencia, verifique os valores inseridos");
		}

	}

	public ContaDTO criarConta(ContaDTO dto) {
		Conta conta = dto.criarConta();

		boolean existeConta = contaRepository.existsByNumeroAndAgencia(conta.getNumero(), conta.getAgencia());

		if (existeConta) {
			throw new RuntimeException("Já existe uma conta cadastrada na agencia: " + conta.getAgencia()
					+ " com o número: " + conta.getNumero());
		} else {
			contaRepository.save(conta);
			return new ContaDTO(conta);
		}
	}

	public void depositar() {

	}

}