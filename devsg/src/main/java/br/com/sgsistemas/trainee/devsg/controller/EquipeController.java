package br.com.sgsistemas.trainee.devsg.controller;

import br.com.sgsistemas.trainee.devsg.dto.EquipeDto;
import br.com.sgsistemas.trainee.devsg.dto.EquipeDtoCompleto;
import br.com.sgsistemas.trainee.devsg.form.EquipeForm;
import br.com.sgsistemas.trainee.devsg.modelo.Equipe;
import br.com.sgsistemas.trainee.devsg.preview.Preview;
import br.com.sgsistemas.trainee.devsg.service.EquipeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/equipes")
@AllArgsConstructor
public class EquipeController {
    private final EquipeService equipeService;

    @GetMapping("/{nome}")
    public ResponseEntity<?> equipeDetalhada (@PathVariable String nome){
        Optional<Equipe> equipe = equipeService.BuscaPorNome(nome.toLowerCase());
        if(equipe.isPresent()){
            return ResponseEntity.ok(new EquipeDtoCompleto(equipe.get()));
        }
        return  ResponseEntity.notFound().build();
    }
    @GetMapping("/preview.{nome}")
    public String equipeDetalhadaPreview (@PathVariable String nome){
        Optional<Equipe> equipe = equipeService.BuscaPorNome(nome.toLowerCase());
        if(equipe.isPresent()){
            return Preview.visualizar(equipe);
        }
        return "Equipe inexistente";
    }

    @PostMapping
    public ResponseEntity<EquipeDto> cadastrar(@RequestBody @Valid EquipeForm form, UriComponentsBuilder uriComponentsBuilder){
        Equipe equipe = equipeService.cadastrar(form);
        URI uri = uriComponentsBuilder.path("/{id}").buildAndExpand(equipe.getId()).toUri();
        return ResponseEntity.created(uri).body(new EquipeDto(equipe));
    }

    @DeleteMapping("/removeById={id}")
    public EquipeDto deletarByEndereco(@PathVariable Long id){
        Equipe equipe = equipeService.deletePorId(id);
        return new EquipeDto(equipe);
    }

    @DeleteMapping
    public EquipeDto deletar(Long id){
        Equipe equipe = equipeService.deletePorId(id);
        return new EquipeDto(equipe);
    }

    @PutMapping()
    public ResponseEntity<EquipeDto> atualizar(@RequestBody @Valid EquipeForm form, UriComponentsBuilder uriComponentsBuilder){
        Equipe equipe = equipeService.atualizar(form);
        URI uri = uriComponentsBuilder.path("/{id}").buildAndExpand(equipe.getId()).toUri();
        return ResponseEntity.created(uri).body(new EquipeDto(equipe));
    }
}
