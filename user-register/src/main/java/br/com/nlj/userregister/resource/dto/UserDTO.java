package br.com.nlj.userregister.resource.dto;

import br.com.nlj.userregister.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {

    private Long id;
    private String name;
    private String email;

    public UserDTO(User entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.email = entity.getEmail();
    }
}
