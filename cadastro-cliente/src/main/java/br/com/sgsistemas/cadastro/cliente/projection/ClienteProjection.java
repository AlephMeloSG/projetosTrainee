package br.com.sgsistemas.cadastro.cliente.projection;

import java.time.LocalDate;

public interface ClienteProjection {
    String getNome();
    LocalDate getDataNascimento();
}
