package br.com.sistema.sistemabancario.model;

public class transferenciaRequest {
	private Long idOrigem;
	private Long idDestino;
	private double valor;
	
	public transferenciaRequest(Long idOrigem, Long idDestino, double valor) {
		this.idOrigem = idOrigem;
		this.idDestino = idDestino;
		this.valor = valor;
	}

	public Long getIdOrigem() {
		return idOrigem;
	}

	public void setIdOrigem(Long idOrigem) {
		this.idOrigem = idOrigem;
	}

	public Long getIdDestino() {
		return idDestino;
	}

	public void setIdDestino(Long idDestino) {
		this.idDestino = idDestino;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
	
	
}
