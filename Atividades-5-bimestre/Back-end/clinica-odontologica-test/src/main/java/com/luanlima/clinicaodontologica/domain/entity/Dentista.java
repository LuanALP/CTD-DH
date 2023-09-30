package com.luanlima.clinicaodontologica.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.GenericGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.time.Instant;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Slf4j
@Table(name = "dentista")
public class Dentista {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(length = 255)
    private String nome;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(length = 80)
    private String especialidade;

    @Column(length = 2)
    private String sexo;

    @ManyToMany(mappedBy = "dentistasClinica")
    private Set<ClinicaOdontologica> clinicasOdontologicas;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contato_id")
    private Contato contato;


    @Transient
    private Instant createdAt;
    @Transient
    private Instant updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = Instant.now();
        updatedAt = Instant.now();
        log.info("Novo dentista criado: {}", nome);
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now();
        log.info("Dentista atualizado: {}", nome);
    }
}
