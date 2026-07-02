    package com.banque.virements.transaction.infrastructure.elasticsearch;

    import com.banque.virements.transaction.domain.Virement;
    import org.springframework.stereotype.Component;

    @Component
    public class VirementDocumentMapper {

        public VirementDocument toDocument(Virement virement) {
            VirementDocument doc = new VirementDocument();
            doc.setId(virement.getId());
            doc.setIbanEmetteur(virement.getIbanEmetteur());
            doc.setIbanBeneficiaire(virement.getIbanBeneficiaire());
            doc.setMontant(virement.getMontant());
           doc.setStatut(virement.getStatut() != null ? virement.getStatut().name() : null);
            return doc;
        }
    }