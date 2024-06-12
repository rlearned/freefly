package com.seatwatch.seatwatchapp.controller;

import com.seatwatch.seatwatchapp.dtos.user.UserCreationDTO;
import com.seatwatch.seatwatchapp.dtos.user.UserDTO;
import com.seatwatch.seatwatchapp.dtos.user.UserUpdateDTO;
import com.seatwatch.seatwatchapp.model.User;
import com.seatwatch.seatwatchapp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Gets the user corresponding to a given id
     * @param id    The id of the user to retrieve
     * @return      The user object if found, or a 404 Not Found response if not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id) {
        Optional<UserDTO> userDTO = userService.getUser(id);
        if (userDTO.isPresent()) {
            return ResponseEntity.ok().body(userDTO.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/all")
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * Creates a new user from the given user information
     * @param userCreationDTO   New user information
     * @return                  HTTP: 200 and the user object if valid creation, otherwise error
     */
    @PostMapping()
    public ResponseEntity<?> createUser(@Valid @RequestBody UserCreationDTO userCreationDTO) {
        try {
            UserDTO userDTO = userService.createUser(userCreationDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(userCreationDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<?> updateUser(@PathVariable Long id,
//                                        @Valid @RequestBody UserUpdateDTO userUpdateDTO) {
//
//    }

}
