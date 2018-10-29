package br.com.xpto.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.xpto.dto.CidadeDTO;
import br.com.xpto.entity.Cidade;
import br.com.xpto.repository.CidadeQueryDSLImp;
import br.com.xpto.repository.CidadeRepository;

@Service
public class CidadeService extends CidadeQueryDSLImp {

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private ModelMapper modelMapper;

	public List<CidadeDTO> listarTodasCidades() {
		return cidadeRepository.findAll().stream().map(entity -> modelMapper.map(entity, CidadeDTO.class))
				.collect(Collectors.toList());
	}

	public CidadeDTO salvarCidade(CidadeDTO cidadeDTO) {
		Cidade cidade = modelMapper.map(cidadeDTO, Cidade.class);
		Cidade cidadeSalva = cidadeRepository.save(cidade);
		return modelMapper.map(cidadeSalva, CidadeDTO.class);
	}

	public CidadeDTO obterDadosCidadePeloId(Long id_ibge) {
		Optional<Cidade> optionalCidade = cidadeRepository.findById(id_ibge);
		if (optionalCidade.isPresent()) {
			return modelMapper.map(optionalCidade.get(), CidadeDTO.class);
		}
		throw new EntityNotFoundException("Cidade " + id_ibge + " não encontrada.");
	}

	public void deletarCidade(Long id) {
		Optional<Cidade> optionalCidade = cidadeRepository.findById(id);
		if (!optionalCidade.isPresent()) {
			throw new EntityNotFoundException("Cidade " + id + " não encontrada.");
		}
		cidadeRepository.deleteById(id);
	}	
}
