package com.axis.finalproject.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.axis.finalproject.dto.employee.SignInDto;
import com.axis.finalproject.dto.employee.SignInResponseDto;
import com.axis.finalproject.dto.employee.SignupDto;

import com.axis.finalproject.entity.Employee;
import com.axis.finalproject.exceptions.AuthenticationFailException;
import com.axis.finalproject.exceptions.CustomException;
import com.axis.finalproject.repository.EmployeeRepository;



import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import javax.transaction.Transactional;
import javax.xml.bind.DatatypeConverter;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

//    @Autowired
//    AuthenticationService authenticationService;
    


    @Transactional
    public ResponseEntity<String> signUp(SignupDto signupDto) {
        // check if user is already present
        if (Objects.nonNull(employeeRepository.findByEmail(signupDto.getEmail()))) {
            // we have an user
            throw new CustomException("user already present");
        }


        // hash the password

        String encryptedpassword = signupDto.getPassword();

        try {
            encryptedpassword = hashPassword(signupDto.getPassword());
        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
        }

        Employee emp = new Employee(signupDto.getName(), signupDto.getGender(),signupDto.getAge(),
        		signupDto.getAddress(),signupDto.getCity(),signupDto.getState(),signupDto.getMobileNumber(),
                signupDto.getEmail(), encryptedpassword, signupDto.getSupervisor());

       employeeRepository.save(emp);

        // save the user

        // create the token

//        final AuthenticationToken authenticationToken = new AuthenticationToken(emp);
//
//        authenticationService.saveConfirmationToken(authenticationToken);
        

        
        
        return  new ResponseEntity<String>("user created succesfully",HttpStatus.CREATED);
    }

    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String hash = DatatypeConverter
                .printHexBinary(digest).toUpperCase();
        return hash;
    }

    public SignInResponseDto signIn(SignInDto signInDto) {
        // find user by email

       Employee emp = employeeRepository.findByEmail(signInDto.getEmail());

        if (Objects.isNull(emp)) {
            throw new AuthenticationFailException("user is not valid");
        }

        // hash the password

        try {
            if (!emp.getPassword().equals(hashPassword(signInDto.getPassword()))) {
                throw new AuthenticationFailException("wrong password");
            }
        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
        }

        // compare the password in DB

        // if password match

//        AuthenticationToken token = authenticationService.getEToken(emp);
//
//        // retrive the token
//
//        if (Objects.isNull(token)) {
//            throw new CustomException("token is not present");
//        }
//
//        return new SignInResponseDto("sucess", token.getToken());
        return new SignInResponseDto("sucess");
        // return response
    }
}