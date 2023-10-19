package model.entity;

import exceptions.InfoInvalidaException;

public class Funcionario {
	private long id;
	
	private String nome;
	
	private String login;
	
	private String senha;
	

	private String tipo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws InfoInvalidaException {
		if (nome == null || nome.length() < 1) {
			throw new InfoInvalidaException("nome não pode ser vazio");
		}
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) throws InfoInvalidaException {
		if (login == null || login.length() < 1) {
			throw new InfoInvalidaException("nome de login inválido, tente outro");
		}
		this.login = login;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) throws InfoInvalidaException {
		if (senha == null || senha.length() < 1) {
			throw new InfoInvalidaException("Senha inválida");
		}
		this.senha = senha;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
			
			
}
