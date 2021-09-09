package hospital.teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;
import hospital.dao.PacienteDao;
import hospital.modelo.Paciente;
import hospital.modelo.TipoPaciente;

public class TesteInsertedJDBC {

	public static void main(String[] args) {
		try {
			String url = "jdbc:postgresql://localhost:5433/hospital";
			String username = "postgres";
			String password = "AMam@!12";
			Connection conexao = DriverManager.getConnection(url,username,password);
			PacienteDao dao = new PacienteDao(conexao);
			
			
			Paciente paciente = new Paciente("Henrique Lustosa",
					"Sonia Maria Dias Lustosa Faria",
					"324.303.848-09",
					LocalDate.now(),
					TipoPaciente.MUNICIPE);
			
			dao.salvar(paciente);
		}catch (Exception e) {
			System.out.println("Ocorreu um erro");
		}
		
	}

}
