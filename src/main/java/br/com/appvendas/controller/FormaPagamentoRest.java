package br.com.appvendas.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.appvendas.mobile.holder.FormaPagamentoHolder;
import br.com.appvendas.model.FormaPagamento;
import br.com.appvendas.model.ParametroSistema;
import br.com.appvendas.parameters.Parametros;
import br.com.appvendas.service.FormaPagamentoService;
import br.com.appvendas.service.ParametroSistemaService;

@RestController
@RequestMapping("/formasPag")
public class FormaPagamentoRest {

	@Autowired
	private FormaPagamentoService formaPagamentoService;

	@Autowired
	private ParametroSistemaService parametroService;

	@GetMapping("/statusSincronizacao/{dataAlteracao}")
	public ResponseEntity<String> checarSincronizacaoFormasPagamento(@PathVariable("dataAlteracao") Long dataAlteracao) {

		ResponseEntity<String> response = new ResponseEntity<String>("N", HttpStatus.OK);
		ParametroSistema paramDataAlteracao = parametroService.buscar(Parametros.Param_Sinc_Forma_Pagamento.getCodigo());

		if (paramDataAlteracao != null) {

			String milliUltimaAlteracaoSistema = Optional.ofNullable(paramDataAlteracao.getValor()).orElse("0");

			// verifica se a data de alteração do mobile é maior que a data de alteração do sistema
			if (Long.parseLong(milliUltimaAlteracaoSistema) > dataAlteracao) {
				response = new ResponseEntity<String>("S", HttpStatus.OK);
			}

		} else {
			response = new ResponseEntity<String>("Parâmetro data última alteração não encontrado", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	@GetMapping("/buscar/{dataAlteracao}")
	public ResponseEntity<FormaPagamentoHolder> sincronizar(@PathVariable("dataAlteracao") Long dataAlteracao) {

		List<FormaPagamento> formasPagamentoAlteradas = formaPagamentoService.getFormasPagamentoAlteradas(new Date(dataAlteracao));
		Long paramDataAlteracao = Long
				.parseLong(Optional.ofNullable(parametroService.buscar(Parametros.Param_Sinc_Forma_Pagamento.getCodigo()).getValor()).orElse("0"));

		return new ResponseEntity<>(new FormaPagamentoHolder(paramDataAlteracao, formasPagamentoAlteradas), HttpStatus.OK);
	}
}
