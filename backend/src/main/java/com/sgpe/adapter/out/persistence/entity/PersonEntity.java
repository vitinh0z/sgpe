package com.sgpe.adapter.out.persistence.entity;

import com.sgpe.domain.constant.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;


@Entity
@Table(name = "persons")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersonEntity extends BaseEntity {


        @Id
        @GeneratedValue
        @UuidGenerator(style = UuidGenerator.Style.VERSION_7)
        private UUID id;

        private UUID tenantId;

        @Column(nullable = false)
        private String name;

        @Column(nullable = false, unique = true)
        private String cpf;

        @Column(nullable = false, unique = true)
        private String email;

    @Column(nullable = false, unique = true)

    private String phoneNumber;

    @Column(nullable = false, unique = true)

    private String address;

        private String personType;

        @Column(columnDefinition = "jsonb")
        private String metadataJson;
}
