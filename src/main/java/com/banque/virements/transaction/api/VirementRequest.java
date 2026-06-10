package com.banque.virements.transaction.api;

import com.banque.virements.transaction.domain.Devise;

import java.math.BigDecimal;

public record VirementRequest(String ibanEmetteur, String ibanBeneficiaire, BigDecimal montant, Devise devise) {
}
