//package com.axis.finalproject.service;
//
//
//import java.util.Objects;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.axis.finalproject.entity.Admin;
//import com.axis.finalproject.entity.AuthenticationToken;
//import com.axis.finalproject.entity.Employee;
//import com.axis.finalproject.exceptions.AuthenticationFailException;
//import com.axis.finalproject.repository.TokenRepository;
//
//
//@Service
//public class AuthenticationService {
//
//    @Autowired
//    TokenRepository tokenRepository;
//
//    public void saveConfirmationToken(AuthenticationToken authenticationToken) {
//        tokenRepository.save(authenticationToken);
//    }
//
//    public AuthenticationToken getEToken(Employee employee) {
//        return tokenRepository.findByEmployee(employee);
//    }
//    public Employee getEmployee(String token) {
//        final AuthenticationToken authenticationToken = tokenRepository.findByToken(token);
//        if(Objects.isNull(authenticationToken)) {
//            return null;
//        }
//        // authenticationToken is not null
//        return authenticationToken.getEmployee();
//    }
//
//    public AuthenticationToken getAToken(Admin admin) {
//        return tokenRepository.findByAdmin(admin);
//    }
//    public Admin getAdmin(String token) {
//        final AuthenticationToken authenticationToken = tokenRepository.findByToken(token);
//        if(Objects.isNull(authenticationToken)) {
//            return null;
//        }
//        // authenticationToken is not null
//        return authenticationToken.getAdmin();
//    }
//
//    public void authenticate(String token) throws AuthenticationFailException {
//        // null check
//        if(Objects.isNull(token)) {
//            // throw an exception
//            throw new AuthenticationFailException("token not present");
//        }
//        if(Objects.isNull(getEmployee(token))) {
//            throw new AuthenticationFailException("token not valid");
//        }
//        if(Objects.isNull(getAdmin(token))) {
//            throw new AuthenticationFailException("token not valid");
//        }
//    }
//}