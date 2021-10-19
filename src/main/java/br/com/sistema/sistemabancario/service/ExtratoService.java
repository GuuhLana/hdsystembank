package br.com.sistema.sistemabancario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sistema.sistemabancario.entity.Extrato;
import br.com.sistema.sistemabancario.repository.ExtratoRepository;

@Service
public class ExtratoService {

	@Autowired
	private ExtratoRepository extratoRepository;
	
	public List<Extrato> consultaExtrato(Long numeroConta){
		List<Extrato> extrato = extratoRepository.findAllByDestino(numeroConta);
		List<Extrato> findAllByOrigem = extratoRepository.findAllByOrigem(numeroConta);
		
		extrato.addAll(findAllByOrigem);
		System.out.println(extrato);
		return extrato;
	}
}