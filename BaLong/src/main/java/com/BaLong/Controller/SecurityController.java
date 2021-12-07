package com.BaLong.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BaLong.DTO.AccountDTO;
import com.BaLong.Service.IAccountService;
import com.BaLong.Jwt.JwtUtility;
import com.BaLong.Payload.Request.LoginRequest;
import com.BaLong.Payload.Request.RegisterRequest;
import com.BaLong.Payload.Response.JwtResponse;
import com.BaLong.Payload.Response.RegisterResponse;

@RestController
@RequestMapping("/api/public")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SecurityController {

	@Autowired
	private JwtUtility jwtUtility;
	@Autowired
	private IAccountService accountService;

	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		AccountDTO accountDTO = accountService.getLogin(loginRequest.getEmailAddress(), loginRequest.getPassword());
		StringBuilder jwt = new StringBuilder("");
		if (accountDTO != null) {
			jwt.append(jwtUtility.generaJwtToken(accountDTO.getUsername()));
			return new ResponseEntity<Object>(new JwtResponse(jwt.toString(), accountDTO.getId(),
					accountDTO.getEmailAddress(), accountDTO.getFullName()), HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/login")
	public String gettest() {
		return "success";
	}

	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest registerRequest) {
		AccountDTO accountDTO = accountService.accountExit(registerRequest.getEmailAddress());
		StringBuilder jwt = new StringBuilder("");
		if (accountDTO == null) {
			String emailAddress = registerRequest.getEmailAddress();
			String fullName = registerRequest.getFullName();
			String password = registerRequest.getPassword();
			String username = registerRequest.getUsername();
			accountDTO = accountService.registerNew(fullName, emailAddress,username, password);
			jwt.append(jwtUtility.generaJwtToken(accountDTO.getUsername()));
			return new ResponseEntity<Object>(new RegisterResponse(jwt.toString(), accountDTO.getId(),
					accountDTO.getEmailAddress(), accountDTO.getFullName(), ""), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Object>(new RegisterResponse(null, null, null, null, "Email already exists"),
					HttpStatus.CONFLICT);
		}

	}
}
