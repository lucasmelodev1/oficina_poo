package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.Cliente;
import model.entity.Endereco;
import model.entity.Funcionario;

public class FuncionarioDao extends BaseDaoImpl<Funcionario> {

	@Override
	public Long inserir(Funcionario func) {
		Connection con = getConnection();
		String sql = "INSERT INTO tb_funcionarios(nome,login,senha,tipoFunc) VALUES(?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,func.getNome());
			ps.setString(2, func.getLogin());
			ps.setString(3, func.getSenha());
			ps.setString(4, func.getTipo());
			ps.execute();
			ps.close();

			sql = "SELECT * FROM tb_funcionarios as e WHERE e.login=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, func.getLogin());
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return rs.getLong("idFunc");
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
	public void deletar(Funcionario func) {
		Connection con = getConnection();
		String sql = "DELETE FROM tb_funcionarios WHERE id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, func.getId());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();

		}
		
	}

	@Override
	public void alterar(Funcionario func) {
		Connection con = getConnection();
		String sql = "UPDATE tb_funcionarios set nome = ?, login = ?, senha = ?  WHERE id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, func.getNome());
			ps.setString(2, func.getLogin());
			ps.setString(3, func.getSenha());
			ps.setLong(4, func.getId());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();

		}
		
	}

	@Override
	public Boolean buscar(Funcionario func) {
		Connection con = getConnection();
		String sql = "SELECT * FROM tb_funcionarios WHERE id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, func.getId());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				func.setId(rs.getLong("idFunc"));
				func.setNome(rs.getString("nome"));
				func.setTipo(rs.getString("tipoFunc"));
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
	
	public Boolean buscarPorLogin(Funcionario func) {
		Connection con = getConnection();
		String sql = "SELECT * FROM tb_funcionarios WHERE login = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, func.getLogin());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				func.setId(rs.getLong("idFunc"));
				func.setNome(rs.getString("nome"));
				func.setLogin(rs.getString("login"));
				func.setTipo(rs.getString("tipoFunc"));
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
	
	public Boolean buscarPorLoginESenha(Funcionario func) {
		Connection con = getConnection();
		String sql = "SELECT * FROM tb_funcionarios WHERE login = ? AND senha = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, func.getLogin());
			ps.setString(2, func.getSenha());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				func.setId(rs.getLong("idFunc"));
				func.setNome(rs.getString("nome"));
				func.setLogin(rs.getString("login"));
				func.setTipo(rs.getString("tipoFunc"));
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
	public List<Funcionario> listar() {
		Connection con = getConnection();
		String sql = "SELECT * FROM tb_funcionarios";
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Funcionario func = new Funcionario();

				try {
					func.setId(rs.getLong("idFunc"));
					func.setNome(rs.getString("nome"));
					func.setLogin(rs.getString("login"));
					func.setTipo(rs.getString("tipoFunc"));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				funcionarios.add(func);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return funcionarios;
	}

	

}
