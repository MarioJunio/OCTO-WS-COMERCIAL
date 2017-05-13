package br.com.appvendas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.appvendas.model.VendedorMobile;

@RestController
@RequestMapping("/mobile")
public class VendedorMobileRest {

	@PostMapping("/entrar")
	public ResponseEntity<VendedorMobile> entrar(@RequestParam("usuario") String usuario, @RequestParam("senha") String senha) {
		
		System.out.println(usuario + " - " + senha);
		
		return ResponseEntity.ok(new VendedorMobile());
	}

}
