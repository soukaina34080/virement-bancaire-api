package com.banque.virements.transaction.infrastructure;

import com.banque.virements.transaction.domain.Virement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class VirementProducer {
    private final KafkaTemplate<String, Virement> kafkaTemplate;

    public void publier(Virement virement){
        kafkaTemplate.send("virements", virement);
        log.info("Virement publié sur Kafka : {}", virement.getId());
    }
}
