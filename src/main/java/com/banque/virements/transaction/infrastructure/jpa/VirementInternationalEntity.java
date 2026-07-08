package com.banque.virements.transaction.infrastructure.jpa;

import com.banque.virements.transaction.domain.Devise;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "virement_international")
public class VirementInternationalEntity extends VirementEntity {

    @Enumerated(EnumType.STRING)
    private Devise deviseDestination;

    private BigDecimal frais;
}