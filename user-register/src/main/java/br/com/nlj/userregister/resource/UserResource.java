package br.com.nlj.userregister.resource;

import br.com.nlj.userregister.resource.dto.UserDTO;
import br.com.nlj.userregister.resource.dto.UserRegisterDTO;
import br.com.nlj.userregister.resource.swagger.UserResourceSwagger;
import br.com.nlj.userregister.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserResource implements UserResourceSwagger {

    @Autowired
    private UserService service;

    @GetMapping
    @Override
    public ResponseEntity findAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable).map(entity -> new UserDTO(entity)));
    }

    @PostMapping
    @Override
    public void insert(@RequestBody UserRegisterDTO dto) {
        service.insert(service.toEntity(dto));
    }

    @PutMapping
    @Override
    public void update(@RequestBody UserRegisterDTO dto) {
        service.update(service.toEntity(dto));
    }

    @DeleteMapping("/{id}")
    @Override
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
