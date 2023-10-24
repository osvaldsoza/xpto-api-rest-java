package br.com.xpto.dto;

import java.io.Serializable;

public class StateDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long uf;
	private String sigla;
	private String name;

	public Long getUf() {
		return uf;
	}

	public void setUf(Long uf) {
		this.uf = uf;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
