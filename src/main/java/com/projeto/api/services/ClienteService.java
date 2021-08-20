package com.projeto.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.api.domain.Cliente;
import com.projeto.api.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente inserirCliente(final Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}

	public List<Cliente> obterTodosClientes() {
		return this.clienteRepository.findAll();
	}

	public Cliente obterClientePorId(final Integer idCliente) {
		final Optional<Cliente> cliente = this.clienteRepository.findById(idCliente);
		return cliente.orElse(null);
	}

}
