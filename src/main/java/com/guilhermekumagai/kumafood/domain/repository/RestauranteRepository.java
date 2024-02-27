package com.guilhermekumagai.kumafood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guilhermekumagai.kumafood.domain.model.Restaurante;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long>, RestauranteRepositoryQueries{
	
}
