package br.com.sgsistemas.udemyproject.repository;

import br.com.sgsistemas.udemyproject.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
