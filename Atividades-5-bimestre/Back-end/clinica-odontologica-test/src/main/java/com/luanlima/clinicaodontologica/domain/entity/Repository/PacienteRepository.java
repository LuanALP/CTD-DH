package com.luanlima.clinicaodontologica.domain.entity.Repository;


import com.luanlima.clinicaodontologica.domain.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, UUID> {
    // Você pode adicionar métodos de consulta personalizados aqui, se necessário
}