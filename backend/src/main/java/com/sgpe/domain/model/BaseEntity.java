package com.sgpe.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseEntity {

    private UUID id;

    private UUID tenantId;

    private LocalDateTime createdAt; // criado em

    private LocalDateTime updatedAt; // atualizado em
}

