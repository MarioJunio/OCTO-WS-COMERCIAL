package br.com.appvendas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.appvendas.model.VendedorMobile;
import br.com.appvendas.repository.VendedorMobileRepository;

@Service
public class VendedorMobileService {

	@Autowired
	private VendedorMobileRepository vendedorMobileRepository;

	public VendedorMobile entrar(String usuario, String senha) {

		VendedorMobile vm = vendedorMobileRepository.entrar(usuario, senha);

		if (vm != null)
			vm.setSenha(null);

		return vm;
	}

	public VendedorMobile buscar(String username) {
		return vendedorMobileRepository.findByUsuario(username);
	}
}
