package br.com.cursojunit.api.services.impl;

import br.com.cursojunit.api.domain.Users;
import br.com.cursojunit.api.domain.dto.UserDTO;
import br.com.cursojunit.api.repositories.UserRepository;
import br.com.cursojunit.api.services.UserService;
import br.com.cursojunit.api.services.exceptions.DataIntegrityViolationException;
import br.com.cursojunit.api.services.exceptions.ObjectNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private ModelMapper mapper;
    private UserRepository repository;
    @Override
    public Users findById(Integer id) {

        Optional<Users> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado."));
    }

    public List<Users> findAll(){
        return repository.findAll();
    }

    @Override
    public Users create(UserDTO obj) {
        findByEmail(obj);
        return repository.save(mapper.map(obj, Users.class));
    }

    @Override
    public Users update(UserDTO obj) {

        findByEmail(obj);
        return repository.save(mapper.map(obj, Users.class));
    }

    @Override
    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }

    private void findByEmail(UserDTO obj){
        Optional<Users> user = repository.findByEmail(obj.getEmail());

        if(user.isPresent() && !user.get().getId().equals(obj.getId())){
            throw new DataIntegrityViolationException("Email já cadastrado no sistema.");
        }
    }

}
