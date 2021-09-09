package hospital.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hospital.modelo.Paciente;
import hospital.modelo.TipoPaciente;

import java.sql.Connection;
import java.sql.Date;

public class PacienteDao {
	private Connection conexao;
			
	public PacienteDao(Connection conexao) {
				this.conexao = conexao;
	}
	public void salvar(Paciente paciente) {
		try {
			String sql = "insert into pacientes( nome, mae, cpf, dt_nascimento, tipo) values(?,?,?,?,?)";
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, paciente.getNome());
			ps.setString(2, paciente.getMae());
			ps.setString(3, paciente.getCpf());
			ps.setDate(4, Date.valueOf(paciente.getDt_nascimento()));
			ps.setString(5, paciente.getTipo().toString());

			ps.execute();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public List<Paciente> listar() {
		try {
			String sql = "select * from pacientes";
			PreparedStatement ps = conexao.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			List<Paciente> pacientes = new ArrayList<>();
	
			while (rs.next()) {
				Paciente paciente = new Paciente(
						rs.getString("nome"),
						rs.getString("mae"), 
						rs.getString("cpf"), 
						rs.getDate("dt_nascimento").toLocalDate(),
						TipoPaciente.valueOf(rs.getString("tipo")));
				
				pacientes.add(paciente);
						
						
			}
			
			return pacientes;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	 public boolean deletePaciente(Paciente Paciente) throws SQLException {
	        String sql = "DELETE FROM Paciente where Paciente_id = ?";
	         
	       // connect();
	         
	        PreparedStatement statement = conexao.prepareStatement(sql);
	        statement.setInt(1, Paciente.getId());
	         
	        boolean rowDeleted = statement.executeUpdate() > 0;
	        statement.close();
	       // disconnect();
	        return rowDeleted;     
	    }
	  public boolean updatePaciente(Paciente paciente) throws SQLException {
	        String sql = "UPDATE Paciente SET title = ?, author = ?, price = ?";
	        sql += " WHERE Paciente_id = ?";
	       // connect();
	         
	        PreparedStatement statement = conexao.prepareStatement(sql);
	        statement.setString(1, paciente.getNome());
	        statement.setString(2, paciente.getMae());
	        statement.setString(3, paciente.getCpf());
	        statement.setDate(4, Date.valueOf(paciente.getDt_nascimento()));
	        statement.setString(5, paciente.getTipo().toString());
	        statement.setInt(4, paciente.getId());
	         
	        boolean rowUpdated = statement.executeUpdate() > 0;
	        statement.close();
	       // disconnect();
	        return rowUpdated;     
	    }
	  
	  public Paciente getPaciente(int id) throws SQLException {
	        Paciente Paciente = null;
	        String sql = "SELECT * FROM Paciente WHERE Paciente_id = ?";
	         
	        //connect();
	         
	        PreparedStatement statement = conexao.prepareStatement(sql);
	        statement.setInt(1, id);
	         
	        ResultSet resultSet = statement.executeQuery();
	         
	        if (resultSet.next()) {
	        
	            String title = resultSet.getString("title");
	            String author = resultSet.getString("author");
	            float price = resultSet.getFloat("price");
	             
	            Paciente = new Paciente(id, title, author, price);
	        }
	         
	        resultSet.close();
	        statement.close();
	         
	        return Paciente;
	    }
	
}
