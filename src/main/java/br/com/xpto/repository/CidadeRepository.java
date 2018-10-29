package br.com.xpto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.xpto.entity.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long>{
  
}
