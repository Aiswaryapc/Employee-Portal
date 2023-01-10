package com.axis.finalproject.controller;

import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.axis.finalproject.config.TokenManager;
import com.axis.finalproject.dto.employee.SignInDto;
import com.axis.finalproject.dto.employee.SignInResponseDto;
import com.axis.finalproject.service.JwtUserDetailsService;


@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TokenManager jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	//@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
//	@PostMapping("/auth")
//	public ResponseEntity<?> createAuthenticationToken(@RequestBody SignInDto authenticationRequest) throws Exception {
//
//		authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());
//
//		final UserDetails userDetails = userDetailsService
//				.loadUserByUsername(authenticationRequest.getEmail());
//
//		final String token = jwtTokenUtil.generateJwtToken(userDetails);
//
//		return ResponseEntity.ok(new SignInResponseDto(token));
//	}
	 @PostMapping("/auth")
	    public ResponseEntity<?> authenticateUser(@Valid @RequestBody SignInDto loginRequest) {

	        Authentication authentication = authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(
	                        loginRequest.getEmail(),
	                        loginRequest.getPassword()
	                )
	        );

	        SecurityContextHolder.getContext().setAuthentication(authentication);
	        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getEmail());

	        final String jwt = jwtTokenUtil.generateJwtToken(userDetails);

	        return ResponseEntity.ok(new SignInResponseDto(jwt));
	    }
	private void authenticate(String email, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}