package br.com.sistema.sistemabancario.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.sistema.sistemabancario.entity.Extrato;

public class ExtratoDTO {

	private Long id;
	Integer numeroContaOrigem;
	Integer numeroAgenciaOrigem;
	Integer numeroContaDestino;
	Integer numeroAgenciaDestino;
	private LocalDateTime dataTransferencia;
	private double valor;

	public ExtratoDTO() {

	}

	public Extrato criarExtrato() {
		return new Extrato(numeroContaOrigem, numeroAgenciaOrigem, numeroContaDestino, numeroAgenciaDestino,
				dataTransferencia, valor);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumeroContaOrigem() {
		return numeroContaOrigem;
	}

	public void setNumeroContaOrigem(Integer numeroContaOrigem) {
		this.numeroContaOrigem = numeroContaOrigem;
	}

	public Integer getNumeroAgenciaOrigem() {
		return numeroAgenciaOrigem;
	}

	public void setNumeroAgenciaOrigem(Integer numeroAgenciaOrigem) {
		this.numeroAgenciaOrigem = numeroAgenciaOrigem;
	}

	public Integer getNumeroContaDestino() {
		return numeroContaDestino;
	}

	public void setNumeroContaDestino(Integer numeroContaDestino) {
		this.numeroContaDestino = numeroContaDestino;
	}

	public Integer getNumeroAgenciaDestino() {
		return numeroAgenciaDestino;
	}

	public void setNumeroAgenciaDestino(Integer numeroAgenciaDestino) {
		this.numeroAgenciaDestino = numeroAgenciaDestino;
	}

	public LocalDateTime getDataTransferencia() {
		return dataTransferencia;
	}

	public void setDataTransferencia(LocalDateTime dataTransferencia) {
		this.dataTransferencia = dataTransferencia;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public ExtratoDTO(Extrato extrato) {
		this.id = extrato.getId();
		this.numeroContaOrigem = extrato.getNumeroContaOrigem();
		this.numeroAgenciaOrigem = extrato.getNumeroAgenciaOrigem();
		this.numeroContaDestino = extrato.getNumeroContaDestino();
		this.numeroAgenciaDestino = extrato.getNumeroAgenciaDestino();
		this.dataTransferencia = extrato.getDataTransferencia();
		this.valor = extrato.getValor();
	}

	public List<ExtratoDTO> converter(List<Extrato> extratos) {
		return extratos.stream().map(ExtratoDTO::new).collect(Collectors.toList());
	}

}
