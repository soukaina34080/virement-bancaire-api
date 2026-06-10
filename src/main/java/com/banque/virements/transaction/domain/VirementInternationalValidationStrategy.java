package com.banque.virements.transaction.domain;

public class VirementInternationalValidationStrategy implements ValidationStrategy {

    @Override
    public void valider(Transaction transaction) {
        VirementInternational virementInternational = (VirementInternational) transaction;
        virementInternational.valider();
    }
}
