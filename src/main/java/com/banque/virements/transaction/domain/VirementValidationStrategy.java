package com.banque.virements.transaction.domain;

public class VirementValidationStrategy implements ValidationStrategy {

    @Override
    public void valider(Transaction transaction) {
        Virement virement = (Virement) transaction;
        virement.valider();
    }
}
