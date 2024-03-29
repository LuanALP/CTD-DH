package com.luanlima.clinicaodontologica.controller;

import com.luanlima.clinicaodontologica.domain.entity.Paciente;
import com.luanlima.clinicaodontologica.domain.entity.Service.ImplementsService.PacienteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Tag(name = "Pacientes API", description = "API com dados dos pacientes")
@RequestMapping("v1/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping
    public ResponseEntity<Paciente> criarPaciente(@RequestBody Paciente paciente) {
        Paciente novoPaciente = pacienteService.criarPaciente(paciente);
        return new ResponseEntity<>(novoPaciente, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPacientePorId(@PathVariable UUID id) {
        Paciente paciente = pacienteService.buscarPacientePorId(id);
        if (paciente != null) {
            return ResponseEntity.ok(paciente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> listarPacientes() {
        List<Paciente> pacientes = pacienteService.listarPacientes();
        return ResponseEntity.ok(pacientes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> atualizarPaciente(@PathVariable UUID id, @RequestBody Paciente paciente) {
        Paciente atualizadoPaciente = pacienteService.atualizarPaciente(paciente);
        if (atualizadoPaciente != null) {
            return ResponseEntity.ok(atualizadoPaciente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPaciente(@PathVariable UUID id) {
        pacienteService.deletarPaciente(id);
        return ResponseEntity.noContent().build();
    }
}
