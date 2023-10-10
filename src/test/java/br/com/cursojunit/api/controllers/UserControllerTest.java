package br.com.cursojunit.api.controllers;

import br.com.cursojunit.api.domain.Users;
import br.com.cursojunit.api.domain.dto.UserDTO;
import br.com.cursojunit.api.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class UserControllerTest {

    private static final Integer ID = 1;
    private static final String NAME = "Ana";
    private static final String EMAIL = "ana@bol.com";
    private static final String PASSWORD = "1234";

    @InjectMocks
    private UserController controller;

    @Mock
    private ModelMapper mapper;

    @Mock
    private UserService service;

    private Users user;
    private UserDTO userDTO;

    @BeforeEach
    void setUp() {
        // inicia os mocks desta classe
        MockitoAnnotations.openMocks(this);

        //inicia os valores
        startUser();
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    private void startUser(){
        user = new Users(ID, NAME, EMAIL, PASSWORD);
        userDTO = new UserDTO(ID, NAME, EMAIL, PASSWORD);
    }
}