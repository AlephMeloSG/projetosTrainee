package br.com.sgsistemas.forum.controller.form;

import br.com.sgsistemas.forum.modelo.Curso;
import br.com.sgsistemas.forum.modelo.Topico;
import br.com.sgsistemas.forum.repository.CursoRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class TopicoForm {
    private Long id;
    @NotNull @NotEmpty @Length(min = 6)
    private String titulo;
    @NotNull @NotEmpty @Length(min = 6)
    private String mensagem;
    @NotNull @NotEmpty @Length(min = 6)
    private String nomeCurso;

    public TopicoForm() {
    }

    public TopicoForm(String titulo, String mensagem, String nomeCurso) {
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.nomeCurso = nomeCurso;
    }

    public TopicoForm(Long id, String titulo, String mensagem, String nomeCurso) {
        this.id = id;
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.nomeCurso = nomeCurso;
    }

    public Topico converter(CursoRepository cursoRepository){
        Curso curso = cursoRepository.findCursoByNome(nomeCurso);
        return new Topico(titulo,mensagem,curso);
    }

    public Topico converterComId(CursoRepository cursoRepository){
        Curso curso = cursoRepository.findCursoByNome(nomeCurso);
        Topico topico = new Topico(titulo,mensagem,curso);
        topico.setId(id);
        return topico;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getMensagem() {
        return mensagem;
    }
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    public String getNomeCurso() {
        return nomeCurso;
    }
    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
