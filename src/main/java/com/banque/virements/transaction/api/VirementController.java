package com.banque.virements.transaction.api;

import com.banque.virements.transaction.application.CreationVirementData;
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

        CreationVirementData data = new CreationVirementData(
                virementRequest.ibanEmetteur(),
                virementRequest.ibanBeneficiaire(),
                virementRequest.montant(),
                virementRequest.devise()
        );

        Virement virementCree = virementService.creerVirement(data);

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
