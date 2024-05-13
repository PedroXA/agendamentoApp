package com.agendamento.pedroreis.repositories;

import com.agendamento.pedroreis.models.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryReserva extends JpaRepository<Reserva, Integer> {
}
