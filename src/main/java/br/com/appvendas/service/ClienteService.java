package br.com.appvendas.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.appvendas.model.Cliente;
import br.com.appvendas.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public List<Cliente> getClientesAlterados(Long vendedorId, Date dataAlteracao) {
		return clienteRepository.buscarPorDataAltracao(vendedorId, dataAlteracao);
	}

}
