package com.banque.virements.transaction.application;

import com.banque.virements.transaction.domain.Devise;
import com.banque.virements.transaction.domain.Statut;
import com.banque.virements.transaction.domain.Virement;
import com.banque.virements.transaction.infrastructure.jpa.VirementJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@SpringBootTest
class VirementServiceIntegrationTest {

    @Autowired
    VirementService service;

    @Autowired
    VirementJpaRepository repository;

    @Test
    void shouldThrowExceptionTransactional() {
        //Arrange
        Virement virement = Virement.builder()
                .montant(new BigDecimal("100"))
                .devise(Devise.EUR)
                .ibanEmetteur("FR76123456789")
                .ibanBeneficiaire("FR76123456789")
                .build();

        //Act assert
        assertThatThrownBy(() -> service.testTransactional(virement))
                .isInstanceOf(RuntimeException.class);
        assertThat(repository.count()).isEqualTo(0);

    }
}