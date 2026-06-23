package com.banque.virements.transaction.domain;

import java.util.Optional;

public interface VirementRepository {

    Virement save(Virement virement);
    Optional<Virement> findById(String id);
}
