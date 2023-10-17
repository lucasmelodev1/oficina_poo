package model.entity;

import java.util.List;

public class Orcamento
{
	private Long id;
	private Cliente cliente;
	private Automovel automovel;
	private List<Peca> pecas;
    private List<Servico> servicos;
    private double valorTotal;
    
    //Construtor do Orçamento
    public Orcamento(List<Peca> pecas, List<Servico> servicos, double valorTotal){
    	setPecas(pecas);
    	setServicos(servicos);
    	setValorTotal(valorTotal);  	
    }
    
    public Orcamento() {
    	
    }
    
    //metodo para calcular o orçamento
    public double getOrcamento() { return valorTotal; }
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
    public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Automovel getAutomovel() {
		return automovel;
	}

	public void setAutomovel(Automovel automovel) {
		this.automovel = automovel;
	}
    //metodo get peça
	public List<Peca> getPeca() 
	{
		return this.pecas;
	}
	
	//metodo set peça
	public void setPecas(List<Peca> pecas)
	{	//verificando se o valor não é nulo
		if (pecas == null || pecas.size() < 1)
		{
			System.out.println("Valor da peça Inválido!");
			return;
		}
		this.pecas = pecas;
	}
		
	//metodo get de serviços
	public List<Servico> ListgetServicos() { return servicos; }
	
	//metodo set de serviços
	public void setServicos(List<Servico> servicos) 
	{	//verificando se o valor não é nulo!
		if(servicos == null) 
		{
			System.out.println("Valor do Serviço inválido!");
			return;
		}
		this.servicos = servicos;
	}
	
	//metodo get do valor total
	public double getValorTotal() {
		return valorTotal;
	}
	//metodo set do valor total
	public void setValorTotal(double valorTotal) 
	{
		if(valorTotal < 0) 
		{
			System.out.println("Valor do orçamento zerado ou negativo!");
			return;
		}
		this.valorTotal = valorTotal;
	}
	
	//método relatorio - ainda vamos desenvolver
	public void gerarRelatorio() {
		System.out.println("Valor Total do orçamento é: " +  valorTotal);
	}	
}

