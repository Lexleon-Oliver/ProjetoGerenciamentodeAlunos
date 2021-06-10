package com.development.studentapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    private Long registration;

    @NotEmpty
    @Size(min = 2,max = 50)
    private String firstName;

    @NotEmpty
    @Size(min = 2,max = 50)
    private String lastName;

    @NotEmpty
    @CPF
    private String cpf;

    @NotEmpty
    private String birthDate;

    @NotEmpty
    @Size(min = 2,max = 100)
    private String course;

    @Valid
    @NotEmpty
    private List<PhoneDTO> phones;
}
