package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    String firstName;
    String lastName;
    String email;
    String password;
    String address;
    String city;
    String state;
    String postalCode;
    String country;
    String phone;
}
