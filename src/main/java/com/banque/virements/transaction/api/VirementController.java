package com.banque.virements.transaction.api;

import com.banque.virements.transaction.application.VirementService;
import com.banque.virements.transaction.domain.Statut;
import com.banque.virements.transaction.domain.Virement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/virements")
public class VirementController {

    private final VirementService virementService;

//    public VirementController(VirementService virementService){
//        this.virementService = virementService;
//    }
//

    @PostMapping
    public ResponseEntity<VirementResponse> creationVirement(@RequestBody VirementRequest virementRequest){

        Virement virement = Virement.builder()
                .ibanEmetteur(virementRequest.ibanEmetteur())
                .ibanBeneficiaire(virementRequest.ibanBeneficiaire())
                .montant(virementRequest.montant())
                .devise(virementRequest.devise())
                .build();

        VirementResponse response = virementService.creerVirement(virement);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VirementResponse> getVirementById(@PathVariable String id){
        VirementResponse response = virementService.getVirement(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/search")
    public ResponseEntity<List<VirementResponse>> rechercheVirement(@RequestParam Statut statut){
        List<VirementResponse> response = virementService.rechercherVirements(statut);
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

}
