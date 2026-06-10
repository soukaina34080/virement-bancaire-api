package com.banque.virements.transaction.domain;

public interface ValidationStrategy {

    void valider(Transaction transaction);
}
