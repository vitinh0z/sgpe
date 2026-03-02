package com.sgpe.domain.model;

import com.sgpe.domain.enums.BusinessType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Tenant {

    private UUID id;

    private String businessName;

    private String cnpj;

    private BusinessType businessType;

    private boolean active;

    private String settingsJson;
}

