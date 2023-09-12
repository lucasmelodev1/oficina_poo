package model.entity;

public class Servico {
	private Long id;
	private String nome;
    private double valor;

    public Servico(String nome,double valor)
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
    public void setNome(String nome)
    {
        if (nome == null || nome.length() < 1) {
            System.out.println("nome nao pode ser nulo");
            return;
        }
        this.nome = nome;
    }

    public String getNome() { return this.nome; }

    public void setValor(double valor)
    {
        if(valor <= 0)
        {
            System.out.println("valor precisa ser maior que 0");
            return;
        }
        this.valor = valor;
    }

    public double getValor() { return this.valor; }

}
