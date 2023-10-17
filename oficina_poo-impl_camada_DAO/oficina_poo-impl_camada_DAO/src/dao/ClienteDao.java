package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.entity.Cliente;
import model.entity.Endereco;

public class ClienteDao extends BaseDaoImpl<Cliente> {

	@Override
	public Long inserir(Cliente cliente) {
		Connection con = getConnection();
		String sql = "INSERT INTO tb_clientes(nome,idEnderecofk,cpf) VALUES(?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cliente.getNome());
			ps.setLong(2, cliente.getEndereco().getId());
			ps.setString(3, cliente.getCPF());
			ps.execute();
			ps.close();

			sql = "SELECT * FROM tb_clientes as e WHERE e.cpf=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, cliente.getCPF());
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return rs.getLong("id");
			else
				return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			closeConnection();
		}

	}

	@Override
	public void deletar(Cliente cliente) {
		Connection con = getConnection();
		String sql = "DELETE FROM tb_clientes WHERE id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, cliente.getId());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();

		}

	}

	@Override
	public void alterar(Cliente cliente) {
		Connection con = getConnection();
		String sql = "UPDATE tb_clientes set nome = ?, cpf = ? WHERE id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getCPF());
			ps.setLong(3, cliente.getId());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();

		}

	}

	public Boolean buscar(Cliente cliente) {
		Connection con = getConnection();
		String sql = "SELECT * FROM tb_clientes WHERE id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, cliente.getId());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				cliente.setId(rs.getLong("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setCPF(rs.getString("cpf"));
				cliente.getEndereco().setId(rs.getLong("idEnderecofk"));
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			closeConnection();

		}
		

	}

	@Override
	public List<Cliente> listar() {
		Connection con = getConnection();
		String sql = "SELECT * FROM tb_clientes";
		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Cliente cliente = new Cliente();
				Endereco endereco = new Endereco();

				try {
					cliente.setNome(rs.getString("nome"));
					cliente.setEndereco(endereco);
					cliente.getEndereco().setId(rs.getLong("idEnderecofk"));
					cliente.setCPF(rs.getString("cpf"));
					cliente.setId(rs.getLong("id"));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				clientes.add(cliente);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return clientes;
	}

}
