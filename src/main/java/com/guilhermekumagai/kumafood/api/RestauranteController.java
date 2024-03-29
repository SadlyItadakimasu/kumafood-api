package com.guilhermekumagai.kumafood.api;

import static com.guilhermekumagai.kumafood.infrastructure.repository.spec.RestauranteSpecs.comFreteGratis;
import static com.guilhermekumagai.kumafood.infrastructure.repository.spec.RestauranteSpecs.comNomeIgual;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guilhermekumagai.kumafood.domain.exception.EntidadeNaoEncontradaException;
import com.guilhermekumagai.kumafood.domain.model.Restaurante;
import com.guilhermekumagai.kumafood.domain.repository.RestauranteRepository;
import com.guilhermekumagai.kumafood.domain.service.CadastroRestauranteService;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Autowired
	private CadastroRestauranteService cadastroRestaurante;
	
	@GetMapping
	public List<Restaurante> listar(){
		return restauranteRepository.findAll();
	}
	
	@GetMapping("por-nome-e-frete")
	public List<Restaurante> porNomeFrete(
			String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal){
		return restauranteRepository.find(nome, taxaFreteInicial, taxaFreteFinal);
	}

	@GetMapping("/{restauranteId}")
	public ResponseEntity<Restaurante> buscar(@PathVariable Long restauranteId){
		Optional<Restaurante> restaurante = restauranteRepository.findById(restauranteId);
		if(restaurante.isPresent()) {
			return ResponseEntity.ok(restaurante.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<?> adicionar(@RequestBody Restaurante restaurante){
		try {
			
		restaurante = cadastroRestaurante.salvar(restaurante);
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(restaurante);
										
		}catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest()
					.body(e.getMessage());
		}
		
	}
	
	@PutMapping("/{restauranteId}")
	public ResponseEntity<?> atualizar(@PathVariable Long restauranteId, @RequestBody Restaurante restaurante){
		try {
		Restaurante restauranteAtual = restauranteRepository.findById(restauranteId)
			.orElse(null);
		if(restauranteAtual != null) {
			
			BeanUtils.copyProperties(restaurante, restauranteAtual, "id", "formasPagamento", "endereco", "dataCadastro");
			
			restauranteAtual = cadastroRestaurante.salvar(restauranteAtual);
			
			return ResponseEntity.ok(restaurante);
		}
		return ResponseEntity.notFound().build();
	}catch(EntidadeNaoEncontradaException e) {
		return ResponseEntity.badRequest()
				.body(e.getMessage());
	}
	}
	
	@PatchMapping("/{restauranteId}")
	public ResponseEntity<?> atualizarParcial(@PathVariable Long restauranteId,
			@RequestBody Map <String, Object> campo){
		
		Restaurante restauranteAtual = restauranteRepository.findById(restauranteId).orElse(null);
		
		if (restauranteAtual == null) {
			return ResponseEntity.notFound().build();
		}
		
		merge(campo, restauranteAtual);
		
		return atualizar(restauranteId, restauranteAtual);		
	}

	private void merge(Map<String, Object> dadosOrigem, Restaurante restauranteDestino) {
		
		ObjectMapper objectMapper = new ObjectMapper();
		Restaurante restauranteOrigem = objectMapper.convertValue(dadosOrigem, Restaurante.class);
		
		dadosOrigem.forEach((nomePropriedade, valorPropriedade) ->{
			Field field = ReflectionUtils.findRequiredField(Restaurante.class, nomePropriedade);
			field.setAccessible(true);
			
			Object novoValor = org.springframework.util.ReflectionUtils.getField(field, restauranteOrigem);
			ReflectionUtils.setField(field, restauranteDestino, novoValor);

		});
	}
	
	@GetMapping("/com-frete-gratis")
	public List<Restaurante> restaurantesComFreteGratis(@RequestParam("nome") String nome) {
		
		return restauranteRepository.findAll(comFreteGratis().and(comNomeIgual(nome)));
	}
	
	@GetMapping("/primeiro")
	public Optional<Restaurante> buscarPrimeiro(){
		return restauranteRepository.buscarPrimeiro();
	}
	
}
