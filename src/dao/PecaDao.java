package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.Cliente;
import model.entity.Endereco;
import model.entity.Peca;

public class PecaDao extends BaseDaoImpl<Peca> {

	@Override
	public Long inserir(Peca peca) {
		Connection con = getConnection();
		String sql = "INSERT INTO tb_pecas(nome,preco,fabricante) VALUES(?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, peca.getNome());
			ps.setDouble(2,peca.getPreco());
			ps.setString(3, peca.getFabricante());
			ps.execute();
			ps.close();

			sql = "SELECT * FROM tb_pecas as e WHERE e.nome=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, peca.getNome());
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return rs.getLong("idPeca");
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
	public void deletar(Peca peca) {
		Connection con = getConnection();
		String sql = "DELETE FROM tb_pecas WHERE id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, peca.getId());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();

		}
		
	}

	@Override
	public void alterar(Peca peca) {
		Connection con = getConnection();
		String sql = "UPDATE tb_pecas set nome = ?, preco = ?, fabricante = ?  WHERE id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, peca.getNome());
			ps.setDouble(2, peca.getPreco());
			ps.setString(3, peca.getFabricante());
			ps.setLong(4, peca.getId());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();

		}
		
	}

	@Override
	public Boolean buscar(Peca peca) {
		Connection con = getConnection();
		String sql = "SELECT * FROM tb_pecas WHERE id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, peca.getId());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				peca.setNome(rs.getString("nome"));
				peca.setPreco(rs.getDouble("preco"));
				peca.setFabricante(rs.getString("fabricante"));
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
	public List<Peca> listar() {
		Connection con = getConnection();
		String sql = "SELECT * FROM tb_pecas";
		List<Peca> pecas = new ArrayList<Peca>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Peca peca = new Peca();

				try {
					peca.setId(rs.getLong("idPeca"));
					peca.setNome(rs.getString("nome"));
					peca.setPreco(rs.getDouble("preco"));
					peca.setFabricante(rs.getString("fabricante"));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				pecas.add(peca);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return pecas;
	}

}
