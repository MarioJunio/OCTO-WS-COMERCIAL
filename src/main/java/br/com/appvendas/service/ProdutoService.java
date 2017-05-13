package br.com.appvendas.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.appvendas.mobile.holder.ProdutoMobile;
import br.com.appvendas.model.ParametroSistema;
import br.com.appvendas.model.Produto;
import br.com.appvendas.parameters.Parametros;
import br.com.appvendas.repository.ParametroSistemaRepository;
import br.com.appvendas.repository.ProdutoRepository;
import br.com.appvendas.util.format.Dates;

@Service
public class ProdutoService {

	@Autowired
	private ParametroSistemaRepository paramSistemaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	public List<Produto> todos() {
		return (List<Produto>) this.produtoRepository.findAll();
	}

	/**
	 * Verifica a data da ultima atualizacão dos produtos cadastrados
	 * 
	 * @param dataUltimaSincronizacao
	 * @return True se a data da ultima atualização no sistema é diferente do
	 *         mobile, False caso contrário
	 * @throws Exception
	 */
	public boolean checaSincronizacaoProdutos(Date dataUltimaSincronizacao) throws Exception {

		ParametroSistema param = paramSistemaRepository.buscarParametro(Parametros.Param_Sinc_Produto.getCodigo());

		// SE O PARAMETRO EXISTE, VERIFIQUE SE HA ALGUMA MODIFICACAO POSTERIOR A
		// DATA DA ULTIMA SINCRONIZACAO
		if (param != null) {

			if (param.getValor() != null)
				return Dates.milliToDate(Long.parseLong(param.getValor())).compareTo(dataUltimaSincronizacao) != 0;
			else
				return false;

		} else
			throw new Exception("Parametro: " + Parametros.Param_Sinc_Produto + " não encontrado.");
	}

	public List<ProdutoMobile> getProdutosDesincronizados(Map<Long, ProdutoMobile> hashProdutos) {

		List<ProdutoMobile> produtosDesincronizados = new ArrayList<>();

		// verifica quais produtos não estão sincronizados
		this.produtoRepository.findAll().forEach((p) -> {

			ProdutoMobile produtoMobile = hashProdutos.get(p.getId());

			if (produtoMobile != null) {

				// se as datas de última alteração forem diferentes, é
				// necessario adicionar o produto mais recente na lista
				if (produtoMobile
						.getDataAlteracao() != (p.getDataUltimaAlteracao() != null ? p.getDataUltimaAlteracao().getTimeInMillis() : null)) {
					produtosDesincronizados.add(ProdutoMobile.buildWithWrap(p));
				}

			} else {
				produtosDesincronizados.add(ProdutoMobile.buildWithWrap(p));
			}

		});

		return produtosDesincronizados;
	}

	public Map<Long, ProdutoMobile> getMapProdutos(List<ProdutoMobile> produtos) {

		Map<Long, ProdutoMobile> mapProdutos = new HashMap<>();

		produtos.forEach((p -> {
			mapProdutos.put(p.getId(), p);
		}));

		return mapProdutos;
	}
}
