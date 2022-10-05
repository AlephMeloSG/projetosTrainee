package br.com.sgsistemas.cadastro.cliente.repository;

import br.com.sgsistemas.cadastro.cliente.modelo.Endereco;
import br.com.sgsistemas.cadastro.cliente.projection.ClienteProjection;
import br.com.sgsistemas.cadastro.cliente.projection.EnderecoProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EnderecoRepository  extends PagingAndSortingRepository<Endereco, Integer> {

    @Query(value = "select e.bairro bairro, e.cep cep, e.cidade cidade, e.logradouro logradouro, e.numero numero from endereco e", nativeQuery = true)
    Page<EnderecoProjection> findEnderecos(Pageable pageable);
}
