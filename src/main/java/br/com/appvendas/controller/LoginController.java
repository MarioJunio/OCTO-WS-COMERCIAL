package br.com.appvendas.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.appvendas.model.Vendedor;
import br.com.appvendas.service.VendedorMobileService;

@RestController
public class LoginController {

	@Autowired
	private VendedorMobileService vendedorMobileService;

	@GetMapping("/login")
	public ResponseEntity<Vendedor> login(Principal user) {

		ResponseEntity<Vendedor> response;

		if (user != null) {
			response = new ResponseEntity<Vendedor>(vendedorMobileService.buscar(user.getName()).getVendedor(), HttpStatus.OK);
		} else
			response = new ResponseEntity<Vendedor>(HttpStatus.UNAUTHORIZED);

		return response;
	}

}
