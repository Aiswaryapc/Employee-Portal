package com.axis.finalproject.controller;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.finalproject.config.JwtUtils;
import com.axis.finalproject.dto.employee.SignInDto;
import com.axis.finalproject.dto.employee.SignInResponseDto;
import com.axis.finalproject.dto.employee.SignupDto;
import com.axis.finalproject.entity.ERole;
import com.axis.finalproject.entity.Employee;
import com.axis.finalproject.entity.Role;
import com.axis.finalproject.exceptions.CustomException;
import com.axis.finalproject.repository.EmployeeRepository;
import com.axis.finalproject.repository.RoleRepository;
import com.axis.finalproject.service.UserDetailsImpl;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.security.core.userdetails.UserDetailsService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	EmployeeRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;
	@Value("${app.jwtSecret}")
	private String jwtSecret;
	//@PreAuthorize("hasRole('ROLE_USER')")
//	@PostMapping("/signin")
//	public ResponseEntity<?> authenticateUser(@Valid @RequestBody SignInDto loginRequest ) throws Exception {
//
//		Authentication authentication = authenticationManager.authenticate(
//				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
//
//		SecurityContextHolder.getContext().setAuthentication(authentication);
//		String jwt = jwtUtils.generateJwtToken(authentication);
//		
//		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
//		List<String> roles = userDetails.getAuthorities().stream()
//				.map(item -> item.getAuthority())
//				.collect(Collectors.toList());
//
//		return ResponseEntity.ok(new SignInResponseDto(jwt,
//				userDetails.getEmpID(), 
//                userDetails.getName(), 
//                userDetails.getEmail(), 
//                roles));
//	}
	  @PostMapping("/token")
	  public ResponseEntity<String> getToken(@RequestBody SignInDto login) throws ServletException {
		  BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();  
		  
	        String jwttoken = "";
	        Employee emp = userRepository.findByemail(login.getEmail());
	        encoder.matches(login.getPassword(), emp.getPassword());  
	        if(login.getEmail().isEmpty() || login.getPassword().isEmpty())
	            return new ResponseEntity<String>("Email or password cannot be empty.", HttpStatus.BAD_REQUEST);
	 
	        String name = login.getEmail(), 
	                password = encoder.encode(login.getPassword());
	 
	      
	        if(!(login.getEmail().matches(emp.getEmail()) &&  encoder.matches(login.getPassword(), emp.getPassword())))
	            return new ResponseEntity<String>("Invalid credentials. Please check the Email and password.", HttpStatus.UNAUTHORIZED);
	        else {
	           
	            Map<String, Object> claims = new HashMap<String, Object>();
	            claims.put("usr", login.getEmail());
	            claims.put("sub", "Authentication token");
	            //claims.put("iss", Iconstants.ISSUER);
	            claims.put("rol", "Administrator, Developer");
	            claims.put("iat", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
	 
	            jwttoken = Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
	            System.out.println("Returning the following token to the user= "+ jwttoken);
	        }
	 
	        return new ResponseEntity<String>(jwttoken, HttpStatus.OK);
	    }

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupDto signUpRequest) {

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new CustomException("Error: Email is already in use!"));
		}

		// Create new user's account
		Employee emp = new Employee( 
				signUpRequest.getName(),
				signUpRequest.getGender(),
				signUpRequest.getAge(), 
				signUpRequest.getAddress(), 
				signUpRequest.getCity(),
				signUpRequest.getState(), 
				signUpRequest.getMobileNumber(), 
				signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()),
				signUpRequest.getSupervisor() );

		Set<String> strRoles = signUpRequest.getRoles();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				default:
					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}

		emp.setRoles(roles);
		userRepository.save(emp);
		return new ResponseEntity<String>("Employee created", HttpStatus.CREATED);

		
	}
}

