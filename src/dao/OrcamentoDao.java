package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.Automovel;
import model.entity.Cliente;
import model.entity.Orcamento;

public class OrcamentoDao  extends BaseDaoImpl<Orcamento> {

	@Override
	public Long inserir(Orcamento orc) {
		Connection con = getConnection();
		String sql = "INSERT INTO tb_orcamentos(idAutomovelfk,idClientefk,valorTotal) VALUES(?,?,?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, orc.getAutomovel().getId());
			ps.setLong(2, orc.getCliente().getId());
			ps.setDouble(3, orc.getValorTotal());
			ps.execute();
			ps.close();
			sql = "SELECT * FROM tb_orcamentos WHERE idAutomovelfk = ? AND idClientefk = ? AND valorTotal = ?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, orc.getAutomovel().getId());
			ps.setLong(2, orc.getCliente().getId());
			ps.setDouble(3, orc.getValorTotal());
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return rs.getLong("idOrcamento");
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
	public void deletar(Orcamento orc) {
		Connection con = getConnection();
		String sql = "DELETE FROM tb_orcamentos WHERE idOrcamento = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, orc.getId());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();

		}
		
	}

	@Override
	public void alterar(Orcamento orc) {
		Connection con = getConnection();
		String sql = "UPDATE tb_orcamentos set idAutomovelfk = ?, idClientefk = ?, valorTotal = ? WHERE idOrcamento = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, orc.getAutomovel().getId());
			ps.setLong(2, orc.getCliente().getId());
			ps.setDouble(3, orc.getValorTotal());
			ps.setLong(4, orc.getId());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();

		}
		
	}

	@Override
	public Boolean buscar(Orcamento orc) {
		Connection con = getConnection();
		String sql = "SELECT * FROM tb_orcamentos WHERE idOrcamento = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, orc.getId());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				orc.setId(rs.getLong("idOrcamento"));
				orc.getAutomovel().setId(rs.getLong("idAutomovelfk"));
				orc.getCliente().setId(rs.getLong("idClientefk"));
				orc.setValorTotal(rs.getDouble("valorTotal"));
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
	public List<Orcamento> listar() {
		Connection con = getConnection();
		String sql = "SELECT * FROM tb_orcamentos";
		List<Orcamento> orcamentos = new ArrayList<Orcamento>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Automovel auto = new Automovel();
				Cliente cliente = new Cliente();
				Orcamento orc = new Orcamento(); 

				try {
					orc.setId(rs.getLong("idOrcamento"));
					orc.setAutomovel(auto);
					orc.getAutomovel().setId(rs.getLong("idAutomovelfk"));
					orc.setCliente(cliente);
					orc.getCliente().setId(rs.getLong("idClientefk"));
					orc.setValorTotal(rs.getDouble("valorTotal"));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				orcamentos.add(orc);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return orcamentos;
	}

}
