package com.banque.virements.transaction.domain;

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
public class VirementInternational extends Virement{

    private Devise deviseDestination;
    private BigDecimal frais;

    @Override
    public void valider() {
        if(this.getFrais().compareTo(BigDecimal.ZERO) <= 0){
            throw new TransactionInvalideException("frais nulle ou négatif");
        }
        if (deviseDestination == null) {
            throw new TransactionInvalideException("Devise destination manquante");
        }
    }

    @Override
    public void evaluerStatut() {
        if (this.getMontant().compareTo(BigDecimal.ZERO) >= 0){
            throw new SoldeSuperieurException("Virement trop important");
        }
    }
}
