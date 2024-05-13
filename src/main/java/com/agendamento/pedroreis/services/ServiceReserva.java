package com.agendamento.pedroreis.services;

import com.agendamento.pedroreis.models.Reserva;
import com.agendamento.pedroreis.repositories.RepositoryReserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceReserva {
    @Autowired
    private RepositoryReserva repositoryReserva;

    public void CreateReserva(Reserva reserva){
         repositoryReserva.save(reserva);
    }

    public List<Reserva> listReserva(){
        return repositoryReserva.findAll();
    }

    public Optional<Reserva> getReserva(int id){
       return repositoryReserva.findById(id);
    }

    public void DeleteReserva(Reserva reserva){
        repositoryReserva.delete(reserva);
    }
 }
