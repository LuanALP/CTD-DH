package com.luanlima.clinicaodontologica.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.GenericGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.time.Instant;
import java.util.Set;
import java.util.UUID;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Slf4j
@Tag(name = "Clinica Odontológica API", description = "API com dados das clinicas odontologicas")
@Table(name = "clinicas_odontologicas")
public class ClinicaOdontologica {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(length = 255)
    private String nome;

    @Column(length = 20)
    private String cnpj;

    @Column(length = 255)
    private String razaoSocial;

    @Column(length = 255)
    private String descricao;


    @ManyToMany
    @JoinTable(name="clinica_odontologica_dentista_id",
            joinColumns = @JoinColumn(name = "clinica_odontologica_id"),
            inverseJoinColumns = @JoinColumn(name = "id_dentista")
    )
    private Set<Dentista> dentistasClinica;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

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
        log.info("Nova clínica criada: {}", nome);
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now();
        log.info("Clínica atualizada: {}", nome);
    }
}
