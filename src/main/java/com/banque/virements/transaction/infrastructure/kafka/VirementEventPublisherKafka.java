package com.banque.virements.transaction.infrastructure.kafka;

import com.banque.virements.transaction.domain.Virement;
import com.banque.virements.transaction.domain.VirementEventPublisher;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class VirementEventPublisherKafka implements VirementEventPublisher {

    private static final String TOPIC = "virements-crees";

    private final KafkaTemplate<String, String> kafkaTemplate;

    public VirementEventPublisherKafka(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publierVirementCree(Virement virement) {
        String message = "Virement créé : id=%s, montant=%s, statut=%s"
                .formatted(virement.getId(), virement.getMontant(), virement.getStatut());

        kafkaTemplate.send(TOPIC, virement.getId(), message);
    }
}
