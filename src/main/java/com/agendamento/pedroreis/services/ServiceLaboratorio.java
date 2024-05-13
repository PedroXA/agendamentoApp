package com.agendamento.pedroreis.services;

import com.agendamento.pedroreis.models.Laboratorio;
import com.agendamento.pedroreis.repositories.RepositoryLaboratorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceLaboratorio {
    @Autowired
    private RepositoryLaboratorio repositoryLaboratorio;

    public void CreateLaboratorio(Laboratorio laboratorio){
        repositoryLaboratorio.save(laboratorio);
    }

    public List<Laboratorio> listAllLaboratorio(){
        return repositoryLaboratorio.findAll();
    }

    public Optional<Laboratorio> getLaboratorio(int id){
        return repositoryLaboratorio.findById(id);
    }

    public void DeleteLaboratorio(Laboratorio laboratorio){
        repositoryLaboratorio.delete(laboratorio);
    }

}
