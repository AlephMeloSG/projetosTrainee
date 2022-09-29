package br.sgsistemas.trainee.loja.modelo;

import javax.persistence.*;

@Entity
public class Medico extends Pessoa{
	private int crm;

	public int getCrm() {
		return crm;
	}
	public void setCrm(int crm) {
		this.crm = crm;
	}
}
