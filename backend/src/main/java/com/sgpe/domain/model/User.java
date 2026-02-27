package com.sgpe.domain.model;

import com.sgpe.domain.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User extends BaseEntity {

    private String username;

    private String passwordHash;

    private String email;

    private UserRole role;

    private Boolean enabled;

}

