package org.java.builder;

import java.time.LocalDate;

//The concrete builder for UserWebDTO
public class UserWebDTOBuilder implements UserDTOBuilder {


    @Override
    public UserDTOBuilder withFirstName(String firstName) {
        return null;
    }

    @Override
    public UserDTOBuilder withLastName(String lastName) {
        return null;
    }

    @Override
    public UserDTOBuilder withBirthday(LocalDate date) {
        return null;
    }

    @Override
    public UserDTOBuilder withAddress(Address address) {
        return null;
    }

    @Override
    public UserDTO build() {
        return null;
    }

    @Override
    public UserDTO getUserDTO() {
        return null;
    }
}
