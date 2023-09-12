package main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;


import model.bo.ClienteBO;
import model.entity.Automovel;
import model.entity.Cliente;
import model.entity.Endereco;

public class Main {

	public static void main(String[] args) {

		Endereco end = new Endereco();
		Cliente cliente = new Cliente();
		cliente.setEndereco(end);
		Automovel automovel = new Automovel();
		automovel.setProprietario(cliente);
		Scanner scanner = new Scanner(System.in);

		System.out.println("bem vindo, usuario");
		int escolha = 0;
		while (escolha != 7) {
			System.out.println("1-cadastrar novo cliente");
			System.out.println("2-cadastrar novo automovel");
			System.out.println("3-Deletar cliente");
			System.out.println("4-alterar dados de um cliente");
			System.out.println("5-buscar dados de um cliente");
			System.out.println("6-listar clientes");
			System.out.println("7-Sair");
			escolha = scanner.nextInt();
			scanner.nextLine();
			switch (escolha) {
			case 1:
				try {
					System.out.print("nome :");
					cliente.setNome(scanner.nextLine());
					System.out.println();
					System.out.print("rua:");
					end.setRua(scanner.nextLine());
					System.out.println();
					System.out.print("bairro");
					end.setBairro(scanner.nextLine());
					System.out.println();
					System.out.print("numero:");
					end.setNumero(scanner.next());
					cliente.setEndereco(end);
					System.out.println();
					System.out.print("cpf:");
					cliente.setCPF(scanner.next());
					ClienteBO.criar(cliente);

				} catch (Exception e) {
					e.printStackTrace();
				}

				break;
			case 3:
				try {
					System.out.println("por favor, digite o id do cliente a ser deletado");
					cliente.setId(scanner.nextLong());
					ClienteBO.deletar(cliente);

				} catch (Exception e) {
					e.printStackTrace();
				}

				break;
			case 4:
				try {
					System.out.println("por favor, digite o id do cliente a ser alterado");
					cliente.setId(scanner.nextLong());
					ClienteBO.alterar(cliente);

				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 5:
				System.out.println("por favor, digite o id do cliente a ser buscado");
				cliente.setId(scanner.nextLong());
				ClienteBO.buscar(cliente);
				break;
			case 6:
				List<Cliente> clientes = ClienteBO.listar();
				System.out.println("ID----NOME----RUA----BAIRRO----NUMERO----CPF");
				for (int i = 0; i < clientes.size(); i++) {
					Cliente aux = clientes.get(i);
					System.out.println(aux.getId() + "----" + aux.getNome() + "----" + aux.getEndereco().getRua()
							+ "----" + aux.getEndereco().getBairro() + "----" + aux.getEndereco().getNumero() + "----"
							+ aux.getCPF());
				}
				break;
			default:
				break;
			}
		}

	}

}
