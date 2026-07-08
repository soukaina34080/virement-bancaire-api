//package com.banque.virements.transaction.infrastructure.elasticsearch;

//import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

//import java.math.BigDecimal;
//import java.util.List;

//public interface VirementElasticRepository
//        extends ElasticsearchRepository<VirementDocument, String> {

//    List<VirementDocument> findByIbanEmetteur(String ibanEmetteur);

//   List<VirementDocument> findByMontantGreaterThan(BigDecimal montant);
//}