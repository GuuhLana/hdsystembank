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

	private Long destino;
	private Long origem;
	private LocalDateTime dataTransferencia;
	private double valor;

	public Extrato(Long destino, Long origem, LocalDateTime dataTransferencia, double valor) {
		this.destino = destino;
		this.origem = origem;
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
	

}
