package br.com.sistema.sistemabancario.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_EXTRATO")
public class Extrato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	Integer numeroContaOrigem;
	Integer numeroAgenciaOrigem;
	Integer numeroContaDestino;
	Integer numeroAgenciaDestino;
	private LocalDateTime dataTransferencia;
	private double valor;

	public Extrato(Integer numeroContaOrigem, Integer numeroAgenciaOrigem, Integer numeroContaDestino,
			Integer numeroAgenciaDestino, LocalDateTime dataTransferencia, double valor) {
		this.numeroContaOrigem = numeroContaOrigem;
		this.numeroAgenciaOrigem = numeroAgenciaOrigem;
		this.numeroContaDestino = numeroContaDestino;
		this.numeroAgenciaDestino = numeroAgenciaDestino;
		this.dataTransferencia = dataTransferencia;
		this.valor = valor;
	}

	public Extrato() {

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

}
