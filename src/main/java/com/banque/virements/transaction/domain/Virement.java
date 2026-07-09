package com.banque.virements.transaction.domain;

import com.banque.virements.shared.exception.SoldeInsuffisantException;
import com.banque.virements.shared.exception.TransactionInvalideException;
import com.banque.virements.shared.exception.SoldeSuperieurException;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Virement extends Transaction {

    private String ibanEmetteur;
    private String ibanBeneficiaire;

    @Override
    public void valider() {
        if (ibanEmetteur == null || ibanBeneficiaire == null) {
            throw new TransactionInvalideException("IBAN manquant");
        }
        if (this.getMontant().compareTo(BigDecimal.ZERO) <= 0) {
            throw new SoldeInsuffisantException("Compte emmeteur non approvisioné");
        }
    }

    @Override
    public void evaluerStatut() {
        if (this.getMontant().compareTo(BigDecimal.ZERO) >= 0){
            throw new SoldeSuperieurException("Virement trop important");
        }
    }
}
