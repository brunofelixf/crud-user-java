package api.crud_user.dto.user;

import api.crud_user.dto.adress.AddressData;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record UserRegisterData(

        @NotBlank( message = "O nome é obrigatório" )
        @Pattern(regexp = ".{3,50}")
        String name,
        @NotNull( message = "O aniversário deve estar no formato xx/xx/xxxx" )
        @Past
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate birthday,
        @NotNull
        @Valid
        AddressData address
) {}

