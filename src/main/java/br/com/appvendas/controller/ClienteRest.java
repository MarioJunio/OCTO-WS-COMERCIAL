package br.com.appvendas.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.appvendas.mobile.holder.ClienteSincHolder;
import br.com.appvendas.model.Cliente;
import br.com.appvendas.model.ParametroSistema;
import br.com.appvendas.parameters.Parametros;
import br.com.appvendas.service.ClienteService;
import br.com.appvendas.service.ParametroSistemaService;

@RestController
@RequestMapping("/clientes")
public class ClienteRest {

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ParametroSistemaService parametroService;

	@GetMapping(value = "/statusSincClientes/{vendedorId}/{dataAlteracao}", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> checarSincronizacao(@PathVariable("vendedorId") Long vendedorId, @PathVariable("dataAlteracao") Long dataAlteracao) {

		ResponseEntity<String> response = new ResponseEntity<String>(HttpStatus.OK);
		ParametroSistema paramSincCliente = parametroService.buscar(Parametros.Param_Sinc_Cliente.getCodigo());
		
		if (paramSincCliente != null) {

			Date dataUltimaAlteracaoMobile = new Date(dataAlteracao);
			Date dataUltimaAlteracao = new Date(Long.parseLong(paramSincCliente.getValor()));
			
			response = new ResponseEntity<String>(dataUltimaAlteracaoMobile.compareTo(dataUltimaAlteracao) < 0 ? "S" : "N", HttpStatus.OK);
		} else {
			response = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR); 
		}

		return response;
	}

	@GetMapping(value = "/buscar/{vendedorId}/{dataAlteracao}")
	public ResponseEntity<ClienteSincHolder> buscar(@PathVariable("vendedorId") Long vendedorId, @PathVariable("dataAlteracao") Long dataAlteracao) {

		ResponseEntity<ClienteSincHolder> response = new ResponseEntity<ClienteSincHolder>(HttpStatus.OK);

		List<Cliente> clientes = this.clienteService.getClientesAlterados(vendedorId, new Date(dataAlteracao));
		
		if (!clientes.isEmpty()) {

			ParametroSistema paramSincCliente = parametroService.buscar(Parametros.Param_Sinc_Cliente.getCodigo());

			if (paramSincCliente == null) {
				response = new ResponseEntity<ClienteSincHolder>(HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				ClienteSincHolder holder = new ClienteSincHolder(Long.parseLong(paramSincCliente.getValor()), clientes);
				response = new ResponseEntity<ClienteSincHolder>(holder, HttpStatus.OK);
			}
		}

		return response;

	}
}
