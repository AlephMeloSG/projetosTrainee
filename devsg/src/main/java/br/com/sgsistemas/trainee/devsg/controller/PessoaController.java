package br.com.sgsistemas.trainee.devsg.controller;

import br.com.sgsistemas.trainee.devsg.dto.PessoasDto;
import br.com.sgsistemas.trainee.devsg.dto.PessoasDtoComEquipe;
import br.com.sgsistemas.trainee.devsg.form.PessoaForm;
import br.com.sgsistemas.trainee.devsg.modelo.Pessoa;
import br.com.sgsistemas.trainee.devsg.service.PessoaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
@AllArgsConstructor
public class PessoaController {
    private final PessoaService pessoaService;

    @GetMapping("/{nome}")
    public ResponseEntity<?> pessoa (@PathVariable String nome){
        Optional<Pessoa> pessoa = pessoaService.buscaPorNome(nome);
        if(pessoa.isPresent()){
            return ResponseEntity.ok(new PessoasDtoComEquipe(pessoa.get()));
        }
        return  ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<PessoasDto> cadastrar(@RequestBody @Valid PessoaForm form, UriComponentsBuilder uriComponentsBuilder){
        Pessoa pessoa = pessoaService.cadastra(form);
        URI uri = uriComponentsBuilder.path("/{id}").buildAndExpand(pessoa.getId()).toUri();
        return ResponseEntity.created(uri).body(new PessoasDto(pessoa));
    }

    @DeleteMapping("/removeById={id}")
    public PessoasDto deletarByEndereco(@PathVariable Long id){
        Pessoa pessoa = pessoaService.deletePorId(id);
        return new PessoasDto(pessoa);
    }

    @DeleteMapping
    public PessoasDto deletar(Long id){
        Pessoa pessoa = pessoaService.deletePorId(id);
        return new PessoasDto(pessoa);
    }

    @PutMapping()
    public ResponseEntity<PessoasDto> atualizar(@RequestBody @Valid PessoaForm form, UriComponentsBuilder uriComponentsBuilder){
        Pessoa pessoa = pessoaService.atualiza(form);
        URI uri = uriComponentsBuilder.path("/{id}").buildAndExpand(pessoa.getId()).toUri();
        return ResponseEntity.created(uri).body(new PessoasDto(pessoa));
    }
}
