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

	public List<ExtratoDTO> consultaExtrato(Integer numeroConta, Integer numeroAgencia) {

		List<Extrato> listaTodosPeloDestino = extratoRepository.findAllByNumeroContaDestinoAndNumeroAgenciaDestino(numeroConta, numeroAgencia);
		List<Extrato> listaTodosPeloOrigem = extratoRepository
				.findAllByNumeroContaOrigemAndNumeroAgenciaOrigem(numeroConta, numeroAgencia);
		listaTodosPeloDestino.addAll(listaTodosPeloOrigem);

		ExtratoDTO extratoDto = new ExtratoDTO();
		List<ExtratoDTO> list = extratoDto.converter(listaTodosPeloDestino);

		return list;
	}
}