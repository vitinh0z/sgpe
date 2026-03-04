package com.sgpe.domain.user.entity;

import com.sgpe.domain.constant.BaseEntity;
import com.sgpe.domain.constant.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User extends BaseEntity {

    private String name;

    private String email;

    private String passwordHash;

    private String telephone;

    private UserRole role;

    private boolean active = true;
}