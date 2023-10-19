package model.entity;

import exceptions.InfoInvalidaException;

public class Peca {
	private Long id;
    private String nome;
    private double preco;

	private String fabricante;

    public Peca(String nome, double preco,String fabricante) throws InfoInvalidaException
    {
        setNome(nome);
        setPreco(preco);
        setFabricante(fabricante);
    }
    
    public Peca() {
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

    public String getNome()
    {
        return this.nome;
    }

    public void setPreco(double preco) throws InfoInvalidaException
    {
        if(preco <= 0)
        {
            throw new InfoInvalidaException("preço precisa ser maior que 0");
        }
        else
        {
            this.preco = preco;
        }
    }

    public double getPreco()
    {
        return this.preco;
    }

    public void setFabricante(String fabricante) throws InfoInvalidaException
    {
        if (fabricante == null || fabricante.length() < 1) {
            throw new InfoInvalidaException("CPF invalido");
        }
        this.fabricante = fabricante;
    }

    public String getFabricante()
    {
        return this.fabricante;
    }
}

