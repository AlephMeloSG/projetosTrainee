package br.com.sgsistemas.forum.controller;

import java.net.URI;
import java.util.List;

import br.com.sgsistemas.forum.controller.dto.TopicoDto;
import br.com.sgsistemas.forum.controller.form.TopicoForm;
import br.com.sgsistemas.forum.modelo.Topico;
import br.com.sgsistemas.forum.repository.CursoRepository;
import br.com.sgsistemas.forum.repository.TopicoRepository;
import br.com.sgsistemas.forum.repository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

	private final TopicoRepository topicoRepository;
	private final CursoRepository cursoRepository;
	private final UsuarioRepository usuarioRepository;

	public TopicosController(TopicoRepository topicoRepository, CursoRepository cursoRepository, UsuarioRepository usuarioRepository) {
		this.topicoRepository = topicoRepository;
		this.cursoRepository = cursoRepository;
		this.usuarioRepository = usuarioRepository;
	}

	@GetMapping
	public List<TopicoDto> lista(String nomeCurso) {
		if (nomeCurso == null) {
			List<Topico> topicos = topicoRepository.findAll();
			return TopicoDto.converter(topicos);
		} else {
			List<Topico> topicos = topicoRepository.findByCursoNome(nomeCurso);
			return TopicoDto.converter(topicos);
		}
	}

	@PostMapping
	public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriComponentsBuilder){
		Topico topico = form.converter(cursoRepository);
		topicoRepository.save(topico);
		URI uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		return ResponseEntity.created(uri).body(new TopicoDto(topico));
	}

	@PutMapping
	public ResponseEntity<TopicoDto> atualizar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriComponentsBuilder){
		Topico topico = form.converterComId(cursoRepository);
		topico.setAutor(topicoRepository.findById(topico.getId()).get().getAutor());
		topicoRepository.save(topico);
		URI uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		return ResponseEntity.created(uri).body(new TopicoDto(topico));
	}

	@DeleteMapping
	public TopicoDto deletar(Long id){
		Topico topico = topicoRepository.findById(id).get();
		topicoRepository.deleteById(id);
		return new TopicoDto(topico);
	}
}
