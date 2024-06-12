package com.seatwatch.seatwatchapp.dtos.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserUpdateDTO {

    @NotBlank(message = "Password is mandatory")
    @Size(min = 8, max = 50, message = "Password must be between 8 and 50 characters long")
    private String password;

    @NotBlank(message = "Email is mandatory")
    @Email
    private String email;

    private String phoneNumber;

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
}
