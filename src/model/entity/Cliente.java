package model.entity;

import exceptions.InfoInvalidaException;

public class Cliente {
	private Long id;

	private String nome;

	private Endereco endereco;

	private String cpf;
	
	 public Cliente(String nome, Endereco endereco, String cpf) throws InfoInvalidaException {
	        setNome(nome);
	        setEndereco(endereco);
	        setCPF(cpf);
	    }
	 
	 public Cliente() {
		 
	 }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) throws InfoInvalidaException {
		if (nome == null || nome.length() < 1) {
			throw new InfoInvalidaException("Nome nao pode ser vazio");
			
		}
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return this.endereco;
	}

	public void setEndereco(Endereco endereco) {
		// Endereco ja possui validacao
		this.endereco = endereco;
	}

	public String getCPF() {
		return this.cpf;
	}

	public void setCPF(String cpf) throws InfoInvalidaException {
		if (cpf == null || cpf.length() != 11) {
			throw new InfoInvalidaException("CPF invalido");
		}
		this.cpf = cpf;
	}
}
