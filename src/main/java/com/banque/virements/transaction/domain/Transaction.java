package com.banque.virements.transaction.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Data
@NoArgsConstructor // génère un constructeur sans paramètres
@SuperBuilder

public abstract class Transaction{

    private String id;
    private BigDecimal montant;
    private Devise devise;
    private Statut statut;

    public abstract void valider();
}
