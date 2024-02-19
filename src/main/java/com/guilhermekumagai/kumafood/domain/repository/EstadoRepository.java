package com.guilhermekumagai.kumafood.domain.repository;

import java.util.List;

import com.guilhermekumagai.kumafood.domain.model.Estado;

public interface EstadoRepository {
	
	List<Estado> todos();
	Estado porId(Long id);
	Estado adicionar(Estado estado);
	void remover(Long estadoId);
}