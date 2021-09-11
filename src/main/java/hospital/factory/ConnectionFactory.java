package hospital.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	public Connection getConnection() {
		String url = "jdbc:postgresql://localhost:5432/hospital";
		String username = "postgres";
		String password = "AMam@!12";

		try {
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
