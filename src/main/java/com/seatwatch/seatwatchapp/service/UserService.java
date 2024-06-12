package com.seatwatch.seatwatchapp.service;

import com.seatwatch.seatwatchapp.dtos.user.UserCreationDTO;
import com.seatwatch.seatwatchapp.dtos.user.UserDTO;
import com.seatwatch.seatwatchapp.dtos.user.UserUpdateDTO;
import com.seatwatch.seatwatchapp.model.User;
import com.seatwatch.seatwatchapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
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
        if (userRepository.existsByEmail(userCreationDTO.getEmail())) {
            throw new IllegalStateException("Email already in use");
        }
        if (userRepository.existsByUsername(userCreationDTO.getUsername())) {
            throw new IllegalStateException("Username already in use");
        }
        User user = toUserEntity(userCreationDTO);
        userRepository.save(user);
        return toUserDTO(user);
    }

    public UserDTO updateUser(Long id, UserUpdateDTO userUpdateDTO) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setPassword(userUpdateDTO.getPassword());
            user.setEmail(userUpdateDTO.getEmail());
            if (userUpdateDTO.getPhoneNumber() != null) {
                user.setPhoneNumber(userUpdateDTO.getPhoneNumber());
            }
            userRepository.save(user);
            return toUserDTO(user);
        }
        throw new NoSuchElementException("User not found");
    }

    public void deleteUser(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new NoSuchElementException("User not found");
        }
    }

}
