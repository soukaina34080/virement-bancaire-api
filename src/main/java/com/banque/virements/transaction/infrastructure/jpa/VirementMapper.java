package com.banque.virements.transaction.infrastructure.jpa;

import com.banque.virements.transaction.domain.Virement;
import org.springframework.stereotype.Component;

@Component
public class VirementMapper {
    public VirementEntity toEntity(Virement domain) {
        return VirementEntity.builder()
                .id(domain.getId())
                .montant(domain.getMontant())
                .devise(domain.getDevise())
                .statut(domain.getStatut())
                .ibanEmetteur(domain.getIbanEmetteur())
                .ibanBeneficiaire(domain.getIbanBeneficiaire())
                .build();
    }

    public Virement toDomain(VirementEntity entity) {
        return Virement.builder()
                .id(entity.getId())
                .montant(entity.getMontant())
                .devise(entity.getDevise())
                .statut(entity.getStatut())
                .ibanEmetteur(entity.getIbanEmetteur())
                .ibanBeneficiaire(entity.getIbanBeneficiaire())
                .build();
    }

}
