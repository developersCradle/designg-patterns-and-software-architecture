package org.java.builder;

import java.time.LocalDate;
import java.time.Period;

//The concrete builder for UserWebDTO
public class UserWebDTOBuilder implements UserDTOBuilder {

    private String firstName;
    private String lastName;
    private String age; /// Age of our user.
    private String address; // We will store address here.

    private UserWebDTO dto;

    public UserWebDTOBuilder() {
    }

    public UserWebDTOBuilder(String firstName, String lastName, String age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
        public UserDTOBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;

        }

        @Override
        public UserDTOBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        @Override
        public UserDTOBuilder withBirthday(LocalDate date) {

            // Only years will be calculated.
            Period ageInYears = Period.between(date, LocalDate.now());
            age = Integer.toString(ageInYears.getYears());

            return this;
        }

        @Override
        public UserDTOBuilder withAddress(Address address) {
            // Build String Address from the Address Object!

            StringBuilder localAddress = new StringBuilder()
                    .append(address.getHouseNumber() + ", ")
                    .append(address.getStreet())
                    .append(System.lineSeparator())
                    .append(address.getCity())
                    .append(System.lineSeparator())
                    .append(address.getState() + " " )
                    .append(address.getZipcode());
            this.address =  localAddress.toString();

            return this;
        }

        @Override
        public UserDTO build() {
        // We are building the UserDTO Object!
            dto  = new UserWebDTO(firstName + " " + lastName, address, age);
            return dto;
        }

        @Override
        public UserDTO getUserDTO() {
            return dto;
        }
}
