package br.com.sgsistemas.trainee.devsg.repository;

import br.com.sgsistemas.trainee.devsg.modelo.Linguagem;
import br.com.sgsistemas.trainee.devsg.modelo.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {

    Optional<Produto> findByNome(String toLowerCase);
}
