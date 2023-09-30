package com.luanlima.clinicaodontologica.controller;

import com.luanlima.clinicaodontologica.domain.entity.ClinicaOdontologica;
import com.luanlima.clinicaodontologica.domain.entity.Service.ImplementsService.ClinicaOdontologicaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Tag(name = "Clinicas Odontológicas API", description = "API com dados das Clínicas Odontológicas")
@RequestMapping("v1/clinicas")
public class ClinicaOdontologicaController {

    private final ClinicaOdontologicaService clinicaOdontologicaService;

    @Autowired
    public ClinicaOdontologicaController(ClinicaOdontologicaService clinicaOdontologicaService) {
        this.clinicaOdontologicaService = clinicaOdontologicaService;
    }

    @PostMapping
    public ResponseEntity<ClinicaOdontologica> criarClinicaOdontologica(@RequestBody ClinicaOdontologica clinicaOdontologica) {
        ClinicaOdontologica novaClinica = clinicaOdontologicaService.criar(clinicaOdontologica);
        return new ResponseEntity<>(novaClinica, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClinicaOdontologica> buscarClinicaOdontologicaPorId(@PathVariable UUID id) {
        ClinicaOdontologica clinicaOdontologica = clinicaOdontologicaService.buscarPorId(id);
        if (clinicaOdontologica != null) {
            return ResponseEntity.ok(clinicaOdontologica);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ClinicaOdontologica>> listarTodasClinicasOdontologicas() {
        List<ClinicaOdontologica> clinicas = clinicaOdontologicaService.listarTodos();
        return ResponseEntity.ok(clinicas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClinicaOdontologica> atualizarClinicaOdontologica(@PathVariable UUID id, @RequestBody ClinicaOdontologica clinicaOdontologica) {
        ClinicaOdontologica atualizadaClinica = clinicaOdontologicaService.atualizar(clinicaOdontologica);
        if (atualizadaClinica != null) {
            return ResponseEntity.ok(atualizadaClinica);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarClinicaOdontologica(@PathVariable UUID id) {
        clinicaOdontologicaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
