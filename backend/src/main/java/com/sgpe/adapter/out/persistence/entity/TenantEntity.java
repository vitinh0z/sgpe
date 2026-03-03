package com.sgpe.adapter.out.persistence.entity;

import com.sgpe.domain.enums.BusinessType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Table(name = "tenants")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TenantEntity {

    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.VERSION_7)
    private UUID id;

    @Column(name = "business_name", nullable = false)
    private String businessName;

    @Column(name = "cnpj", nullable = false, unique = true)
    private String cnpj;

    @Column(name = "business_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private BusinessType businessType;

    @Column(name = "active", nullable = false)
    private boolean active;

    @Column(name = "settings_json", columnDefinition = "TEXT")
    private String settingsJson;

}

