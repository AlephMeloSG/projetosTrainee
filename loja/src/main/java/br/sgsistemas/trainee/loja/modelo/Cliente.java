package br.sgsistemas.trainee.loja.modelo;

import javax.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Embedded
	DadosPessoais dadosPessoais;

	public Cliente(String nome, String cpf) {
		dadosPessoais = new DadosPessoais(nome, cpf);
	}

	public Cliente() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return this.dadosPessoais.getNome();
	}

	public void setNome(String nome) {
		this.dadosPessoais.setNome(nome);
	}

	public String getCpf() {
		return this.dadosPessoais.getCpf();
	}

	public void setCpf(String cpf) {
		this.dadosPessoais.setNome(cpf);
	}

}
