package com.banque.virements.transaction.infrastructure.jpa;

import com.banque.virements.transaction.domain.Virement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VirementRepository extends JpaRepository<Virement, String> {

}
