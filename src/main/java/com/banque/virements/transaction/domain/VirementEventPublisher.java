package com.banque.virements.transaction.domain;

public interface VirementEventPublisher {
    void publierVirementCree(Virement virement);
}
