package br.com.xpto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.xpto.service.CidadeCSV;

@SpringBootApplication
public class ProjetoXptoSystemsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoXptoSystemsApplication.class, args);
		new CidadeCSV().lerCSVESalvarNaBase();
	}
}
