package br.com.cursojunit.api.services;

import br.com.cursojunit.api.domain.User;

import java.util.List;

public interface UserService {

    User findById(Integer id);
    List<User> findAll();

}
