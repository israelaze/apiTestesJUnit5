package br.com.cursojunit.api.services.impl;

import br.com.cursojunit.api.domain.User;
import br.com.cursojunit.api.repositories.UserRepository;
import br.com.cursojunit.api.services.UserService;
import br.com.cursojunit.api.services.exceptions.ObjectNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    @Override
    public User findById(Integer id) {

        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado."));
    }
}
