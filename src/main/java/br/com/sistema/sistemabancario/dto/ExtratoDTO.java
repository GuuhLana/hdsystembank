package br.com.sistema.sistemabancario.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.sistema.sistemabancario.entity.Extrato;

public class ExtratoDTO {

	private Long id;
	private Long destino;
	private Long origem;
	private LocalDateTime dataTransferencia;
	private double valor;

	public ExtratoDTO() {

	}

	public Extrato criarExtrato() {
		return new Extrato(destino, origem, dataTransferencia, valor);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDestino() {
		return destino;
	}

	public void setDestino(Long destino) {
		this.destino = destino;
	}

	public Long getOrigem() {
		return origem;
	}

	public void setOrigem(Long origem) {
		this.origem = origem;
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
		this.destino = extrato.getDestino();
		this.origem = extrato.getOrigem();
		this.dataTransferencia = extrato.getDataTransferencia();
		this.valor = extrato.getValor();
	}

	public List<ExtratoDTO> converter(List<Extrato> extratos) {
		return extratos.stream().map(ExtratoDTO::new).collect(Collectors.toList());
	}

}
