package br.com.sgsistemas.trainee.devsg.form;

import br.com.sgsistemas.trainee.devsg.modelo.Cargo;
import br.com.sgsistemas.trainee.devsg.modelo.Equipe;
import br.com.sgsistemas.trainee.devsg.modelo.Pessoa;
import br.com.sgsistemas.trainee.devsg.repository.EquipeRepository;
import br.com.sgsistemas.trainee.devsg.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PessoaForm {
    private Long id;
    @NotEmpty @NotNull
    private String nome;
    private String cargo;
    private String equipe;

    public Pessoa converter(EquipeRepository equipeRepository) {
        Cargo cargoModel;
        if (cargo.toLowerCase().equals("dev")) {
            cargoModel = Cargo.DEV;
        } else if (cargo.toLowerCase().equals("coordenador")) {
            cargoModel = Cargo.COORDENADOR;
        } else if (cargo.toLowerCase().equals("po")) {
            cargoModel = Cargo.PO;
        } else if (cargo.toLowerCase().equals("gerente")) {
            cargoModel = Cargo.GERENTE;
        } else if (cargo.toLowerCase().equals("tester")) {
            cargoModel = Cargo.TESTER;
        } else {
            return null;
        }
        Optional<Equipe> equipeModel = equipeRepository.findByNome(equipe);
        if(equipeModel.isPresent()) {
            return new Pessoa(nome.toLowerCase(), cargoModel, equipeModel.get());
        }
        return null;
    }

    public Pessoa converterComId(EquipeRepository equipeRepository, PessoaRepository pessoaRepository) {
        Cargo cargoModel;
        if (cargo.toLowerCase().equals("dev")) {
            cargoModel = Cargo.DEV;
        } else if (cargo.toLowerCase().equals("coordenador")) {
            cargoModel = Cargo.COORDENADOR;
        } else if (cargo.toLowerCase().equals("po")) {
            cargoModel = Cargo.PO;
        } else if (cargo.toLowerCase().equals("gerente")) {
            cargoModel = Cargo.GERENTE;
        } else if (cargo.toLowerCase().equals("tester")) {
            cargoModel = Cargo.TESTER;
        } else {
            cargoModel = pessoaRepository.findById(id).get().getCargo();
        }
        Equipe equipeModel;
        if (equipe != null && !equipe.isEmpty()) {
            equipeModel = equipeRepository.findByNome(equipe).get();
        } else {
            equipeModel = pessoaRepository.findById(id).get().getEquipe();
        }
        Pessoa pessoa = new Pessoa(nome.toLowerCase(), cargoModel, equipeModel);
        pessoa.setId(id);
        return pessoa;
    }
}
