package com.projeto.api.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.modules.junit4.PowerMockRunner;

import com.projeto.api.domain.Cliente;
import com.projeto.api.repositories.ClienteRepository;

@RunWith(PowerMockRunner.class)
public class ClienteServiceTest {

	@InjectMocks
	private ClienteService clienteService;

	@Mock
	private ClienteRepository clienteRepository;

	@Captor
	private ArgumentCaptor<Cliente> clienteCaptor;

	@Test
	public void obterTodosClientesTest() {
		Mockito.when(this.clienteRepository.findAll()).thenReturn(this.obterResponseResultClientesForTest());

		final List<Cliente> clientes = this.clienteService.obterTodosClientes();
		assertNotNull(clientes);
		assertFalse(clientes.isEmpty());
		assertEquals("Joao", clientes.get(0).getNomeCompleto());
		assertEquals("Maria", clientes.get(1).getNomeCompleto());
		assertEquals(LocalDate.of(1992, 10, 11), clientes.get(0).getDataNascimento());
		assertEquals(LocalDate.of(1995, 7, 28), clientes.get(1).getDataNascimento());
		assertEquals("21996669999", clientes.get(0).getTelefone());
		assertEquals("21997778888", clientes.get(1).getTelefone());

	}

	@Test
	public void obterClientePorIdTest() {
		Mockito.when(this.clienteRepository.findById(10)).thenReturn(this.obterResponseResultClienteForTest());

		final Cliente clientes = this.clienteService.obterClientePorId(10);
		assertNotNull(clientes);
		assertEquals("Wallace", clientes.getNomeCompleto());
		assertEquals(LocalDate.of(1998, 8, 16), clientes.getDataNascimento());
		assertEquals("21984475692", clientes.getTelefone());

	}

	@Test
	public void salvarClienteTest() {
		Mockito.when(this.clienteRepository.save(this.clienteCaptor.capture())).thenReturn(new Cliente());
		this.clienteService.inserirCliente(this.obterClienteForTest());

		assertNotNull(this.clienteCaptor.getValue());
		assertEquals("Jussara", this.clienteCaptor.getValue().getNomeCompleto());
		assertEquals(LocalDate.of(1976, 11, 29), this.clienteCaptor.getValue().getDataNascimento());
		assertEquals("21978476542", this.clienteCaptor.getValue().getTelefone());

	}

	private List<Cliente> obterResponseResultClientesForTest() {
		final List<Cliente> clientes = new ArrayList<>();

		final Cliente cliente1 = new Cliente(null, "Joao", LocalDate.of(1992, 10, 11), "21996669999");
		final Cliente cliente2 = new Cliente(null, "Maria", LocalDate.of(1995, 7, 28), "21997778888");

		clientes.add(cliente1);
		clientes.add(cliente2);

		return clientes;
	}

	private Optional<Cliente> obterResponseResultClienteForTest() {
		final Cliente cliente = new Cliente(10, "Wallace", LocalDate.of(1998, 8, 16), "21984475692");
		return Optional.of(cliente);
	}

	private Cliente obterClienteForTest() {
		final Cliente cliente = new Cliente(11, "Jussara", LocalDate.of(1976, 11, 29), "21978476542");
		return cliente;
	}
}
