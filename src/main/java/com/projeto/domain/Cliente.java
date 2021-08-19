package com.projeto.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nomeCompleto;

	private LocalDate dataNascimento;

	private String telefone;

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cliente(final Integer id, final String nomeCompleto, final LocalDate dataNascimento, final String telefone) {
		super();
		this.id = id;
		this.nomeCompleto = nomeCompleto;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return this.nomeCompleto;
	}

	public void setNomeCompleto(final String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public LocalDate getDataNascimento() {
		return this.dataNascimento;
	}

	public void setDataNascimento(final LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(final String telefone) {
		this.telefone = telefone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		final Cliente other = (Cliente) obj;
		if (this.id == null) {
			if (other.id != null)
				return false;
		} else if (!this.id.equals(other.id))
			return false;
		return true;
	}
}
