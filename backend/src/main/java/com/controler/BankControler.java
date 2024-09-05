package com.controler;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/bank")
class bankControler{

	@GetMapping()
	public String teste(){
		return "Testando";
	}
}