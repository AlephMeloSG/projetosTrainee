package br.com.sgsistemas.spring.data.repository;

import br.com.sgsistemas.spring.data.model.Cargo;
import br.com.sgsistemas.spring.data.model.Funcionario;
import br.com.sgsistemas.spring.data.model.UnidadeTrabalho;
import org.springframework.data.repository.CrudRepository;

public interface FuncionarioRepository extends CrudRepository<Funcionario,Integer> {
}
