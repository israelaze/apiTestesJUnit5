package br.com.cursojunit.api.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private Integer id;
    private String name;
    private String email;

    //Acesso somente para escrita.Impede a leitura
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
}
