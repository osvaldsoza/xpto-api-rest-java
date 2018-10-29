package br.com.xpto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.xpto.entity.Cidade;
import br.com.xpto.repository.CidadeRepository;

@Service
public class SalvandoCSVNaBaseXPTO {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	public void salvarNaBase(Cidade cidade) {
		cidadeRepository.save(cidade);
	}
}
