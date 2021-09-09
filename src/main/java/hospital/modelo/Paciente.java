package hospital.modelo;

import java.time.LocalDate;

public class Paciente {
		 
		private int id;
	  
	    private String nome;

	  
	    private String mae;

	 
	    private String cpf;

	    private LocalDate dt_nascimento;
	    
	    private TipoPaciente tipo;
	    
	    public Paciente() {};
	    
	    public Paciente(int id)
	    {
	    	this.id =id;
	    }	
	    
	    
	    
	    public Paciente(int id,String nome, String mae, String cpf, LocalDate dt_nascimento, TipoPaciente tipo) {
	    		this.id =id;
	 			this.nome = nome;
	 			this.mae = mae;
	 			this.cpf = cpf;
	 			this.dt_nascimento = dt_nascimento;
	 			this.tipo = tipo;
	 		}
	    public Paciente(String nome, String mae, String cpf, LocalDate dt_nascimento, TipoPaciente tipo) {
			this.nome = nome;
			this.mae = mae;
			this.cpf = cpf;
			this.dt_nascimento = dt_nascimento;
			this.tipo = tipo;
		}
	    
	    
	    
	    

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getMae() {
			return mae;
		}

		public void setMae(String mae) {
			this.mae = mae;
		}

		public String getCpf() {
			return cpf;
		}

		public void setCpf(String cpf) {
			this.cpf = cpf;
		}

		public LocalDate getDt_nascimento() {
			return dt_nascimento;
		}

		public void setDt_nascimento(LocalDate dt_nascimento) {
			this.dt_nascimento = dt_nascimento;
		}

		public TipoPaciente getTipo() {
			return tipo;
		}

		public void setTipo(TipoPaciente tipo) {
			this.tipo = tipo;
		}
		@Override
		public String toString() {
			return "Paciente [nome=" + nome + ", nomeMae=" + mae + ", cpf=" + cpf + ", dt_nascimento=" + dt_nascimento
					+ ", tipo=" + tipo + "]";
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
}
