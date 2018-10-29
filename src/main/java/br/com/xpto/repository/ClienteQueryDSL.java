package br.com.xpto.repository;

import java.util.List;

import br.com.xpto.entity.Cidade;

public interface ClienteQueryDSL {

	public List<Cidade> buscarCidadesCapitais();
	public List<Cidade> buscarCidadesCapitaisOrdenadasPorNome();
	public List<Cidade> retornaQtdeCidadesPorEstado();
	public Long retornaQtdeTotalRegistro();
	public Long retornaQtdeTotalRegistroDistintos();	
	public List<Cidade> retornaNameCidades(String uf);
	public void inderirCidade(Cidade cidade);
}
