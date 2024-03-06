package br.com.sistema.sistemabancario.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sistema.sistemabancario.entity.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {
	
	boolean existsByNumeroAndAgencia(Integer numero, Integer agencia);
	
	Optional<Conta> findByNumeroAndAgencia(Integer numero, Integer agencia);
	
}
