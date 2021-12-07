package com.BaLong.Service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.BaLong.DTO.PostDTO;

public interface IPostService {

	List<PostDTO> getListPostByDatePageAndAmount(String date, Pageable pageable);

	Long getCountPostByDatePageAndAmount(String date);

	List<PostDTO> updatePostLike(Integer liked, Long id);

}
