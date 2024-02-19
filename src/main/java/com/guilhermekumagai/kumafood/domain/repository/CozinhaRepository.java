package com.guilhermekumagai.kumafood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guilhermekumagai.kumafood.domain.model.Cozinha;
@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long>{

}
	
	
