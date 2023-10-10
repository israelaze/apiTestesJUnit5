package br.com.cursojunit.api.config;

import br.com.cursojunit.api.domain.Users;
import br.com.cursojunit.api.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;


/**
 * Classe de configuração do perfil de testes*/
@Configuration
@Profile("local")
@AllArgsConstructor
public class LocalConfig {

    private final UserRepository repository;

    @Bean
    public void startDB(){
        Users u1 = new Users(null, "Edy", "edy@bol.com", "1234");
        Users u2 = new Users(null, "Ana", "ana@bol.com", "1234");

        repository.saveAll(List.of(u1, u2));
    }
}
