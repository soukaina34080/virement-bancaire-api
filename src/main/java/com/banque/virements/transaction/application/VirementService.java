package com.banque.virements.transaction.application;

import com.banque.virements.shared.exception.VirementNotFoundException;
import com.banque.virements.transaction.api.VirementResponse;
import com.banque.virements.transaction.domain.Statut;
import com.banque.virements.transaction.domain.Virement;
import com.banque.virements.transaction.infrastructure.elasticsearch.VirementElasticsearchRepository;
import com.banque.virements.transaction.infrastructure.VirementProducer;
import com.banque.virements.transaction.infrastructure.jpa.VirementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VirementService {

    private final VirementRepository virementRepository;
    private final VirementProducer virementProducer;
    //private final VirementElasticsearchRepository virementElasticsearchRepository;

    public VirementResponse creerVirement(Virement virement){
        virement.valider();
        virement.setStatut(Statut.EN_ATTENTE);
        virementRepository.save(virement);
        //virementProducer.publier(virement);

        VirementResponse virementResponse = new VirementResponse(virement.getId(), virement.getStatut());

        return virementResponse;
    }

    public VirementResponse getVirement(String id){
        Optional<Virement> virementTrouve = virementRepository.findById(id);
        if (virementTrouve.isEmpty()){
            throw new VirementNotFoundException("Pas de virement trouvé pour cette id");
        }
        Virement virement = virementTrouve.get();
        return new VirementResponse(virement.getId(), virement.getStatut());
    }

    public List<VirementResponse> rechercherVirements(Statut statut){
        //List<Virement> listVirement = virementElasticsearchRepository.findByStatut(statut);

//        List<VirementResponse> virementResponseList = listVirement.stream()
//                .map(v -> new VirementResponse(v.getId(), v.getStatut()))
//                .collect(Collectors.toList());

        return List.of();
    }

}
