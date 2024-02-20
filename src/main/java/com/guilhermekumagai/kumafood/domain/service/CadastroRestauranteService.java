package com.guilhermekumagai.kumafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilhermekumagai.kumafood.domain.exception.EntidadeNaoEncontradaException;
import com.guilhermekumagai.kumafood.domain.model.Cozinha;
import com.guilhermekumagai.kumafood.domain.model.Restaurante;
import com.guilhermekumagai.kumafood.domain.repository.CozinhaRepository;
import com.guilhermekumagai.kumafood.domain.repository.RestauranteRepository;

@Service
public class CadastroRestauranteService {

	@Autowired
	RestauranteRepository restauranteRepository;
	
	@Autowired
	CozinhaRepository cozinhaRepository;
	
	public Restaurante salvar(Restaurante restaurante) {
		
		Long cozinhaId = restaurante.getCozinha().getId();
		Cozinha cozinha = cozinhaRepository.findById(cozinhaId)
					.orElseThrow(() -> new EntidadeNaoEncontradaException(
							String.format("Nao existe cadastro de cozinha com codigo %d", cozinhaId)));
		
		if(cozinha == null) {
			throw new EntidadeNaoEncontradaException(
					String.format("Nao existe cadastro de cozinha com codigo %d", cozinhaId));
		}
		
		restaurante.setCozinha(cozinha);
		
		return restauranteRepository.save(restaurante);
	}
	
}
