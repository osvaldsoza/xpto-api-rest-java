package br.com.xpto.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.xpto.dto.CidadeDTO;
import br.com.xpto.entity.Cidade;
import br.com.xpto.service.CidadeService;
import br.com.xpto.util.HandleValidationException;

@RestController
@RequestMapping("/api")
public class CidadeController extends HandleValidationException {

	@Autowired
	private CidadeService cidadeService;

	/*
	 * Retorna todos as informações da base de dados
	 */
	@GetMapping("/cidades")
	public ResponseEntity<List<CidadeDTO>> listarAll() {
		List<CidadeDTO> listCidadeDTO = cidadeService.listarTodasCidades();
		return new ResponseEntity<List<CidadeDTO>>(listCidadeDTO, HttpStatus.OK);
	}

	/*
	 * Retorna o nome das cidades baseado em um estado selecionado
	 */
	@GetMapping("/cidade/buscar")
	public ResponseEntity<List<Cidade>> listaNomeCidades(@PathParam(value = "uf") String uf) {
		List<Cidade> list = cidadeService.retornaNameCidades(uf);
		return new ResponseEntity<List<Cidade>>(list, HttpStatus.OK);
	}

	/*
	 * Retorna somente as cidades que são capitais ordenadas por nome
	 */
	@GetMapping("/capitais")
	public ResponseEntity<List<Cidade>> buscarCidadesCapitaisOrdenadasPorNome() {
		List<Cidade> listCidadeDTO = cidadeService.buscarCidadesCapitaisOrdenadasPorNome();
		return new ResponseEntity<List<Cidade>>(listCidadeDTO, HttpStatus.OK);
	}

	/*
	 * Obtem os dados da cidade pelo o id do IBGE
	 */
	@GetMapping("/cidade/{id}")
	public ResponseEntity<CidadeDTO> obterDadosCidadePeloId(@PathVariable Long id) {
		CidadeDTO cidadeDTO = cidadeService.obterDadosCidadePeloId(id);
		return new ResponseEntity<CidadeDTO>(cidadeDTO, HttpStatus.OK);
	}

	/*
	 * Retornar a quantidade de cidades por estado;
	 */
	@GetMapping("/quantidadeCidadesPorEstado")
	public ResponseEntity<List<Cidade>> retornaQtdeCidadesPorEstado() {
		List<Cidade> qtdeCidadesPorEstado = cidadeService.retornaQtdeCidadesPorEstado();
		return new ResponseEntity<List<Cidade>>(qtdeCidadesPorEstado, HttpStatus.OK);
	}

	/*
	 * Retorna a quantidade de registros total;
	 */
	@GetMapping("/totalRegistro")
	public ResponseEntity<Long> retornaQtdeTotalRegistro() {
		return new ResponseEntity<Long>(cidadeService.retornaQtdeTotalRegistro(), HttpStatus.OK);
	}

	/*
	 * Retorna a quantidade de registro baseado em uma coluna. Não deve contar itens
	 * iguais;
	 */
	@GetMapping("/totalRegistroDistintos")
	public ResponseEntity<Long> retornaQtdeTotalRegistroDistintos() {
		return new ResponseEntity<Long>(cidadeService.retornaQtdeTotalRegistroDistintos(), HttpStatus.OK);
	}

	@PostMapping("/cidades")
	public ResponseEntity<CidadeDTO> salvarCidade(@RequestBody CidadeDTO cidadeDTO) {
		CidadeDTO cidadeDTOSalva = cidadeService.salvarCidade(cidadeDTO);
		return new ResponseEntity<CidadeDTO>(cidadeDTOSalva, HttpStatus.OK);
	}

	@DeleteMapping("/cidade/{id}")
	public ResponseEntity<Void> deletarCidade(@PathVariable Long id) {
		cidadeService.deletarCidade(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
