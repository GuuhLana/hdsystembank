package br.com.sistema.sistemabancario.model;

public class transferenciaRequest {
	private Integer contaOrigemNumero;
	private Integer contaOrigemAgencia;
	private Integer contaDestinoNumero;
	private Integer contaDestinoAgencia;
	private double valor;

	public transferenciaRequest(Integer contaOrigemNumero, Integer contaOrigemAgencia, Integer contaDestinoNumero,
			Integer contaDestinoAgencia, double valor) {
		super();
		this.contaOrigemNumero = contaOrigemNumero;
		this.contaOrigemAgencia = contaOrigemAgencia;
		this.contaDestinoNumero = contaDestinoNumero;
		this.contaDestinoAgencia = contaDestinoAgencia;
		this.valor = valor;
	}

	public Integer getContaOrigemNumero() {
		return contaOrigemNumero;
	}

	public void setContaOrigemNumero(Integer contaOrigemNumero) {
		this.contaOrigemNumero = contaOrigemNumero;
	}

	public Integer getContaOrigemAgencia() {
		return contaOrigemAgencia;
	}

	public void setContaOrigemAgencia(Integer contaOrigemAgencia) {
		this.contaOrigemAgencia = contaOrigemAgencia;
	}

	public Integer getContaDestinoNumero() {
		return contaDestinoNumero;
	}

	public void setContaDestinoNumero(Integer contaDestinoNumero) {
		this.contaDestinoNumero = contaDestinoNumero;
	}

	public Integer getContaDestinoAgencia() {
		return contaDestinoAgencia;
	}

	public void setContaDestinoAgencia(Integer contaDestinoAgencia) {
		this.contaDestinoAgencia = contaDestinoAgencia;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
