package com.banque.virements.transaction.application;

import com.banque.virements.transaction.domain.Devise;
import com.banque.virements.transaction.domain.Statut;
import com.banque.virements.transaction.domain.Virement;
import com.banque.virements.transaction.domain.VirementRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VirementServiceTest {

    @InjectMocks
    VirementService service;

    @Mock
    VirementRepository virementRepository;

    @Test
    void shouldFindVirementById() {

        //ARRANGE

        Virement virement = new Virement();
        virement.setId("idTest");
        virement.setStatut(Statut.EN_ATTENTE);
        virement.setDevise(Devise.EUR);

        when(virementRepository.findById("idTest")).thenReturn(Optional.of(virement));

        //ACT ASSERT
        Virement virementRetour = service.getVirement("idTest");
        assertThat(virementRetour).isNotNull();
        assertThat(virementRetour.getId()).isEqualTo("idTest");
        assertThat(virementRetour.getDevise()).isEqualTo(Devise.EUR);
        assertThat(virementRetour.getStatut()).isEqualTo(Statut.EN_ATTENTE);

    }

    @ParameterizedTest
    @EnumSource(Devise.class)
    void shouldFindVirementByIdForEachDevise(Devise devise) {

        // ARRANGE
        Virement virement = new Virement();
        virement.setId("idTest");
        virement.setStatut(Statut.EN_ATTENTE);
        virement.setDevise(devise);

        when(virementRepository.findById("idTest")).thenReturn(Optional.of(virement));

        // ACT
        Virement virementRetour = service.getVirement("idTest");

        // ASSERT
        assertThat(virementRetour).isNotNull();
        assertThat(virementRetour.getId()).isEqualTo("idTest");
        assertThat(virementRetour.getDevise()).isEqualTo(devise);
        assertThat(virementRetour.getStatut()).isEqualTo(Statut.EN_ATTENTE);
    }

}