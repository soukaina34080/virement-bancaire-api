package com.banque.virements.transaction.api;

import com.banque.virements.transaction.domain.Statut;

public record VirementResponse(String id, Statut statut) {
}
