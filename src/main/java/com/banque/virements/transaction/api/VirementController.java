package com.banque.virements.transaction.api;

import com.banque.virements.transaction.application.VirementService;
import com.banque.virements.transaction.domain.Virement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/virements")
public class VirementController {

    private final VirementService virementService;


    @PostMapping
    public ResponseEntity<VirementResponse> creationVirement(@RequestBody VirementRequest virementRequest){

        Virement virement = Virement.builder()
                .ibanEmetteur(virementRequest.ibanEmetteur())
                .ibanBeneficiaire(virementRequest.ibanBeneficiaire())
                .montant(virementRequest.montant())
                .devise(virementRequest.devise())
                .build();

        Virement virementCree = virementService.creerVirement(virement);

        VirementResponse response = new VirementResponse(virementCree.getId(), virementCree.getStatut());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @GetMapping("/{id}")
    public ResponseEntity<VirementResponse> getVirementById(@PathVariable String id){
        Virement responseVirement = virementService.getVirement(id);
        VirementResponse response = new VirementResponse(responseVirement.getId(), responseVirement.getStatut());

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


}
