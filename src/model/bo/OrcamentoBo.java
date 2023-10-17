package model.bo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dao.AutomovelDao;
import dao.ClienteDao;
import dao.OrcamentoDao;
import dao.PecasOrcamento;
import dao.ServicosOrcamento;
import model.entity.Orcamento;
import model.entity.Peca;
import model.entity.Servico;

public class OrcamentoBo {

	public static void criar(Orcamento orc) {
		ClienteDao cliente = new ClienteDao();
		AutomovelDao automovel = new AutomovelDao();
		OrcamentoDao orcamento = new OrcamentoDao();
		PecasOrcamento pecasOrcamento = new PecasOrcamento();
		ServicosOrcamento servicosOrcamento = new ServicosOrcamento();
		
		if(cliente.buscar(orc.getCliente()) == true && automovel.buscar(orc.getAutomovel()) == true) {
			orc.setId(orcamento.inserir(orc));
			pecasOrcamento.inserir(orc);
			servicosOrcamento.inserir(orc);
			
		}
	}
	
	public static void deletar(Orcamento orc) {
		OrcamentoDao orcamento = new OrcamentoDao();
		PecasOrcamento pecasOrcamento = new PecasOrcamento();
		ServicosOrcamento servicosOrcamento = new ServicosOrcamento();
		if(orcamento.buscar(orc) == true) {
			pecasOrcamento.deletar(orc);
			servicosOrcamento.deletar(orc);
			orcamento.deletar(orc);
		}
	}
	
	public static void buscar(Orcamento orc) {
		ClienteDao cliente = new ClienteDao();
		AutomovelDao automovel = new AutomovelDao();
		OrcamentoDao orcamento = new OrcamentoDao();
		PecasOrcamento pecasOrcamento = new PecasOrcamento();
		ServicosOrcamento servicosOrcamento = new ServicosOrcamento();
		List<Peca> pecas = new ArrayList<Peca>();
		List<Servico> servicos = new ArrayList<Servico>();
		orc.setPecas(pecas);
		orc.setServicos(servicos);
		
		if(orcamento.buscar(orc) == true) {
			cliente.buscar(orc.getCliente());
			String nomeCliente = orc.getCliente().getNome();
			automovel.buscar(orc.getAutomovel());
			String marcaAutomovel = orc.getAutomovel().getMarca();
			String placaAutomovel = orc.getAutomovel().getPlaca();
			pecasOrcamento.buscar(orc);
			servicosOrcamento.buscar(orc);
			
			System.out.println("orcamento do automovel " + marcaAutomovel + " com placa " + placaAutomovel
					+  " do cliente " + nomeCliente );
			System.out.println("pecas utilizadas: ");
			for(int i = 0;i< orc.getPeca().size();i++) {
				System.out.println("nome: " + orc.getPeca().get(i).getNome() + "fabricante: " + orc.getPeca().get(i).getFabricante()
						+ "valor : " + orc.getPeca().get(i).getPreco()); 
			}
			System.out.println("servicos realizados:");
			for (int i = 0; i< orc.ListgetServicos().size();i++) {
				System.out.println("servico: " + orc.ListgetServicos().get(i).getNome() + "valor" + orc.ListgetServicos().get(i).getValor());
			}
			
			System.out.println("valor total:" + orc.getValorTotal());
		}
		else {
			System.out.println("servico nao encontrado");
		}
	}
}
