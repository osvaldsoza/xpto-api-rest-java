package br.com.xpto.service;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import br.com.xpto.entity.Cidade;
import br.com.xpto.repository.CidadeRepository;

@Service
public class CidadeCSV {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	public void lerCSVESalvarNaBase() {
		try {
			Reader reader;
			reader = Files.newBufferedReader(Paths.get("/Users/osvaldsoza/Downloads/Teste Java - Cidades.csv"));

			CsvToBean<Cidade> csvToBean = new CsvToBeanBuilder(reader).withType(Cidade.class).build();

			List<Cidade> cidades = csvToBean.parse();
			int count = 0;
			for (Cidade cidade : cidades) {
			System.out.println(cidade.toString());
			//new CidadeQueryDSLImp().inderirCidade(cidade);
			//cidadeRepository.save(cidade);
				//	System.out.println(csvToBean);
				count++;
			}
			System.out.println("Total de registros no Cidades.csv: " + count);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
