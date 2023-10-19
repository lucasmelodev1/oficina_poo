package model.entity;

import exceptions.InfoInvalidaException;

public class Servico {
	private Long id;
	private String nome;
    private double valor;

    public Servico(String nome,double valor) throws InfoInvalidaException
    {
        setNome(nome);
        setValor(valor);
    }
    
    public Servico() {
    	
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
    public void setNome(String nome) throws InfoInvalidaException
    {
        if (nome == null || nome.length() < 1) {
            throw new InfoInvalidaException("nome nao pode ser nulo");
  
        }
        this.nome = nome;
    }

    public String getNome() { return this.nome; }

    public void setValor(double valor) throws InfoInvalidaException
    {
        if(valor <= 0)
        {
            throw new InfoInvalidaException("valor precisa ser maior que 0");
        }
        this.valor = valor;
    }

    public double getValor() { return this.valor; }

}
