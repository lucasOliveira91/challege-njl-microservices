package br.com.nlj.userregister.resource.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterDTO {

    private Long id;
    private String name;
    private Long zip;
    private String numAccount;
    private String email;
    private Long codAgency;
    private Long codBank;
    private String descriptionBank;
}
