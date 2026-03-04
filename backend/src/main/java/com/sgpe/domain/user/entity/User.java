package com.sgpe.domain.user.entity;

import com.sgpe.domain.constant.BaseEntity;
import com.sgpe.domain.constant.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User extends BaseEntity {

    private UUID id;

    private UUID tenantId;

    private String name;

    private String email;

    private String passwordHash;

    private String telephone;

    private UserRole role;

    private boolean active = true;
}