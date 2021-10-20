package br.com.sistema.sistemabancario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sistema.sistemabancario.dto.ExtratoDTO;
import br.com.sistema.sistemabancario.entity.Extrato;
import br.com.sistema.sistemabancario.repository.ExtratoRepository;

@Service
public class ExtratoService {

	@Autowired
	private ExtratoRepository extratoRepository;
	
	public List<ExtratoDTO> consultaExtrato(Long numeroConta){
		
		List<Extrato> extrato = extratoRepository.findAllByDestino(numeroConta);
		List<Extrato> findAllByOrigem = extratoRepository.findAllByOrigem(numeroConta);
		extrato.addAll(findAllByOrigem);
		
		ExtratoDTO extratoDto = new ExtratoDTO();
		List<ExtratoDTO> list = extratoDto.converter(extrato);
		
		return list;
	}
}