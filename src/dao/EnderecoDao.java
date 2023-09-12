package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.entity.Endereco;

public class EnderecoDao extends BaseDaoImpl<Endereco> {

	@Override
	public Long inserir(Endereco endereco) {
		Connection con = getConnection();
		String sql = "INSERT INTO tb_enderecos (rua,numero,bairro) " + "values (?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, endereco.getRua());
			ps.setString(2, endereco.getNumero());
			ps.setString(3, endereco.getBairro());
			ps.execute();
			ps.close();

			sql = "SELECT * FROM tb_enderecos as e WHERE e.rua=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, endereco.getRua());
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return rs.getLong("id");
			else
				return null;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			closeConnection();

		}

	}

	@Override
	public void deletar(Endereco endereco) {
		Connection con = getConnection();
		String sql = "DELETE FROM tb_enderecos WHERE id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, endereco.getId());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void alterar(Endereco endereco) {
		Connection con = getConnection();
		String sql = "UPDATE tb_enderecos set rua = ?, numero = ?, bairro = ? WHERE id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, endereco.getRua());
			ps.setString(2, endereco.getNumero());
			ps.setString(3, endereco.getBairro());
			ps.setLong(4, endereco.getId());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			// TODO: handle exception
		}

	}

	@Override
	public Boolean buscar(Endereco endereco) {
		Connection con = getConnection();
		String sql = "SELECT * FROM tb_enderecos WHERE id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, endereco.getId());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				endereco.setRua(rs.getString("rua"));
				endereco.setNumero(rs.getString("numero"));
				endereco.setBairro(rs.getString("bairro"));
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			closeConnection();
		}
	}

	@Override
	public List<Endereco> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}