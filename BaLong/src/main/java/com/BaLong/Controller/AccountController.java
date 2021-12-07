package com.BaLong.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BaLong.DTO.AccountDTO;
import com.BaLong.Jwt.JwtUtility;
import com.BaLong.Payload.Response.AccountResponse;
import com.BaLong.Service.IAccountService;

@RestController
@RequestMapping("/api/account")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AccountController {
	@Autowired
	private JwtUtility jwtUtility;
	@Autowired
	private IAccountService accountService;

	@GetMapping("/token")
	public ResponseEntity<?> getUserByToken(@RequestHeader("token") String token) {
		if (jwtUtility.validateJwtToken(token)) {
			AccountDTO accountDTO = accountService.getAccountByUsername(jwtUtility.getUserNameFromJwtToken(token));
			if (accountDTO != null) {
				return new ResponseEntity<Object>(
						new AccountResponse(accountDTO.getId(), accountDTO.getUsername(), accountDTO.getFullName()),
						HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
			}
		} else {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
	}
}
