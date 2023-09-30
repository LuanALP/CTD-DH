package com.luanlima.clinicaodontologica.controller;

import com.luanlima.clinicaodontologica.domain.entity.Consulta;
import com.luanlima.clinicaodontologica.domain.entity.Service.ImplementsService.ConsultaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Tag(name = "Consultas API", description = "API com dados das consultas")
@RequestMapping("v1/consultas")
public class ConsultaController {

    private final ConsultaService consultaService;

    @Autowired
    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @PostMapping
    public ResponseEntity<Consulta> criarConsulta(@RequestBody Consulta consulta) {
        Consulta novaConsulta = consultaService.criarConsulta(consulta);
        return new ResponseEntity<>(novaConsulta, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consulta> buscarConsultaPorId(@PathVariable UUID id) {
        Consulta consulta = consultaService.buscarConsultaPorId(id);
        if (consulta != null) {
            return ResponseEntity.ok(consulta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Consulta>> listarConsultas() {
        List<Consulta> consultas = consultaService.listarConsultas();
        return ResponseEntity.ok(consultas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Consulta> atualizarConsulta(@PathVariable UUID id, @RequestBody Consulta consulta) {
        Consulta atualizadaConsulta = consultaService.atualizarConsulta(consulta);
        if (atualizadaConsulta != null) {
            return ResponseEntity.ok(atualizadaConsulta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarConsulta(@PathVariable UUID id) {
        consultaService.deletarConsulta(id);
        return ResponseEntity.noContent().build();
    }
}
