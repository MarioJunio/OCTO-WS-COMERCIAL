package br.com.appvendas.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.appvendas.model.FormaPagamento;
import br.com.appvendas.repository.FormaPagamentoRepository;

@Service
public class FormaPagamentoService {

	@Autowired
	private FormaPagamentoRepository formaPagamentoRepository;
	
	public List<FormaPagamento> getFormasPagamentoAlteradas(Date dataAlteracao) {
		return formaPagamentoRepository.buscarPorDataAlteracao(dataAlteracao);
	}
}
