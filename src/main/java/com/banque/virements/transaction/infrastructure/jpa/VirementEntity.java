package com.banque.virements.transaction.infrastructure.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@NoArgsConstructor
@Entity
@Table(name = "virement")
public class VirementEntity extends TransactionEntity {

    private String ibanEmetteur;
    private String ibanBeneficiaire;
}