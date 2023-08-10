public class Orcamento
{
	private Peca[] pecas;
    private Servico[] servicos;
    private double valorTotal;
    
    //Construtor do Orçamento
    public Orcamento(Peca[] pecas, Servico[] servicos, double valorTotal){
    	setPecas(pecas);
    	setServicos(servicos);
    	setValorTotal(valorTotal);  	
    }
    
    //metodo para calcular o orçamento
    public double getOrcamento() { return valorTotal; }
    
    //metodo get peça
	public Peca[] getPeca() 
	{
		return this.pecas;
	}
	
	//metodo set peça
	public void setPecas(Peca[] pecas)
	{	//verificando se o valor não é nulo
		if (pecas == null || pecas.length < 1)
		{
			System.out.println("Valor da peça Inválido!");
			return;
		}
		this.pecas = pecas;
	}
		
	//metodo get de serviços
	public Servico[] getServicos() { return servicos; }
	
	//metodo set de serviços
	public void setServicos(Servico[] servicos) 
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
