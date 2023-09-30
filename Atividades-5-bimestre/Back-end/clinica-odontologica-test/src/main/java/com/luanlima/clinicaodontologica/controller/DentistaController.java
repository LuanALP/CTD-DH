package com.luanlima.clinicaodontologica.controller;

import com.luanlima.clinicaodontologica.domain.entity.Dentista;
import com.luanlima.clinicaodontologica.domain.entity.Service.ImplementsService.DentistaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Tag(name = "Dentistas API", description = "API com dados dos dentistas")
@RequestMapping("v1/dentistas")
public class DentistaController {

    private final DentistaService dentistaService;

    @Autowired
    public DentistaController(DentistaService dentistaService) {
        this.dentistaService = dentistaService;
    }

    @PostMapping
    public ResponseEntity<Dentista> criarDentista(@RequestBody Dentista dentista) {
        Dentista novoDentista = dentistaService.criarDentista(dentista);
        return new ResponseEntity<>(novoDentista, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dentista> buscarDentistaPorId(@PathVariable UUID id) {
        Dentista dentista = dentistaService.buscarDentistaPorId(id);
        if (dentista != null) {
            return ResponseEntity.ok(dentista);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Dentista>> listarDentistas() {
        List<Dentista> dentistas = dentistaService.listarDentistas();
        return ResponseEntity.ok(dentistas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dentista> atualizarDentista(@PathVariable UUID id, @RequestBody Dentista dentista) {
        Dentista atualizadoDentista = dentistaService.atualizarDentista(dentista);
        if (atualizadoDentista != null) {
            return ResponseEntity.ok(atualizadoDentista);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarDentista(@PathVariable UUID id) {
        dentistaService.deletarDentista(id);
        return ResponseEntity.noContent().build();
    }
}
