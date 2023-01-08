package api.crud_user.models.adress;

import jakarta.validation.constraints.*;


public record AddressData(

        //Utilizei validações por regex ou annotations apenas para exemplificar as duas formas de fazer

        @NotBlank( message = "O logradouro deve ter entre 5 e 100 caracteres" )
        @Pattern(regexp = ".{5,100}")
        String street,
        @NotBlank( message = "O CEP é obrigatório" )
        @Pattern(regexp = "\\d{8}")
        String zip,
        @NotBlank( message = "O número é obrigatório" )
        //@Pattern(regexp = "\\d{1,4}")
        @Size(min = 1, max = 4, message = "O número deve conter até 4 dígitos" )
        @Positive
        String number,
        @NotBlank( message = "O nome da cidade é obrigatório" )
        @Pattern(regexp = ".{3,30}")
        String city) {
}
