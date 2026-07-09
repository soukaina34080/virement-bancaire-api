package com.banque.virements.transaction.application;

import com.banque.virements.transaction.domain.Devise;

import java.math.BigDecimal;

public record CreationVirementData(
    String ibanEmetteur,
    String ibanBeneficiaire,
    BigDecimal montant,
    Devise devise
    ) {}
