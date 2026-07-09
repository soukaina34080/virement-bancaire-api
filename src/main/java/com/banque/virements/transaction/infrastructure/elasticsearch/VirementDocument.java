package com.banque.virements.transaction.infrastructure.elasticsearch;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.math.BigDecimal;

@Data
@Document(indexName = "virements")
public class VirementDocument {
    @Id
    private String id;

    @Field(type = FieldType.Keyword)
    private String ibanEmetteur;

    @Field(type = FieldType.Keyword)
    private String ibanBeneficiaire;

    @Field(type = FieldType.Double)
    private BigDecimal montant;

    @Field(type = FieldType.Keyword)
    private String statut;
}