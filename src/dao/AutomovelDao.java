package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.Automovel;
import model.entity.Cliente;
import model.entity.Endereco;

public class AutomovelDao extends BaseDaoImpl<Automovel> {

	@Override
	public Long inserir(Automovel auto) {
		Connection con = getConnection();
		String sql = "INSERT INTO tb_automoveis(marca,cor,placa,ano,quilometragem,idProprietariofk) "
				+ "VALUES(?,?,?,?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, auto.getMarca());
			ps.setString(2, auto.getCor());
			ps.setString(3, auto.getPlaca());
			ps.setInt(4, auto.getAno());
			ps.setInt(5, auto.getQuilometragem());
			ps.setLong(6, auto.getProprietario().getId());
			ps.execute();
			ps.close();

			sql = "SELECT * FROM tb_automoveis as e WHERE e.placa = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, auto.getPlaca());
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
	public void deletar(Automovel auto) {
		Connection con = getConnection();
		String sql = "DELETE FROM tb_automoveis WHERE id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, auto.getId());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();

		}

	}

	@Override
	public void alterar(Automovel auto) {
		Connection con = getConnection();
		String sql = "UPDATE tb_automoveis set marca = ?, cor = ?, placa = ?, ano = ?, quilometragem = ?"
				+ "  WHERE id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, auto.getMarca());
			ps.setString(2, auto.getCor());
			ps.setString(3, auto.getPlaca());
			ps.setInt(4, auto.getAno());
			ps.setInt(5, auto.getQuilometragem());
			ps.setLong(6, auto.getId());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();

		}

	}

	@Override
	public Boolean buscar(Automovel auto) {
		Connection con = getConnection();
		String sql = "SELECT * FROM tb_automoveis WHERE placa = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, auto.getPlaca());
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				auto.setId(rs.getLong("id"));
				auto.setMarca(rs.getString("marca"));
				auto.setCor(rs.getString("cor"));
				auto.setPlaca(rs.getString("placa"));
				auto.setAno(rs.getInt("ano"));
				auto.setQuilometragem(rs.getInt("quilometragem"));
				auto.getProprietario().setId(rs.getLong("proprietariofk"));
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}

	@Override
	public List<Automovel> listar() {
		Connection con = getConnection();
		String sql = "SELECT * FROM tb_automoveis";
		List<Automovel> automoveis = new ArrayList<Automovel>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Automovel auto = new Automovel();
				Cliente proprietario = new Cliente();

				try {
					auto.setMarca(rs.getString("marca"));
					auto.setCor(rs.getString("cor"));
					auto.setPlaca(rs.getString("placa"));
					auto.setAno(rs.getInt("ano"));
					auto.setQuilometragem(rs.getInt("quilometragem"));
					auto.setProprietario(proprietario);
					auto.getProprietario().setId(rs.getLong("proprietariofk"));;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				automoveis.add(auto);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return automoveis;
		
	}

}
