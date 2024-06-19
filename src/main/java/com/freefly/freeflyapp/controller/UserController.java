package com.freefly.freeflyapp.controller;

import com.freefly.freeflyapp.dtos.user.UserDTO;
import com.freefly.freeflyapp.dtos.user.UserCreationDTO;
import com.freefly.freeflyapp.dtos.user.UserUpdateDTO;
import com.freefly.freeflyapp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
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

    // TODO: Should figure out how to catch MethodArgNotValid Exception
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
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(userCreationDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // TODO: Should figure out how to catch MethodArgNotValid Exception
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id,
                                        @Valid @RequestBody UserUpdateDTO userUpdateDTO) {
        try {
            UserDTO userDTO = userService.updateUser(id, userUpdateDTO);
            return ResponseEntity.ok().body(userDTO);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(userUpdateDTO);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
