package com.guilhermekumagai.kumafood.infrastructure.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.guilhermekumagai.kumafood.domain.model.Permissao;
import com.guilhermekumagai.kumafood.domain.repository.PermissaoRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class PermissaoRepositoryJpa implements PermissaoRepository{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Permissao> todas(){
		return manager.createQuery("from Permissao", Permissao.class).getResultList();
	}
	
	@Override
	public Permissao porId(Long id) {
		return manager.find(Permissao.class, id);
	}
	
	@Transactional
	@Override
	public Permissao adicionar(Permissao permissao) {
		return manager.merge(permissao);
	}
	
	@Transactional
	@Override
	public void remover(Permissao permissao) {
		permissao = porId(permissao.getId());
		manager.remove(permissao.getClass());
	}
	
}
