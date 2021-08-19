package com.projeto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.domain.Cliente;
import com.projeto.repositories.ClienteRepository;

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
		return this.clienteRepository.findById(idCliente).orElseThrow();
	}

}
