package model.bo;

import dao.BaseDao;
import dao.FuncionarioDao;
import model.entity.Funcionario;

public class UsuarioBO {
	
	public static Funcionario autenticar(Funcionario func) {
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		if(funcionarioDao.buscarPorLoginESenha(func)){
			return func;
		}
		else {
			return null;
		}
		
	}
	
	public static boolean cadastro(Funcionario func) {
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		
		if(!funcionarioDao.buscarPorLogin(func)) {
			funcionarioDao.inserir(func);
			return true;
		}
		else {
			return false;
		}
	}
}
