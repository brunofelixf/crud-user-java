package api.crud_user.models.data;

import api.crud_user.models.adress.AddressData;

import java.time.LocalDate;

public record UserRegisterData(String name, LocalDate birthday, AddressData address) {}

