package com.luanlima.clinicaodontologica.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.GenericGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Slf4j
@Table(name = "paciente")
public class Paciente {

    private static final Logger LOGGER = LoggerFactory.getLogger(Paciente.class);

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(length = 255)
    private String nome;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(length = 2)
    private String sexo;

    @OneToOne(cascade = CascadeType.ALL)
    private Contato contato;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;
    @Transient
    private Instant createdAt;
    @Transient
    private Instant updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = Instant.now();
        updatedAt = Instant.now();
        log.info("Novo paciente criado: {}", nome);
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now();
        log.info("Paciente atualizado: {}", nome);
    }
}
