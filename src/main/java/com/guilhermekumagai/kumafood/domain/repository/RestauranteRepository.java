package com.guilhermekumagai.kumafood.domain.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.guilhermekumagai.kumafood.domain.model.Restaurante;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long>, RestauranteRepositoryQueries,
JpaSpecificationExecutor<Restaurante>{

	List<Restaurante> queryByTaxaFreteBetween(BigDecimal taxaInicial, BigDecimal taxaFinal);
	
	Optional<Restaurante> findFirstRestauranteByNomeContaining(String nome);
	
	int countByCozinhaId(Long cozinha);
}
