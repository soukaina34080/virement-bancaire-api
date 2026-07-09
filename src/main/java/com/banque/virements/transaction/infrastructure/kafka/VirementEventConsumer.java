package com.banque.virements.transaction.infrastructure.kafka;

import com.banque.virements.shared.exception.VirementNotFoundException;
import com.banque.virements.transaction.domain.Virement;
import com.banque.virements.transaction.domain.VirementIndexer;
import com.banque.virements.transaction.domain.VirementRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class VirementEventConsumer {

    private final VirementIndexer indexer;
    private final VirementRepository virementRepository;

    @KafkaListener(topics = "virements-crees", groupId = "virements-group")
    public void consommerVirementCree(String virementId) {
        log.info("Message reçu depuis Kafka : {}", virementId);
        Virement virement = virementRepository.findById(virementId)
                .orElseThrow(() -> new VirementNotFoundException("Virement introuvable : " + virementId));
        indexer.indexer(virement);
    }
}
