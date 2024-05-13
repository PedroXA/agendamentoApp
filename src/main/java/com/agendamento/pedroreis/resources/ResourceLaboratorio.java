package com.agendamento.pedroreis.resources;

import com.agendamento.pedroreis.models.Laboratorio;
import com.agendamento.pedroreis.services.ServiceLaboratorio;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/laboratorio")
@SecurityRequirement(name = "security_auth")
public class ResourceLaboratorio {
    @Autowired
    private ServiceLaboratorio serviceLaboratorio;

    @GetMapping("")
    public ResponseEntity<List<Laboratorio>> listALL(){
        return new ResponseEntity<List<Laboratorio>>(serviceLaboratorio.listAllLaboratorio(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Laboratorio> getLaboratorio(@PathVariable("id") int id) {
        Optional<Laboratorio> optionalLaboratorio = serviceLaboratorio.getLaboratorio(id);

        if (optionalLaboratorio.isPresent()) {
            return new ResponseEntity<Laboratorio>(optionalLaboratorio.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<Laboratorio> createLaboratorio(@RequestBody Laboratorio laboratorio) {
        serviceLaboratorio.CreateLaboratorio(laboratorio);
        return new ResponseEntity<Laboratorio>(laboratorio, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Laboratorio> DeleteLaboratorio(@PathVariable("id") int id) {

        Optional<Laboratorio> optionalLaboratorio = serviceLaboratorio.getLaboratorio(id);

        if (optionalLaboratorio.isPresent()) {
            serviceLaboratorio.DeleteLaboratorio(optionalLaboratorio.get());
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Laboratorio> UpdateLaboratorio(@PathVariable("id") int id,
                                                 @RequestBody Laboratorio laboratorio) {

        Optional<Laboratorio> optionalLaboratorio = serviceLaboratorio.getLaboratorio(id);
        if (optionalLaboratorio.isPresent()) {
            laboratorio.setId(id);
            serviceLaboratorio.CreateLaboratorio(laboratorio);
            return new ResponseEntity<Laboratorio>(laboratorio, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
