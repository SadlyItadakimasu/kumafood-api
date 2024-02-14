package com.guilhermekumagai.kumafood.domain.exception;

public class EntidadeNaoEncontradaException extends RuntimeException {
	
	static final long serialVersionUID = 1L;

	public EntidadeNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
}
