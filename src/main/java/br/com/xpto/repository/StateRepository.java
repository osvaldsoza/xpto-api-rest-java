package br.com.xpto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.xpto.entity.State;

public interface StateRepository extends JpaRepository<State, Long>{
  
}
