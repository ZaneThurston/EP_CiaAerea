package entities;

public class Aeronave extends ModeloAeronave {
	private String num_serie,
				   matricula,
				   categoria,
				   capacAer;

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNum_serie() {
		return num_serie;
	}

	public void setNum_serie(String num_serie) {
		this.num_serie = num_serie;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getCapacAer() {
		return capacAer;
	}

	public void setCapacAer(String capacAer) {
		this.capacAer = capacAer;
	}
}
