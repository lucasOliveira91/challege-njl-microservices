package br.com.nlj.userregister.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long zip;
    private String numAccount;

    @Email
    private String email;

    @Column(name = "COD_AGENCY")
    private Long codAgency;

    @Column(name = "COD_BANK")
    private Long codBank;

    @Column(name = "DSC_BANK")
    private String descriptionBank;
}
