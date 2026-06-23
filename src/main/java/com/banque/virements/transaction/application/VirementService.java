package com.banque.virements.transaction.application;

import com.banque.virements.shared.exception.VirementNotFoundException;
import com.banque.virements.transaction.domain.Statut;
import com.banque.virements.transaction.domain.Virement;
import com.banque.virements.transaction.domain.VirementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class VirementService {

    private final VirementRepository virementRepository;


    @Transactional
    public Virement creerVirement(Virement virement){
        virement.valider();
        virement.setStatut(Statut.EN_ATTENTE);
        return virementRepository.save(virement);
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

}
