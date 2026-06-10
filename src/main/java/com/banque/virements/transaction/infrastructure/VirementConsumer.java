package com.banque.virements.transaction.infrastructure;

import com.banque.virements.transaction.domain.Virement;
import com.banque.virements.transaction.infrastructure.elasticsearch.VirementElasticsearchRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j

public class VirementConsumer {

    // TODO: réactiver quand Elasticsearch sera disponible (Docker)
    // private final VirementElasticsearchRepository virementElasticsearchRepository;

    // @KafkaListener(topics = "virements")
    // public void consumer(Virement virement){
    //     virementElasticsearchRepository.save(virement);
    //     log.info("Virement consumer sur Kafka : {}", virement.getId());
    // }
}
