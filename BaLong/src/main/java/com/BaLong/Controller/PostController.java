package com.BaLong.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

import com.BaLong.DTO.PostDTO;
import com.BaLong.Jwt.JwtUtility;
import com.BaLong.Payload.Request.PostRequest;
import com.BaLong.Payload.Response.PostResponse;
import com.BaLong.Service.IPostService;

@RestController
@RequestMapping("/api/post")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostController {
	@Autowired
	private JwtUtility jwtUtility;
	@Autowired
	private IPostService postService;

	@GetMapping(value = "/list")
	public ResponseEntity<?> getListPostByDatePageAndAmount(@RequestHeader("token") String token,
			@RequestHeader(name = "dateS", required = false) String date,
			@RequestHeader(name = "page", required = false, defaultValue = "0") Integer page,
			@RequestHeader(name = "amount", required = false, defaultValue = "5") Integer amount,
			@RequestHeader(name = "sort", required = false, defaultValue = "DESC") String sort) {
		
		if (jwtUtility.validateJwtToken(token)) {
			
			Sort sortable = null;
			if (sort.equals("ASC")) {
				sortable = Sort.by("id").ascending();
			}
			if (sort.equals("DESC")) {
				sortable = Sort.by("id").descending();
			}
			Pageable pageable = PageRequest.of(page, amount, sortable);
			List<PostDTO> listItems = postService.getListPostByDatePageAndAmount(date, pageable);

			return new ResponseEntity<Object>(new PostResponse(date, page, amount, listItems), HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}

	}
	
	@GetMapping(value="/count")
	public ResponseEntity<?> getCountPostByDatePageAndAmount(@RequestHeader("token") String token,
			@RequestHeader("dateS") String date){
		if (jwtUtility.validateJwtToken(token)) {
			Long totalPage = postService.getCountPostByDatePageAndAmount(date);
			return new ResponseEntity<Object>( totalPage, HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping(value="/update-like")
	public ResponseEntity<?> updatePostLike(@RequestBody PostRequest postRequest, @RequestParam("id") Long id){
		if(jwtUtility.validateJwtToken(postRequest.getToken())) {
			List<PostDTO> listItems = postService.updatePostLike(postRequest.getLiked(), id);
			return new ResponseEntity<Object>(new PostResponse("", 0, 0, listItems),HttpStatus.OK);
		}else {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
		
	}
}
