package br.com.sistema.sistemabancario.model;

public class SaldoResponse {

	private String numeroConta;
	private String nomeTitular;
	private double saldo;

	public String getNomeTitular() {
		return nomeTitular;
	}

	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public SaldoResponse(String numeroConta, String nomeTitular, double saldo) {
		this.numeroConta = numeroConta;
		this.saldo = saldo;
		this.nomeTitular = nomeTitular;
	}
}
