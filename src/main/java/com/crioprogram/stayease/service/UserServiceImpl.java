package com.crioprogram.stayease.service;

import com.crioprogram.stayease.dto.ResponseDTO;
import com.crioprogram.stayease.dto.UserDTO;
import com.crioprogram.stayease.model.User;
import com.crioprogram.stayease.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public ResponseDTO userRegistration(UserDTO userDTO) {
        try {
            String encodedPassword = passwordEncoder.encode(userDTO.getPassword());
            User user = new User(userDTO.getFirstName(), userDTO.getLastName(), userDTO.getEmailId(),
                    encodedPassword, userDTO.getRole());
            User savedUser = userRepository.save(user);
            return new ResponseDTO(HttpStatus.CREATED, savedUser, "User Registered Successfully.");
        }
        catch (DataIntegrityViolationException e) {
            return new ResponseDTO(HttpStatus.BAD_REQUEST, e.getMostSpecificCause().getMessage(), "Data Validation Error");
        }
        catch (Exception exception){
            return new ResponseDTO(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(),
                    "Something went wrong in service");
        }
    }

    @Override
    public ResponseDTO userLogin(UserDTO userDTO) {
        try {
            User userByEmailId = userRepository.findByEmailId(userDTO.getEmailId());
            if (userByEmailId == null){
                return new ResponseDTO(HttpStatus.BAD_REQUEST, null, "Email Id is not registered");
            }
            if (!passwordEncoder.matches(userDTO.getPassword(), userByEmailId.getPassword())){
                return new ResponseDTO(HttpStatus.BAD_REQUEST, null, "Incorrect Password");
            }
            return new ResponseDTO(HttpStatus.ACCEPTED, userByEmailId, "User Logged In Successful");
        }
        catch (Exception exception){
            return new ResponseDTO(HttpStatus.INTERNAL_SERVER_ERROR, exception.getLocalizedMessage(),
                    "Something went wrong in service");
        }
    }
}
