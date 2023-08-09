public class Orcamento
{
	private Peca[] peça;
    private Servico[] serviços;
    private double valorTotal;
    
    //Construtor do Orçamento
    public Orcamento(Peca[] peça, Servico[] serviços, double valorTotal){
    	this.peça = peça;
    	this.serviços = serviços;
    	this.valorTotal = valorTotal;  	
    }
    
    //metodo para calcular o orçamento
    public double calcularOrçamento()
    {	
        return valorTotal;
    }
    
    //metodo get peça
	public Peca[] getPeça() 
	{
		return peça;
	}
	
	//metodo set peça
	public void setPeça(Peca[] peça)
	{	//verificando se o valor não é nulo
		if(peça != null)
		{
			this.peça = peça;
		}
		else
		{
			System.out.println("Valor da peça Inválido!");
		}
	}
		
	//metodo get de serviços
	public Servico[] getServiços() {
		return serviços;
	}
	
	//metodo set de serviços
	public void setServiços(Servico[] serviços) 
	{	//verificando se o valor não é nulo!
		if(serviços != null) 
		{
			this.serviços = serviços;
		}
		else 
		{
			System.out.println("Valor do Serviço inválido!");
		}	
	}
	
	//metodo get do valor total
	public double getValorTotal() {
		return valorTotal;
	}
	//metodo set do valor total
	public void setValorTotal(double valorTotal) 
	{
		if(valorTotal >= 0) 
		{
			this.valorTotal = valorTotal;
		}
		else
		{
			System.out.println("Valor do orçamento zerado ou negativo!");
		}
	}
	
	//método relatorio - ainda vamos desenvolver
	public void gerarRelatorio() {
		System.out.println("Valor Total do orçamento é: " +  valorTotal);
	}
	
	
}
