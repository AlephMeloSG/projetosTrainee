package br.com.sgsistemas.spring.data.repository;

import br.com.sgsistemas.spring.data.model.Cargo;
import br.com.sgsistemas.spring.data.model.UnidadeTrabalho;
import org.springframework.data.repository.CrudRepository;

public interface UnidadeTrabalhoRepository extends CrudRepository<UnidadeTrabalho,Integer> {
}
