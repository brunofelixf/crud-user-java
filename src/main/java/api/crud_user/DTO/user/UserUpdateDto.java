package api.crud_user.DTO.user;

import api.crud_user.DTO.adress.AddressRegisterDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record UserUpdateDto(
        @NotNull
        Long id,
        @Pattern(regexp = ".{3,50}")
        String name,
        @Past
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate birthday,
        @Valid
        AddressRegisterDto address
) {

}
