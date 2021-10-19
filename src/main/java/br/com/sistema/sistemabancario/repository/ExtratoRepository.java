package br.com.sistema.sistemabancario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sistema.sistemabancario.entity.Extrato;

public interface ExtratoRepository extends JpaRepository<Extrato, Long>{

	List<Extrato> findAllByOrigem(Long origem);

	List<Extrato> findAllByDestino(Long destino);

}
