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
import model.entity.Peca;

public class PecasOrcamento extends BaseDaoImpl<Orcamento> {

	@Override
	public Long inserir(Orcamento orc) {
	
		
		String sql = "INSERT INTO tb_orcamentosPecas(idOrcamentofk,idPecafk) VALUES(?,?)";
		
		for (int i = 0;i<orc.getPeca().size();i++) {
			Connection con = getConnection();
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setLong(1, orc.getId());
				ps.setLong(2, orc.getPeca().get(i).getId());
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
		String sql = "DELETE FROM tb_orcamentosPecas WHERE idOrcamentofk = ?";

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
		String sql = "SELECT * FROM tb_orcamentosPecas WHERE idOrcamentofk = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, orc.getId());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Peca peca = new Peca();
				peca.setId(rs.getLong("idPecafk"));
				orc.getPeca().add(peca);				
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
