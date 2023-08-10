public class Peca {
    private String nome;
    private double preco;
    private String fabricante;

    public Peca(String nome, double preco,String fabricante)
    {
        setNome(nome);
        setPreco(preco);
        setFabricante(fabricante);
    }

    public void setNome(String nome)
    {
        if (nome == null || nome.length() < 1) {
            System.out.println("nome nao pode ser nulo");
            return;
        }
        this.nome = nome;
    }

    public String getNome()
    {
        return this.nome;
    }

    public void setPreco(double preco)
    {
        if(preco <= 0)
        {
            System.out.println("preço precisa ser maior que 0");
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

    public void setFabricante(String fabricante)
    {
        if (fabricante == null || fabricante.length() < 1) {
            System.out.println("CPF invalido");
            return;
        }
        this.fabricante = fabricante;
    }

    public String getFabricante()
    {
        return this.fabricante;
    }
}
