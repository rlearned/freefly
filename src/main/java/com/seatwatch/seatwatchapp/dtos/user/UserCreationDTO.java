package com.seatwatch.seatwatchapp.dtos.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserCreationDTO {

    @NotBlank(message = "Username is mandatory")
    @Size(min = 3, max = 16, message = "Username must be between 3 and 16 characters long")
    private String username;

    @NotBlank(message = "Password is mandatory")
    @Size(min = 8, max = 50, message = "Password must be between 8 and 50 characters long")
    private String password;

    @NotBlank(message = "Email is mandatory")
    @Email
    private String email;

    private String phoneNumber;

    @NotBlank(message = "First name is mandatory")
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    private String lastName;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
