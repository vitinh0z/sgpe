package com.sgpe.domain.person.entity;

import com.sgpe.domain.constant.BaseEntity;
import com.sgpe.domain.constant.PersonType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.util.Map;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Person extends BaseEntity {

    private String name;

    private String cpf;

    private String email;

    private String phoneNumber;

    private String address;

    private PersonType personType;

    private Map<String, Object> metadata;

}
