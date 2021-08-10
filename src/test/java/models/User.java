package models;

import lombok.Data;

@Data
public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String address;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String phone;

    public static class Builder {
        private User newUser;

        public Builder() {
            newUser = new User();
        }

        public Builder setFirstName(String firstName) {
            newUser.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            newUser.lastName = lastName;
            return this;
        }

        public Builder setEmail(String email) {
            newUser.email = email;
            return this;
        }

        public Builder setPassword(String password) {
            newUser.password = password;
            return this;
        }

        public Builder setAddress(String address) {
            newUser.address = address;
            return this;
        }

        public Builder setCity(String city) {
            newUser.city = city;
            return this;
        }

        public Builder setState(String state) {
            newUser.state = state;
            return this;
        }

        public Builder setPostalCode(String postalCode) {
            newUser.postalCode = postalCode;
            return this;
        }

        public Builder setCountry(String country) {
            newUser.country = country;
            return this;
        }

        public Builder setPhone(String phone) {
            newUser.phone = phone;
            return this;
        }

        public User build() {
            return newUser;
        }
    }
}
