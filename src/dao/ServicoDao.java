package dao;

import java.sql.Connection; //NEW THROW 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.Peca;
import model.entity.Servico;

public class ServicoDao extends BaseDaoImpl<Servico> {

	@Override
	public Long inserir(Servico servico) {
		Connection con = getConnection();
		String sql = "INSERT INTO tb_servicos(nome,valor) VALUES(?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, servico.getNome());
			ps.setDouble(2,servico.getValor());
			ps.execute(); 
			ps.close();

			sql = "SELECT * FROM tb_servicos as e WHERE e.nome=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, servico.getNome());
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return rs.getLong("idServico");
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
	public void deletar(Servico servico) {
		Connection con = getConnection();
		String sql = "DELETE FROM tb_servicos WHERE idServico = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, servico.getId());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();

		}
		
	}

	@Override
	public void alterar(Servico servico) {
		Connection con = getConnection();
		String sql = "UPDATE tb_servicos set nome = ?, valor = ?  WHERE idServico = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, servico.getNome());
			ps.setDouble(2, servico.getValor());
			ps.setLong(3, servico.getId());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();

		}
		
	}

	@Override
	public Boolean buscar(Servico servico) {
		Connection con = getConnection();
		String sql = "SELECT * FROM tb_servicos WHERE idServico= ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, servico.getId());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				servico.setNome(rs.getString("nome"));
				servico.setValor(rs.getDouble("preco"));
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
	public List<Servico> listar() {
		Connection con = getConnection();
		String sql = "SELECT * FROM tb_pecas";
		List<Servico> servicos = new ArrayList<Servico>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Servico servico = new Servico();

				try {
					servico.setId(rs.getLong("idServico"));
					servico.setNome(rs.getString("nome"));
					servico.setValor(rs.getDouble("valor"));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				servicos.add(servico);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return servicos;
	}

}
