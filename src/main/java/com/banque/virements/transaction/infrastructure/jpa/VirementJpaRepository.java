package com.banque.virements.transaction.infrastructure.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VirementJpaRepository extends JpaRepository<VirementEntity, String> {

}
