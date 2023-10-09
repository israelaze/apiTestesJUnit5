package br.com.cursojunit.api.services;

import br.com.cursojunit.api.domain.User;

public interface UserService {

    User findById(Integer id);
}
