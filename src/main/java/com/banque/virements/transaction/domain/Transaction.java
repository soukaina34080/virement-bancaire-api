package com.banque.virements.transaction.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Data
@NoArgsConstructor // génère un constructeur sans paramètres
@Entity
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Transaction implements Validable{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private BigDecimal montant;
    private Devise devise;
    private Statut statut;

    public abstract void valider();
}
