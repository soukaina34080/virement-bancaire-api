package com.banque.virements.transaction.infrastructure.elasticsearch;

import com.banque.virements.transaction.domain.Statut;
import com.banque.virements.transaction.domain.Virement;
//import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VirementElasticsearchRepository   {
    List<Virement> findByStatut(Statut statut);
}
