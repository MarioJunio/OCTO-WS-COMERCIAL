package br.com.appvendas.controller;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.appvendas.mobile.holder.ProdutoMobile;
import br.com.appvendas.mobile.holder.ProdutoSincHolder;
import br.com.appvendas.model.Produto;
import br.com.appvendas.parameters.Parametros;
import br.com.appvendas.service.ParametroSistemaService;
import br.com.appvendas.service.ProdutoService;
import br.com.appvendas.util.format.Dates;

@RestController
@RequestMapping("/produtos")
public class ProdutoRest {

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private ParametroSistemaService parametroService;

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public Collection<Produto> todos() {
		return produtoService.todos();
	}

	@GetMapping(value = "/chsincprod/{dataUltimaSincronizacao}", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> checarSincronizacaoProdutos(@PathVariable("dataUltimaSincronizacao") Long dataUltimaSincronizacao) {

		ResponseEntity<String> response;

		try {
			boolean temSincronizacao = produtoService.checaSincronizacaoProdutos(Dates.milliToDate(dataUltimaSincronizacao));
			response = new ResponseEntity<String>(temSincronizacao ? "S" : "N", HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	@PostMapping(value = "/sincprod")
	public ResponseEntity<ProdutoSincHolder> sincronizarProdutos(@RequestBody List<ProdutoMobile> produtos) {

		// objeto que sera retornado ao mobile como JSON
		ProdutoSincHolder sincronizacaoHolder = new ProdutoSincHolder();

		List<ProdutoMobile> produtosDesincronizados = produtoService.getProdutosDesincronizados(this.produtoService.getMapProdutos(produtos));

		// data da sincronizacao dos produtos
		Date dataSincronizacao = new Date();

		// atualiza parametro 'data sincronizacao dos produtos'
		parametroService.atualizar(Parametros.Param_Sinc_Produto.getCodigo(), String.valueOf(dataSincronizacao.getTime()));

		// inicializa holder a ser retornado para o mobile
		sincronizacaoHolder.setDataSincronizacao(dataSincronizacao.getTime());
		sincronizacaoHolder.setProdutos(produtosDesincronizados);

		// System.out.println("========================== Produtos Desincronizados ==========================");
		// for (ProdutoMobile pm : produtosDesincronizados)
		// System.out.println(pm.getId());
		// System.out.println("Total: " + produtosDesincronizados.size());

		return new ResponseEntity<ProdutoSincHolder>(sincronizacaoHolder, HttpStatus.OK);
	}

}
