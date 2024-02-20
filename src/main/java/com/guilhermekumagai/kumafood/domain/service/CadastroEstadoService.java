package com.guilhermekumagai.kumafood.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.guilhermekumagai.kumafood.domain.exception.EntidadeEmUsoException;
import com.guilhermekumagai.kumafood.domain.exception.EntidadeNaoEncontradaException;
import com.guilhermekumagai.kumafood.domain.model.Estado;
import com.guilhermekumagai.kumafood.domain.repository.EstadoRepository;

@Service
public class CadastroEstadoService {

	@Autowired
	EstadoRepository estadoRepository;

	public Estado salvar(Estado estado) {
		return estadoRepository.save(estado);
	}
	
	public List<Estado> listar() {
		return estadoRepository.findAll();
	}
	
	public Estado buscar(Long estadoId) {
		return estadoRepository.findById(estadoId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(
						String.format("Nao existe estado com o codigo %d", estadoId)));
	}
	
	public void remover(Long estadoId) {
		try {

		estadoRepository.deleteById(estadoId);
		
		}catch (EmptyResultDataAccessException e) {
			
			throw new EntidadeNaoEncontradaException(
					String.format("Nao existe estado com o codigo %d", estadoId));
			
		}catch(DataIntegrityViolationException e) {
			
			throw new EntidadeEmUsoException(
					String.format("Estado de codigo %d nao pode ser removido, pois esta em uso", estadoId));
		}
	}

}
