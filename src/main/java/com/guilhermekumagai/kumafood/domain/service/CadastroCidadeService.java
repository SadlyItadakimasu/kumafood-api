package com.guilhermekumagai.kumafood.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.guilhermekumagai.kumafood.domain.exception.EntidadeEmUsoException;
import com.guilhermekumagai.kumafood.domain.exception.EntidadeNaoEncontradaException;
import com.guilhermekumagai.kumafood.domain.model.Cidade;
import com.guilhermekumagai.kumafood.domain.repository.CidadeRepository;

@Service
public class CadastroCidadeService {

	@Autowired
	CidadeRepository cidadeRepository;

	public Cidade salvar(Cidade cidade) {
		return cidadeRepository.adicionar(cidade);
	}

	public List<Cidade> listar() {
		return cidadeRepository.todas();
	}

	public Cidade buscar(Long cidadeId) {
		return cidadeRepository.porId(cidadeId);
	}

	public void remover(Long cidadeId) {
		try {

			cidadeRepository.remover(cidadeId);
		}catch(DataIntegrityViolationException e) {
			
			throw new EntidadeEmUsoException(
					String.format("Cidade de codigo %d nao pode ser removido, pois esta em uso", cidadeId));
			
		} catch (EmptyResultDataAccessException e) {

			throw new EntidadeNaoEncontradaException(String.format("Nao existe cidade com o codigo %d", cidadeId));
		}
	

	}
}
