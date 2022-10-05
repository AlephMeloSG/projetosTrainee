package br.com.sgsistemas.cadastro.cliente.repository;

import br.com.sgsistemas.cadastro.cliente.modelo.Cliente;
import br.com.sgsistemas.cadastro.cliente.projection.ClienteProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Integer> {
    @Query(value = "select c.nome nome, c.data_nascimento dataNascimento from clientes c", nativeQuery = true)
    Page<ClienteProjection> findNomeDataNascimento(Pageable pageable);
}
