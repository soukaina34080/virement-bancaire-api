package com.banque.virements.transaction.application;

import com.banque.virements.shared.exception.VirementNotFoundException;
import com.banque.virements.transaction.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class VirementService {

    private final VirementRepository virementRepository;
    private final VirementEventPublisher eventPublisher;
    private final VirementIndexer indexer;

    @Transactional
    public Virement creerVirement(CreationVirementData data){

     Virement virement =  Virement.builder()
                .montant(data.montant())
                .devise(data.devise())
                .ibanEmetteur(data.ibanEmetteur())
                .ibanBeneficiaire(data.ibanBeneficiaire())
                .build();

     virement.valider();
     virement.setStatut(Statut.EN_ATTENTE);

     Virement saved = virementRepository.save(virement);
     eventPublisher.publierVirementCree(saved);
     return saved;

    }


    @Transactional(readOnly = true)
    public Virement getVirement(String id){
        return virementRepository.findById(id)
                .orElseThrow(() -> new VirementNotFoundException("Pas de virement trouvé pour cet id"));
    }


    @Transactional
    public void testTransactional(Virement virement) {
        virementRepository.save(virement);
        throw new RuntimeException("transaction");
    }

    @Transactional
    public Virement creerVirementInternational(CreationVirementInternationalData data) {

        VirementInternational virement = VirementInternational.builder()
                .montant(data.montant())
                .devise(data.devise())
                .ibanEmetteur(data.ibanEmetteur())
                .ibanBeneficiaire(data.ibanBeneficiaire())
                .deviseDestination(data.deviseDestination())
                .frais(data.frais())
                .statut(Statut.EN_ATTENTE)
                .build();

        virement.valider();
        virement.evaluerStatut();

        Virement saved = virementRepository.save(virement);
        eventPublisher.publierVirementCree(saved);
        return saved;
    }

}
