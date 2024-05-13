package com.agendamento.pedroreis.resources;

import com.agendamento.pedroreis.models.Reserva;
import com.agendamento.pedroreis.services.ServiceReserva;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reserva")
@SecurityRequirement(name = "security_auth")
public class ResourceReserva {
    @Autowired
    private ServiceReserva serviceReserva;

    @GetMapping("")
    public ResponseEntity<List<Reserva>> listALL(){
        return new ResponseEntity<List<Reserva>>(serviceReserva.listReserva(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> getReserva(@PathVariable("id") int id) {
        Optional<Reserva> optionalReserva = serviceReserva.getReserva(id);

        if (optionalReserva.isPresent()) {
            return new ResponseEntity<Reserva>(optionalReserva.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<Reserva> createReserva(@RequestBody Reserva reserva) {
        serviceReserva.CreateReserva(reserva);
        return new ResponseEntity<Reserva>(reserva, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Reserva> DeleteReserva(@PathVariable("id") int id) {

        Optional<Reserva> optionalReserva = serviceReserva.getReserva(id);

        if (optionalReserva.isPresent()) {
            serviceReserva.DeleteReserva(optionalReserva.get());
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Reserva> UpdateReserva(@PathVariable("id") int id,
                                                 @RequestBody Reserva reserva) {

        Optional<Reserva> optionalReserva = serviceReserva.getReserva(id);
        if (optionalReserva.isPresent()) {
            reserva.setId(id);
            serviceReserva.CreateReserva(reserva);
            return new ResponseEntity<Reserva>(reserva, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
