package model.entity;

import java.time.Year;

public class Automovel {
	private Long id;
	
	private String marca;

	private String cor;

	private String placa;

	private int ano;

	private int quilometragem;

	private Cliente proprietario;
	
	public Automovel(String marca, String cor, String placa, int ano, int quilometragem, Cliente proprietario) {
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
    public void setMarca(String marca) {
        if (marca == null || marca.length() < 1) {
            System.out.println("Marca nao pode ser vazio");
            return;
        }
        this.marca = marca;
    }

    public String getCor() { return this.cor; }
    public void setCor(String cor) {
        if (cor == null || cor.length() < 1) {
            System.out.println("Cor nao pode ser vazio");
            return;
        }
        this.cor = cor;
    }

    public String getPlaca() { return this.placa; }
    public void setPlaca(String placa) {
        if (placa == null || placa.length() < 1) {
            System.out.println("Placa nao pode ser vazio");
            return;
        }
        this.placa = placa;
    }

    public int getAno() { return this.ano; }
    public void setAno(int ano) {
        int anoAtual = Year.now().getValue();

        // 1886 foi o ano do primeiro carro ja feito
        if (ano < 1886 || ano > anoAtual + 1) {
            System.out.println("Ano invalido");
            return;
        }
        this.ano = ano;
    }

    public int getQuilometragem() { return this.quilometragem; }
    public void setQuilometragem(int quilometragem) {
        if (quilometragem < 0) {
            System.out.println("Quilometragem invalida");
            return;
        }
        this.quilometragem = quilometragem;
    }

    public Cliente getProprietario() { return this.proprietario; }
    public void setProprietario(Cliente proprietario) {
        this.proprietario = proprietario;
    }

}
