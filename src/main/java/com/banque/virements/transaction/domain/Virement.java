package com.banque.virements.transaction.domain;

import com.banque.virements.shared.exception.SoldeInsuffisantException;
import com.banque.virements.shared.exception.TransactionInvalideException;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
//import org.springframework.data.elasticsearch.annotations.Document;

import java.math.BigDecimal;

@SuperBuilder
@Data
@Entity
@NoArgsConstructor
//@Document(indexName = "virements")
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
}
