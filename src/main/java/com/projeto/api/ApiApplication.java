package com.projeto.api;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projeto.api.domain.Cliente;
import com.projeto.api.repositories.ClienteRepository;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner {

	@Autowired
	private ClienteRepository clienteRepository;

	public static void main(final String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Override
	public void run(final String... args) throws Exception {
		final Cliente cliente1 = new Cliente(null, "Wallace", LocalDate.of(1990, 1, 1), "21999999999");

		final Cliente cliente2 = new Cliente(null, "Joana", LocalDate.of(1999, 12, 12), "21999998888");

		this.clienteRepository.saveAll(Arrays.asList(cliente1, cliente2));
	}

}
