package entities;

public class Funcionario extends Pessoa {
	private String cargo,
				   cod_func,
				   num_ANAC,
				   aeronaves,
				   horas_voo,
				   CHT,
				   Idiomas,
				   tipo_contrato;

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getCod_func() {
		return cod_func;
	}

	public void setCod_func(String cod_func) {
		this.cod_func = cod_func;
	}

	public String getNum_ANAC() {
		return num_ANAC;
	}

	public void setNum_ANAC(String num_ANAC) {
		this.num_ANAC = num_ANAC;
	}

	public String getAeronaves() {
		return aeronaves;
	}

	public void setAeronaves(String aeronaves) {
		this.aeronaves = aeronaves;
	}

	public String getHoras_voo() {
		return horas_voo;
	}

	public void setHoras_voo(String horas_voo) {
		this.horas_voo = horas_voo;
	}

	public String getCHT() {
		return CHT;
	}

	public void setCHT(String cHT) {
		CHT = cHT;
	}

	public String getIdiomas() {
		return Idiomas;
	}

	public void setIdiomas(String idiomas) {
		Idiomas = idiomas;
	}

	public String getTipo_contrato() {
		return tipo_contrato;
	}

	public void setTipo_contrato(String tipo_contrato) {
		this.tipo_contrato = tipo_contrato;
	}
}
