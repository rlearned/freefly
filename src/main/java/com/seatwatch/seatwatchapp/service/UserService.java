package com.seatwatch.seatwatchapp.service;

import com.seatwatch.seatwatchapp.dtos.user.UserCreationDTO;
import com.seatwatch.seatwatchapp.dtos.user.UserDTO;
import com.seatwatch.seatwatchapp.dtos.user.UserUpdateDTO;
import com.seatwatch.seatwatchapp.model.User;
import com.seatwatch.seatwatchapp.repository.UserRepository;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


// TODO: Custom exceptions
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private UserDTO toUserDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        return dto;
    }

    private User toUserEntity(UserCreationDTO userCreationDTO) {
        User user = new User();
        user.setUsername(userCreationDTO.getUsername());
        user.setPassword(userCreationDTO.getPassword());
        user.setEmail(userCreationDTO.getEmail());
        user.setFirstName(userCreationDTO.getFirstName());
        user.setLastName(userCreationDTO.getLastName());
        if (userCreationDTO.getPhoneNumber() != null) {
            user.setPhoneNumber(userCreationDTO.getPhoneNumber());
        }
        return user;
    }

    public Optional<UserDTO> getUser(Long id) {
        return userRepository.findById(id)
                             .map(this::toUserDTO);
    }

    // TODO: Update this to use a stream
    public List<UserDTO> getAllUsers() {
        List<User> userList = userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user : userList) {
            userDTOList.add(toUserDTO(user));
        }
        return userDTOList;
    }

    public UserDTO createUser(UserCreationDTO userCreationDTO) {
        User user = toUserEntity(userCreationDTO);
        userRepository.save(user);
        return toUserDTO(user);
    }

//    public User updateUser(Long id, @Valid UserUpdateDTO userUpdateDTO) {
//
//    }

}
