package com.banque.virements.transaction.infrastructure.kafka;

import com.banque.virements.transaction.domain.Virement;
import com.banque.virements.transaction.domain.VirementEventPublisher;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class VirementKafkaPublisher implements VirementEventPublisher {

    private static final String TOPIC = "virements-crees";

    private final KafkaTemplate<String, String> kafkaTemplate;

    public VirementKafkaPublisher(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publierVirementCree(Virement virement) {
        kafkaTemplate.send(TOPIC, virement.getId(), virement.getId());
    }
}
