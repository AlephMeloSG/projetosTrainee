package br.com.alura;

import java.util.*;

public class Curso {

	private String nome;
	private String instrutor;
	private List<Aula> aulas = new LinkedList<>();
	private Set<Aluno> alunos = new HashSet<>();
	private Map<Integer, Set<Aluno>> matriculas = new HashMap<>();

	public Curso(String nome, String instrutor) {
		this.nome = nome;
		this.instrutor = instrutor;
	}

	public String getNome() {
		return nome;
	}

	public String getInstrutor() {
		return instrutor;
	}

	public List<Aula> getAulas() {
		return Collections.unmodifiableList(aulas);
	}

	public void adiciona(Aula aula) {
		this.aulas.add(aula);
	}

	public void matricula(Aluno aluno) {
		alunos.add(aluno);
		Set<Aluno> alunos1 = new HashSet<>();
		if(matriculas.get(aluno.getNumeroMatricula()) != null) {
			matriculas.get(aluno.getNumeroMatricula()).forEach(aluno1 -> alunos1.add(aluno1));
		}
		alunos1.add(aluno);
		matriculas.put(aluno.getNumeroMatricula(), alunos1);
	}

	public Set<Aluno> getAlunos(){
		return Collections.unmodifiableSet(this.alunos);
	}

	public boolean estaMatriculado(Aluno aluno) {
		return this.alunos.contains(aluno);
	}

	public Set<Aluno> buscaMatricula(int numeroMatricula){
		if (!matriculas.containsKey(numeroMatricula)){
			throw new NullPointerException("Matricula inexistente: " + numeroMatricula);
		}
		return matriculas.get(numeroMatricula);
	}
}
