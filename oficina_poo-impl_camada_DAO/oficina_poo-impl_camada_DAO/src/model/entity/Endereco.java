package model.entity;

public class Endereco {

	private Long id;

	private String rua;

	private String numero;

	private String bairro;

	public Endereco(String rua, String numero, String bairro) {
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

	public void setRua(String rua) {
		if (rua == null || rua.length() < 1) {
			System.out.println("Valor de rua nao pode ser vazio");
			return;
		}
		this.rua = rua;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		if (numero == null || numero.length() < 1) {
			System.out.println("Valor do numero nao pode ser vazio");
			return;
		}
		this.numero = numero;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		if (bairro == null || bairro.length() < 1) {
			System.out.println("Valor de bairro nao pode ser vazio");
			return;
		}
		this.bairro = bairro;
	}
}
