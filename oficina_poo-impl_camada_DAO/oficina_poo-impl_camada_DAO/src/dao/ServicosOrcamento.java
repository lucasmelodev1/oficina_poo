package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.entity.Orcamento;
import model.entity.Servico;

public class ServicosOrcamento extends BaseDaoImpl<Orcamento> {
	
	@Override
	public Long inserir(Orcamento orc) {
	
		String sql = "INSERT INTO tb_orcamentosServicos(idOrcamentofk,idServicofk) VALUES(?,?)";
		
		for (int i = 0;i<orc.ListgetServicos().size();i++) {
			Connection con = getConnection();
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, orc.getId());
				ps.setLong(2, orc.ListgetServicos().get(i).getId());
				ps.execute();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			} 
			finally {
				closeConnection();
			}
		}
		return null;
	}

	@Override
	public void deletar(Orcamento orc) {
		Connection con = getConnection();
		String sql = "DELETE FROM tb_orcamentosServicos WHERE idOrcamentofk = ?";

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
	public void alterar(Orcamento entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean buscar(Orcamento orc) {
		Connection con = getConnection();
		String sql = "SELECT * FROM tb_orcamentosServicos WHERE idOrcamentofk = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, orc.getId());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Servico servico = new Servico();
				servico.setId(rs.getLong("idServicofk"));
				orc.ListgetServicos().add(servico);				
			}
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			closeConnection();

		}
		
	}

	@Override
	public List<Orcamento> listar() {
		return null;
		
	}
}
