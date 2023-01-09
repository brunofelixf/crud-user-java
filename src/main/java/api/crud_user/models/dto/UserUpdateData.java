package api.crud_user.models.dto;

import api.crud_user.models.adress.AddressData;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record UserUpdateData(
        @NotNull
        Long id,
        @Pattern(regexp = ".{3,50}")
        String name,
        @Past
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate birthday,
        @Valid
        AddressData address
) {

}
