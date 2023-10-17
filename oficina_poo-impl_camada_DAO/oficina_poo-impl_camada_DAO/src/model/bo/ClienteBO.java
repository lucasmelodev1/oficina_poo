package model.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.BaseDao;
import dao.BaseDaoImpl;
import dao.ClienteDao;
import dao.EnderecoDao;
import model.entity.Cliente;
import model.entity.Endereco;

public class ClienteBO {

	public static void criar(Cliente cliente) {
		Endereco endereco = cliente.getEndereco();
		BaseDao clienteDao = new ClienteDao();
		BaseDao enderecoDao = new EnderecoDao();

		endereco.setId(enderecoDao.inserir(endereco));
		cliente.setEndereco(endereco);
		clienteDao.inserir(cliente);
		System.out.println("cadastro sucedido");
	}

	public static void deletar(Cliente cliente) {
		BaseDao<Cliente> clienteDao = new ClienteDao();
		BaseDao<Endereco> enderecoDao = new EnderecoDao();

		if (!clienteDao.buscar(cliente)) {
			System.out.println("não tem como deletar o que não existe");
		} else {
			clienteDao.deletar(cliente);
			enderecoDao.deletar(cliente.getEndereco());
			System.out.println("cliente deletado!");
		}
	}

	public static void alterar(Cliente cliente) {
		Scanner scanner = new Scanner(System.in);
		BaseDao<Cliente> clienteDao = new ClienteDao();
		BaseDao<Endereco> enderecoDao = new EnderecoDao();

		if (clienteDao.buscar(cliente)) {
			try {
				System.out.print("nome:");
				cliente.setNome(scanner.nextLine());
				System.out.println();
				System.out.print("rua:");
				cliente.getEndereco().setRua(scanner.nextLine());
				System.out.print("bairro:");
				cliente.getEndereco().setBairro(scanner.nextLine());
				System.out.println();
				System.out.print("numero:");
				cliente.getEndereco().setNumero(scanner.next());
				System.out.println();
				System.out.print("cpf:");
				cliente.setCPF(scanner.next());
				clienteDao.alterar(cliente);
				System.out.println("alteração concluida");
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("não tem como alterar o que não existe");
		}
	}

	public static void buscar(Cliente cliente) {
		Scanner scanner = new Scanner(System.in);
		BaseDao<Cliente> clienteDao = new ClienteDao();
		BaseDao<Endereco> enderecoDao = new EnderecoDao();

		if (clienteDao.buscar(cliente)) {
			enderecoDao.buscar(cliente.getEndereco());
			System.out.println("ID----NOME----RUA----BAIRRO----NUMERO----CPF");
			System.out.println(cliente.getId() + "----" + cliente.getNome() + "----" + cliente.getEndereco().getRua()
					+ "----" + cliente.getEndereco().getBairro() + "----" + cliente.getEndereco().getNumero() + "----"
					+ cliente.getCPF());
		} else {
			System.out.println("cliente não encontrado");
		}
	}

	public static List<Cliente> listar() {
		BaseDao<Cliente> clienteDao = new ClienteDao();
		BaseDao<Endereco> enderecoDao = new EnderecoDao();

		List<Cliente> clientes = clienteDao.listar();
		for (int i = 0; i < clientes.size(); i++) {
			enderecoDao.buscar(clientes.get(i).getEndereco());
		}
		return clientes;
	}
}
