package br.com.sgsistemas.trainee.devsg.controller;

import br.com.sgsistemas.trainee.devsg.dto.LinguagemDto;
import br.com.sgsistemas.trainee.devsg.form.LinguagemForm;
import br.com.sgsistemas.trainee.devsg.modelo.Linguagem;
import br.com.sgsistemas.trainee.devsg.repository.LinguagemRepository;
import br.com.sgsistemas.trainee.devsg.service.LinguagemService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/linguagens")
@AllArgsConstructor
public class LinguagemController {
    private final LinguagemService linguagemService;


    @GetMapping("/{nome}")
    public ResponseEntity<?> linguagem (@PathVariable String nome){
        Optional<Linguagem> linguagem = linguagemService.buscaPorNome(nome);
        if(linguagem.isPresent()){
            return ResponseEntity.ok(new LinguagemDto(linguagem.get()));
        }
        return  ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<LinguagemDto> cadastrar(@RequestBody LinguagemForm form, UriComponentsBuilder uriComponentsBuilder){
        Linguagem linguagem = linguagemService.cadastrar(form);
        URI uri = uriComponentsBuilder.path("/{id}").buildAndExpand(linguagem.getId()).toUri();
        return ResponseEntity.created(uri).body(new LinguagemDto(linguagem));
    }

    @DeleteMapping("/removeById={id}")
    public LinguagemDto deletarByEndereco(@PathVariable Long id){
        Linguagem linguagem = linguagemService.deletePorId(id);
        return new LinguagemDto(linguagem);
    }

    @DeleteMapping
    public LinguagemDto deletar(Long id){
        Linguagem linguagem = linguagemService.deletePorId(id);
        return new LinguagemDto(linguagem);
    }

    @PutMapping()
    public ResponseEntity<LinguagemDto> atualizar(@RequestBody @Valid LinguagemForm form, UriComponentsBuilder uriComponentsBuilder){
        Linguagem linguagem = linguagemService.atualizar(form);
        URI uri = uriComponentsBuilder.path("/{id}").buildAndExpand(linguagem.getId()).toUri();
        return ResponseEntity.created(uri).body(new LinguagemDto(linguagem));
    }

}
