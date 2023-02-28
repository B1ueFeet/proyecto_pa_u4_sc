package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.service.ICiudadanoService;

@SpringBootApplication
public class ProyectoPaU4ScApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoPaU4ScApplication.class, args);
	}

	@Autowired
	private ICiudadanoService ciudadanoService;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		this.ciudadanoService.procesarEstudiantesParalelo();
	}

}
