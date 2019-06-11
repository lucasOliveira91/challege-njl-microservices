package br.com.nlj.userregister.service;

import br.com.nlj.userregister.domain.User;
import br.com.nlj.userregister.exception.UserExistsException;
import br.com.nlj.userregister.repository.UserRepository;
import br.com.nlj.userregister.resource.dto.UserRegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public void insert(User user) {
        findOneEmail(user.getEmail()).ifPresent(u -> {
            throw new UserExistsException();
        });
        userRepository.save(user);
    }

    private Optional<User> findOneEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void update(User user) {
        userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public User toEntity(UserRegisterDTO dto) {
        return new User(
                dto.getId(),
                dto.getName(),
                dto.getZip(),
                dto.getNumAccount(),
                dto.getEmail(),
                dto.getCodAgency(),
                dto.getCodBank(),
                dto.getDescriptionBank());
    }
}
