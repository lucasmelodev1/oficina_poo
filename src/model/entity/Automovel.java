package model.entity;

import java.time.Year;

import exceptions.InfoInvalidaException;

public class Automovel {
	private Long id;
	
	private String marca;

	private String cor;

	private String placa;

	private int ano;

	private int quilometragem;

	private Cliente proprietario;
	
	public Automovel(String marca, String cor, String placa, int ano, int quilometragem, Cliente proprietario) throws InfoInvalidaException {
        setMarca(marca);
        setCor(cor);
        setPlaca(placa);
        setAno(ano);
        setQuilometragem(quilometragem);        
        setProprietario(proprietario);
    }
	public Automovel() {
		
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMarca() { return this.marca; }
    public void setMarca(String marca) throws InfoInvalidaException {
        if (marca == null || marca.length() < 1) {
        	 throw new InfoInvalidaException("Marca nao pode ser vazio");
           
        }
        this.marca = marca;
    }

    public String getCor() { return this.cor; }
    public void setCor(String cor) throws InfoInvalidaException {
        if (cor == null || cor.length() < 1) {
        	 throw new InfoInvalidaException("Cor nao pode ser vazio");
        }
        this.cor = cor;
    }

    public String getPlaca() { return this.placa; }
    public void setPlaca(String placa) throws InfoInvalidaException {
        if (placa == null || placa.length() < 1) {
            throw new InfoInvalidaException("Placa nao pode ser vazio");
            
        }
        this.placa = placa;
    }

    public int getAno() { return this.ano; }
    public void setAno(int ano) throws InfoInvalidaException  {
        int anoAtual = Year.now().getValue();

        // 1886 foi o ano do primeiro carro ja feito
        if (ano < 1886 || ano > anoAtual + 1) {
        	 throw new InfoInvalidaException("Ano invalido");
        }
        this.ano = ano;
    }

    public int getQuilometragem() { return this.quilometragem; }
    public void setQuilometragem(int quilometragem) throws InfoInvalidaException {
        if (quilometragem < 0) {
        	 throw new InfoInvalidaException("Quilometragem invalida");
        }
        this.quilometragem = quilometragem;
    }

    public Cliente getProprietario() { return this.proprietario; }
    public void setProprietario(Cliente proprietario) {
        this.proprietario = proprietario;
    }

}
