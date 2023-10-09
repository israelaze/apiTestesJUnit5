package br.com.cursojunit.api.services.impl;

import br.com.cursojunit.api.domain.User;
import br.com.cursojunit.api.domain.dto.UserDTO;
import br.com.cursojunit.api.repositories.UserRepository;
import br.com.cursojunit.api.services.UserService;
import br.com.cursojunit.api.services.exceptions.DataIntegratyViolationException;
import br.com.cursojunit.api.services.exceptions.ObjectNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final ModelMapper mapper;
    private final UserRepository repository;
    @Override
    public User findById(Integer id) {

        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado."));
    }

    public List<User> findAll(){
        return repository.findAll();
    }

    @Override
    public User create(UserDTO obj) {
        findByEmail(obj);
        return repository.save(mapper.map(obj, User.class));
    }

    @Override
    public User update(UserDTO obj) {

        findByEmail(obj);
        return repository.save(mapper.map(obj, User.class));
    }

    private void findByEmail(UserDTO obj){
        Optional<User> user = repository.findByEmail(obj.getEmail());

        if(user.isPresent() && !user.get().getId().equals(obj.getId())){
            throw new DataIntegratyViolationException("Email já cadastrado no sistema.");
        }
    }

}
