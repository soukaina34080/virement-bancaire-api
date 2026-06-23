package com.banque.virements.transaction.infrastructure.jpa;

import com.banque.virements.transaction.domain.Devise;
import com.banque.virements.transaction.domain.Statut;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "transaction")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private BigDecimal montant;

    @Enumerated(EnumType.STRING)
    private Devise devise;

    @Enumerated(EnumType.STRING)
    private Statut statut;
}