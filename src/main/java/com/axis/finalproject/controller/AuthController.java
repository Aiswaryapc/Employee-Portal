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
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.authority.mapping.Attributes2GrantedAuthoritiesMapper;
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
import com.axis.finalproject.exceptions.AuthenticationFailException;
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
	@PostMapping("/signin")
	
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody SignInDto loginRequest ) throws Exception {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(jwt);
	}
	
	  @PostMapping("/token")
	  public SignInResponseDto getToken(@RequestBody SignInDto login) throws ServletException {
		  BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(); 
		  Employee emp= userRepository.findByemail(login.getEmail());
		  Set<Role> role=emp.getRoles() ;
		  ERole name=ERole.ROLE_USER;
		  for (Role ro: role) {   
	         name=  ro.getName();
	            };
	        String jwttoken = "";
	        Employee employee = userRepository.findByemail(login.getEmail());
	        System.out.println(employee);
	        encoder.matches(login.getPassword(), employee.getPassword());  
	        
	        if(login.getEmail().isEmpty() || login.getPassword().isEmpty())
	        	throw new AuthenticationFailException("Email or password cannot be empty.");
	 
	        if(!(login.getEmail().matches(employee.getEmail()) &&  encoder.matches(login.getPassword(), employee.getPassword())))
	        	throw new AuthenticationFailException("Invalid credentials. Please check the Email and password.");
	        else {
	           
	            Map<String, Object> claims = new HashMap<String, Object>();
	            claims.put("usr", login.getEmail());
	            claims.put("sub", "Authentication token");
	            //claims.put("iss", Iconstants.ISSUER);
	            claims.put("rol", name);
	            claims.put("iat", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
	 
	            jwttoken = Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
	            System.out.println("Returning the following token to the user= "+ jwttoken);
	        }
	        
	        return new SignInResponseDto(jwttoken,employee.getEmpID(),employee.getName(),employee.getEmail(),employee.getRoles());
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
				signUpRequest.getSupervisor()
				
				);

		Set<String> strRoles = signUpRequest.getRoles();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new CustomException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "ROLE_ADMIN":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new CustomException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				case "ROLE_MANAGER":
					Role managerRole = roleRepository.findByName(ERole.ROLE_MANAGER)
							.orElseThrow(() -> new CustomException("Error: Role is not found."));
					roles.add(managerRole);

					break;
				default:
					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new CustomException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}

		emp.setRoles(roles);
		userRepository.save(emp);
		return new ResponseEntity<String>("Employee created", HttpStatus.CREATED);

		
	}
}

