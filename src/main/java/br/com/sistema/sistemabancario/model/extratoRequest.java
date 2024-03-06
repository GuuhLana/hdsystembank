package br.com.sistema.sistemabancario.model;

public class extratoRequest {

	private Integer contaNumero;
	private Integer contaAgencia;
	
	public extratoRequest(Integer contaNumero, Integer contaAgencia) {
		super();
		this.contaNumero = contaNumero;
		this.contaAgencia = contaAgencia;
	}
	public Integer getContaNumero() {
		return contaNumero;
	}
	public void setContaNumero(Integer contaNumero) {
		this.contaNumero = contaNumero;
	}
	public Integer getContaAgencia() {
		return contaAgencia;
	}
	public void setContaAgencia(Integer contaAgencia) {
		this.contaAgencia = contaAgencia;
	}
	
	
}
