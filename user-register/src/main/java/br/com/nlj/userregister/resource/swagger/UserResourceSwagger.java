package br.com.nlj.userregister.resource.swagger;

import br.com.nlj.userregister.resource.dto.UserRegisterDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;


@Api(value = "Crud User")
public interface UserResourceSwagger {

     @ApiOperation(value = "Return a pageable list")
     ResponseEntity findAll(Pageable pageable);

     void insert(UserRegisterDTO dto);

     void update(UserRegisterDTO dto);

     void delete( Long id);

}
