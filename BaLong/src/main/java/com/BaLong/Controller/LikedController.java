package com.BaLong.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BaLong.DTO.LikedDTO;
import com.BaLong.Jwt.JwtUtility;
import com.BaLong.Payload.Request.LikedRequest;
import com.BaLong.Payload.Response.LikedResponse;
import com.BaLong.Service.ILikedService;

@RestController
@RequestMapping("/api/liked")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LikedController {
	@Autowired
	private JwtUtility jwtUtility;
	@Autowired
	private ILikedService likedService;

	@GetMapping("/model")
	public ResponseEntity<?> getLikedModel(@RequestHeader("token") String token,
			@RequestHeader("accountId") Long accountId, @RequestHeader("postId") Long postId) {
		if (jwtUtility.validateJwtToken(token)) {
			LikedDTO likeModel = likedService.getLikeByAccountIdAndPostId(accountId, postId);
			return new ResponseEntity<Object>(new LikedResponse(likeModel), HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/add-like")
	public ResponseEntity<?> updateLikeModel(@RequestBody LikedRequest likedRequest,
			@RequestParam("id") Long id) {
		if (jwtUtility.validateJwtToken(likedRequest.getToken())) {
			Long postId = likedRequest.getPostId();
			Integer liked = likedRequest.getLiked();
			Long accountId = likedRequest.getAccountId();
			LikedDTO likeModel = likedService.updateLikeModel(accountId, postId, liked, id);
			return new ResponseEntity<Object>(new LikedResponse(likeModel),HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
}
