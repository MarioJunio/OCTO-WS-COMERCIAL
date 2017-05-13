package br.com.appvendas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.appvendas.model.ParametroSistema;
import br.com.appvendas.repository.ParametroSistemaRepository;

@Service
public class ParametroSistemaService {

	@Autowired
	private ParametroSistemaRepository parametroSistemaRepository;

	public ParametroSistema buscar(Long parametroId) {
		return parametroSistemaRepository.buscarParametro(parametroId);
	}

	public void atualizar(Long parametroId, String valor) {
		parametroSistemaRepository.atualizarParametro(parametroId, valor);
	}

}
