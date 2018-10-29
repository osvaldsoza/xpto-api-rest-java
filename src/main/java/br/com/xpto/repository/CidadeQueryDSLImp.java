package br.com.xpto.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.querydsl.jpa.impl.JPAQuery;

import br.com.xpto.entity.Cidade;
import br.com.xpto.entity.QCidade;

public class CidadeQueryDSLImp implements ClienteQueryDSL {

	@PersistenceContext
	private EntityManager entityManager;

	private QCidade qCidade = QCidade.cidade;

	@Override
	public List<Cidade> buscarCidadesCapitais() {
		JPAQuery<Cidade> query = new JPAQuery<Cidade>(entityManager);
		return query.select(qCidade).from(qCidade).where(qCidade.capital.eq("true")).fetch();
	}

	@Override
	public List<Cidade> buscarCidadesCapitaisOrdenadasPorNome() {
		JPAQuery<Cidade> query = new JPAQuery<Cidade>(entityManager);
		return query.from(qCidade).where(qCidade.capital.eq("true")).orderBy(qCidade.name.asc()).fetch();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cidade> retornaQtdeCidadesPorEstado() {
		return entityManager.createQuery("select count(c.name) from Cidade c group by (c.uf)").getResultList();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Long retornaQtdeTotalRegistro() {
		JPAQuery query = new JPAQuery<>(entityManager);
		return query.from(qCidade).fetchCount();
	}

	@Override
	public Long retornaQtdeTotalRegistroDistintos() {
		return (Long) entityManager.createQuery("select count(distinct c.uf) from Cidade c ").getSingleResult();
	}

	@Override
	public List<Cidade> retornaNameCidades(String uf) {
		JPAQuery<Cidade> query = new JPAQuery<Cidade>(entityManager);
		return query.from(qCidade).where(qCidade.uf.eq(uf)).fetch();
	}

	@Override
	public void inderirCidade(Cidade cidade) {
		// TODO Auto-generated method stub
		 entityManager.createQuery("INSERT INTO Cidade(\n" + 
				"            id, alternative_names, capital, latitude, longitude, mesoregion, \n" + 
				"            microregion, name, no_accents, uf)\n" + 
				"    VALUES (?, ?, ?, ?, ?, ?, \n" + 
				"            ?, ?, ?, ?);");
	}
}
