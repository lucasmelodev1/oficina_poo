 public class Servico {
    private String nome;
    private double valor;
    private boolean statusServico;

    public Servico(String nome,double valor)
    {
        setNome(nome);
        setValor(valor);
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

    public void finalizarServico()
    {
        if(statusServico == true)
        {
            System.out.println("o serviço já foi finalizado");
        }
        else
        {
            this.statusServico = true;
            System.out.println("serviço finalizado com sucesso");
        }
    }
}
