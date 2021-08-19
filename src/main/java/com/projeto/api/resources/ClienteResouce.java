package com.projeto.api.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projeto.domain.Cliente;
import com.projeto.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResouce {

	@Autowired
	private ClienteService clienteService;

	@RequestMapping(method = RequestMethod.POST)
	private ResponseEntity<Void> inserirCliente(@RequestBody Cliente cliente) {
		cliente = this.clienteService.inserirCliente(cliente);

		final URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Cliente>> obterTodosClientes() {
		final List<Cliente> clientes = this.clienteService.obterTodosClientes();

		return ResponseEntity.ok().body(clientes);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cliente> obterClientePorId(@PathVariable final Integer idCliente) {
		final Cliente cliente = this.clienteService.obterClientePorId(idCliente);

		return ResponseEntity.ok().body(cliente);
	}

}
