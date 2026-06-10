package com.banque.virements.transaction.domain;

import com.banque.virements.shared.exception.TransactionInvalideException;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@SuperBuilder
@Data
@Entity
@NoArgsConstructor
public class VirementInternational extends Virement{

    private Devise deviseDestination;
    private BigDecimal frais;

    @Override
    public void valider() {
        super.valider();
        if(this.getFrais().compareTo(BigDecimal.ZERO) <= 0){
            throw new TransactionInvalideException("frais nulle ou négatif");
        }
        if (deviseDestination == null) {
            throw new TransactionInvalideException("Devise destination manquante");
        }
    }
}
