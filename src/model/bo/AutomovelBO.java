package model.bo;

import dao.AutomovelDao;
import dao.BaseDao;
import dao.ClienteDao;
import dao.EnderecoDao;
import model.entity.Automovel;
import model.entity.Cliente;
import model.entity.Endereco;

public class AutomovelBO {
	public void criar(Automovel automovel) {
		Endereco end = automovel.getProprietario().getEndereco();
		Cliente cliente = automovel.getProprietario();
		
		BaseDao clienteDao = new ClienteDao();
		BaseDao enderecoDao = new EnderecoDao();
		BaseDao automovelDao = new AutomovelDao();
		
		if(clienteDao.buscar(cliente)) {
			automovelDao.inserir(automovel);
		}
		
		
	}
}
