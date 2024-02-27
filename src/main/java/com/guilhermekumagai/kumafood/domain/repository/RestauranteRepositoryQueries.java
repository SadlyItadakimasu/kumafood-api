package com.guilhermekumagai.kumafood.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import com.guilhermekumagai.kumafood.domain.model.Restaurante;

public interface RestauranteRepositoryQueries {

	List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal);

}