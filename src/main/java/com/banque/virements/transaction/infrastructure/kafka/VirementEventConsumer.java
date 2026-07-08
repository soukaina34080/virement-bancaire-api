//package com.banque.virements.transaction.infrastructure.kafka;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Component;
//
//@Slf4j
//@Component
//public class VirementEventConsumer {
//
//    @KafkaListener(topics = "virements-crees", groupId = "virements-group")
//    public void consommerVirementCree(String message) {
//        log.info("Message reçu depuis Kafka : {}", message);
//    }
//}
