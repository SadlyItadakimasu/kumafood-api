package com.guilhermekumagai.kumafood.infrastructure.repository.spec;

import java.math.BigDecimal;

import org.springframework.data.jpa.domain.Specification;

import com.guilhermekumagai.kumafood.domain.model.Restaurante;

public class RestauranteSpecs {

	public static Specification<Restaurante> comFreteGratis(){
		return (root, query, criteriaBuilder) ->
		criteriaBuilder.equal(root.get("taxaFrete"), BigDecimal.ZERO);
	}
	
	public static Specification<Restaurante> comNomeIgual(String nome){
		return (root, query, criteriaBuilder) ->
		criteriaBuilder.like(root.get("nome"), "%"+nome+"%");
	}
}
