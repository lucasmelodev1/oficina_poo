package model.bo;

import model.entity.Automovel;
import model.entity.Cliente;
import model.entity.Endereco;

public class AutomovelBO {
	public void criar(Automovel automovel) {
		Endereco end = automovel.getProprietario().getEndereco();
		Cliente cliente = automovel.getProprietario();

	}
}
