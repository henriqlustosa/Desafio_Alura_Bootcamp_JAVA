package hospital.controller;

import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hospital.dao.PacienteDao;
import hospital.factory.ConnectionFactory;
import hospital.modelo.Paciente;
import hospital.modelo.TipoPaciente;
@WebServlet("/pacientes")
public class ServletController extends HttpServlet {
	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PacienteDao dao;

	public ServletController() {
		Connection conexao = new ConnectionFactory().getConnection();
		this.dao = new PacienteDao(conexao);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setAttribute("pacientes", dao.listar());
		req.getRequestDispatcher("WEB-INF/jsp/pacientes.jsp").forward(req, res);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		String mae = req.getParameter("mae");
		String cpf = req.getParameter("cpf");
		
		LocalDate dt_nascimento = LocalDate.parse(req.getParameter("dt_nascimento"), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		TipoPaciente tipo = TipoPaciente.valueOf(req.getParameter("tipo"));
		
		Paciente nova = new Paciente(nome, mae, cpf, dt_nascimento ,tipo);
		dao.salvar(nova);
		resp.sendRedirect("pacientes");
	}

}
