package com.luanlima.clinicaodontologica.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.GenericGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Slf4j
@Table(name = "consulta")
public class Consulta {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "data_consulta")
    private LocalDateTime dataConsulta;

    @Column(length = 255)
    private String descricao;

    @Column(length = 255)
    private String motivoCancelamento;

    private Boolean cancelada;

    @OneToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "clinica_id")
    private ClinicaOdontologica clinica;

    @ManyToOne
    @JoinColumn(name = "dentista_id")
    private Dentista dentista;

    @Transient
    private Instant createdAt;
    @Transient
    private Instant updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = Instant.now();
        updatedAt = Instant.now();
        log.info("Nova consulta criada para o paciente: {}", paciente.getNome());
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now();
        log.info("Consulta atualizada para o paciente: {}", paciente.getNome());
    }
}
