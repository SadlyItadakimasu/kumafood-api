package com.guilhermekumagai.kumafood.domain.repository;

import java.util.List;

import com.guilhermekumagai.kumafood.domain.model.Cidade;

public interface CidadeRepository {
	
	List<Cidade> todas();
	Cidade porId(Long id);
	Cidade adicionar(Cidade cidade);
	void remover(Long cidadeId);
}
