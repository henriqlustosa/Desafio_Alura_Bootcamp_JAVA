package hospital.teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import hospital.dao.PacienteDao;
import hospital.modelo.Paciente;

public class TesteSelectedJDBC {
	public static void main(String[] args) {
	try {
		String url = "jdbc:postgresql://localhost:5433/hospital";
		String username = "postgres";
		String password = "AMam@!12";
		Connection conexao = DriverManager.getConnection(url,username,password);
		PacienteDao dao = new PacienteDao(conexao);
		
		List<Paciente> transacoes = dao.listar();
		
		transacoes.forEach(System.out::println);
		
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro");
		}
		}
}
