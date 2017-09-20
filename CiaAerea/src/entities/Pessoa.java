package entities;

public class Pessoa {
	private String nome,
		   		   cpf,
		   		   email,
		   		   rua,
		   		   num_rua,
		   		   bairro,
		   		   compl,
		   		   passaport,
		   		   niver;
	private char sexo,
	     		 spcl_necess;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNum_rua() {
		return num_rua;
	}

	public void setNum_rua(String num_rua) {
		this.num_rua = num_rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCompl() {
		return compl;
	}

	public void setCompl(String compl) {
		this.compl = compl;
	}

	public String getPassaport() {
		return passaport;
	}

	public void setPassaport(String passaport) {
		this.passaport = passaport;
	}

	public String getNiver() {
		return niver;
	}

	public void setNiver(String niver) {
		this.niver = niver;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public char getSpcl_necess() {
		return spcl_necess;
	}

	public void setSpcl_necess(char spcl_necess) {
		this.spcl_necess = spcl_necess;
	}
	

}
