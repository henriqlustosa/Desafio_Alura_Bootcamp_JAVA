package hospital.teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

import hospital.dao.PacienteDao;
import hospital.modelo.Paciente;
import hospital.modelo.TipoPaciente;

public class TesteDeletedJDBC {

	public static void main(String[] args) {

		try {

			String url = "jdbc:postgresql://localhost:5433/hospital";
			String username = "postgres";
			String password = "AMam@!12";
			
			Connection conexao = DriverManager.getConnection(url, username, password);
			
			PacienteDao dao = new PacienteDao(conexao);
			
			Paciente paciente = new Paciente(3, "Henrique Lustosa", "Sonia Maria Dias Lustosa Faria", "324.303.848-09",
					LocalDate.now(), TipoPaciente.MUNICIPE);
			
			boolean isDeleted =dao.deletePaciente(paciente);
			
			System.out.print(isDeleted);
			
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro");
		}
	}
}
