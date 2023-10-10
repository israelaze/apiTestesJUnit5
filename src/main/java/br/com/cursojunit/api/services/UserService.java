package br.com.cursojunit.api.services;

import br.com.cursojunit.api.domain.Users;
import br.com.cursojunit.api.domain.dto.UserDTO;

import java.util.List;

public interface UserService {

    Users findById(Integer id);
    List<Users> findAll();
    Users create(UserDTO obj);
    Users update(UserDTO obj);
    void delete(Integer id);

}
