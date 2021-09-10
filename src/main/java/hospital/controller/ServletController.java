package hospital.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import hospital.dao.PacienteDao;
import hospital.factory.ConnectionFactory;
import hospital.modelo.Paciente;
import hospital.modelo.TipoPaciente;


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
	
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        doGet(request, response);
	    }
	 
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        String action = request.getServletPath();
	 
	        try {
	            switch (action) {
	            case "/novo":
	                showNewForm(request, response);
	                break;
	            case "/insert":
	                insertPaciente(request, response);
	                break;
	            case "/delete":
	                deletePaciente(request, response);
	                break; 
	            case "/edit":
	                showEditForm(request, response);
	                break;
	            case "/update":
	                updatePaciente(request, response);
	                break;
	            default:
	                listPaciente(request, response);
	                break;
	            }
	        } catch (SQLException ex) {
	            throw new ServletException(ex);
	        }
	    }
	    private void deletePaciente(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	 
	        Paciente paciente = new Paciente(id);
	        dao.deletePaciente(paciente);
	        response.sendRedirect("pacientes");
	 
	    }
	    private void insertPaciente(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException {
	    	String nome = request.getParameter("nome");
			String mae = request.getParameter("mae");
			String cpf = request.getParameter("cpf");
			
			LocalDate dt_nascimento = LocalDate.parse(request.getParameter("dt_nascimento"), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			TipoPaciente tipo = TipoPaciente.valueOf(request.getParameter("tipo"));
			
	        Paciente paciente = new Paciente(nome, mae, cpf, dt_nascimento,tipo);
	        dao.salvar(paciente);
	        response.sendRedirect("pacientes");
	    }
	
	    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, ServletException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        Paciente existingBook = dao.getPaciente(id);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("pacienteForm.jsp");
	        request.setAttribute("book", existingBook);
	        dispatcher.forward(request, response);
	 
	    }
	
	    private void listPaciente(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException, ServletException {
	    
	        request.setAttribute("pacientes", dao.listar());
	        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/pacientes.jsp");
	        dispatcher.forward(request, response);
	    }
	    
	    
	    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/pacienteForm.jsp");
	        dispatcher.forward(request, response);
	    }
	    
	    
	    private void updatePaciente(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        String nome = request.getParameter("nome");
			String mae = request.getParameter("mae");
			String cpf = request.getParameter("cpf");
			
			LocalDate dt_nascimento = LocalDate.parse(request.getParameter("dt_nascimento"), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			TipoPaciente tipo = TipoPaciente.valueOf(request.getParameter("tipo"));
			
	 
			Paciente paciente = new Paciente(id,nome, mae, cpf, dt_nascimento ,tipo);
	        dao.updatePaciente(paciente);
	        response.sendRedirect("pacientes");
	    }
	    
	    
	    
	    
	    
	    

	/*@Override
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
	}*/

}
