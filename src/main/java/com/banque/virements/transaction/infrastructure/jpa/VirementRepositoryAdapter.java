package com.banque.virements.transaction.infrastructure.jpa;

import com.banque.virements.transaction.domain.Virement;
import com.banque.virements.transaction.domain.VirementRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class VirementRepositoryAdapter implements VirementRepository {

    private final VirementJpaRepository jpaRepository;
    private final VirementMapper mapper;

    public VirementRepositoryAdapter(VirementJpaRepository jpaRepository,
                                     VirementMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Virement save(Virement virement) {
        VirementEntity entity = mapper.toEntity(virement);
        VirementEntity saved = jpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Virement> findById(String id) {
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }
}