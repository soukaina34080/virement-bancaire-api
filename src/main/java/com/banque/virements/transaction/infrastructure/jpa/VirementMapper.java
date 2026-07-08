package com.banque.virements.transaction.infrastructure.jpa;

import com.banque.virements.transaction.domain.Virement;
import com.banque.virements.transaction.domain.VirementInternational;
import org.springframework.stereotype.Component;

@Component
public class VirementMapper {

    public VirementEntity toEntity(Virement domain) {
        if (domain instanceof VirementInternational international) {
            return VirementInternationalEntity.builder()
                    .id(international.getId())
                    .montant(international.getMontant())
                    .devise(international.getDevise())
                    .statut(international.getStatut())
                    .ibanEmetteur(international.getIbanEmetteur())
                    .ibanBeneficiaire(international.getIbanBeneficiaire())
                    .deviseDestination(international.getDeviseDestination())
                    .frais(international.getFrais())
                    .build();
        }

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
        if (entity instanceof VirementInternationalEntity internationalEntity) {
            return VirementInternational.builder()
                    .id(internationalEntity.getId())
                    .montant(internationalEntity.getMontant())
                    .devise(internationalEntity.getDevise())
                    .statut(internationalEntity.getStatut())
                    .ibanEmetteur(internationalEntity.getIbanEmetteur())
                    .ibanBeneficiaire(internationalEntity.getIbanBeneficiaire())
                    .deviseDestination(internationalEntity.getDeviseDestination())
                    .frais(internationalEntity.getFrais())
                    .build();
        }

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