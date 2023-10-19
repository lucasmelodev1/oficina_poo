package model.entity;

import exceptions.InfoInvalidaException;

public class Endereco {

	private Long id;

	private String rua;

	private String numero;

	private String bairro;

	public Endereco(String rua, String numero, String bairro) throws InfoInvalidaException{
        setRua(rua);
        setNumero(numero);
        setBairro(bairro);
    }
	
	public Endereco() {
		
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRua() {
		return this.rua;
	}

	public void setRua(String rua) throws InfoInvalidaException {
		if (rua == null || rua.length() < 1) {
			throw new InfoInvalidaException("Valor de rua nao pode ser vazio");
		}
		this.rua = rua;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) throws InfoInvalidaException {
		if (numero == null || numero.length() < 1) {
			throw new InfoInvalidaException("Valor do numero nao pode ser vazio");
			
		}
		this.numero = numero;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) throws InfoInvalidaException {
		if (bairro == null || bairro.length() < 1) {
			throw new InfoInvalidaException("Valor de bairro nao pode ser vazio");
		}
		this.bairro = bairro;
	}
}
