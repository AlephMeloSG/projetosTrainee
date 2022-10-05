package br.com.sgsistemas.trainee.devsg.controller;

import br.com.sgsistemas.trainee.devsg.dto.ProdutoDto;
import br.com.sgsistemas.trainee.devsg.dto.ProdutoDtoSemId;
import br.com.sgsistemas.trainee.devsg.form.ProdutoForm;
import br.com.sgsistemas.trainee.devsg.modelo.Produto;
import br.com.sgsistemas.trainee.devsg.service.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoService produtoService;
    
    @GetMapping("/{nome}")
    public ResponseEntity<?> produto (@PathVariable String nome){
        Optional<Produto> produto = produtoService.buscaPorNome(nome);
        if(produto.isPresent()){
            return ResponseEntity.ok(new ProdutoDtoSemId(produto.get()));
        }
        return  ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ProdutoDto> cadastrar(@RequestBody @Valid ProdutoForm form, UriComponentsBuilder uriComponentsBuilder){
        Produto produto = produtoService.cadastrar(form);
        URI uri = uriComponentsBuilder.path("/{id}").buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).body(new ProdutoDto(produto));
    }

    @DeleteMapping("/removeById={id}")
    public ProdutoDto deletarByEndereco(@PathVariable Long id){
        Produto produto = produtoService.deletePorId(id);
        return new ProdutoDto(produto);
    }

    @DeleteMapping
    public ProdutoDto deletar(Long id){
        Produto produto = produtoService.deletePorId(id);
        return new ProdutoDto(produto);
    }

    @PutMapping()
    public ResponseEntity<ProdutoDto> atualizar(@RequestBody @Valid ProdutoForm form, UriComponentsBuilder uriComponentsBuilder){
        Produto produto = produtoService.atualizar(form);
        URI uri = uriComponentsBuilder.path("/{id}").buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).body(new ProdutoDto(produto));
    }
}
