package com.guilhermekumagai.kumafood.infrastructure.repository;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.guilhermekumagai.kumafood.domain.model.Estado;
import com.guilhermekumagai.kumafood.domain.repository.EstadoRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class EstadoRepositoryJpa implements EstadoRepository{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Estado> todos(){
		return manager.createQuery("from Estado", Estado.class).getResultList();
	}
	
	@Override
	public Estado porId(Long id) {
		return manager.find(Estado.class, id);
	}
	
	@Transactional
	@Override
	public Estado adicionar(Estado estado) {
		return manager.merge(estado);
	}
	
	@Transactional
	@Override
	public void remover(Long estadoId) {
		Estado estado = porId(estadoId);
		if (estado == null) {
            throw new EmptyResultDataAccessException(1);
        }
		manager.remove(estado);
	}
	
}