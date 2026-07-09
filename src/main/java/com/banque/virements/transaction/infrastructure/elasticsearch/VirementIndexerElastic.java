package com.banque.virements.transaction.infrastructure.elasticsearch;

import com.banque.virements.transaction.domain.Virement;
import com.banque.virements.transaction.domain.VirementIndexer;
import org.springframework.stereotype.Component;

@Component
public class VirementIndexerElastic implements VirementIndexer {

    private final VirementElasticRepository elasticRepository;
    private final VirementDocumentMapper mapper;

    public VirementIndexerElastic(VirementElasticRepository elasticRepository,
                                  VirementDocumentMapper mapper) {
        this.elasticRepository = elasticRepository;
        this.mapper = mapper;
    }

    @Override
    public void indexer(Virement virement) {
        VirementDocument document = mapper.toDocument(virement);
        elasticRepository.save(document);
    }
}