package com.guilhermekumagai.kumafood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guilhermekumagai.kumafood.domain.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
	
}
