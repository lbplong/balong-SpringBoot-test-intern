package com.BaLong.Service.Implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.BaLong.Converter.PostConverter;
import com.BaLong.DTO.PostDTO;
import com.BaLong.Entity.PostEntity;
import com.BaLong.Repository.PostRepository;
import com.BaLong.Service.IPostService;

@Service
public class PostService implements IPostService {

	@Autowired
	private PostRepository postRepository;
	@Autowired
	private PostConverter postConverter;

	@Override
	public List<PostDTO> getListPostByDatePageAndAmount(String date, Pageable pageable) {
		Page<PostEntity> pagePost = postRepository.findPosts(date, pageable);
		List<PostDTO> listItems = new ArrayList<PostDTO>();
		pagePost.forEach(post -> listItems.add(postConverter.toDTO(post)));
		return listItems;
	}

	@Override
	public Long getCountPostByDatePageAndAmount(String date) {
		return postRepository.findCountByDateUpload(date);
	}

	@Override
	public List<PostDTO> updatePostLike(Integer liked, Long id) {
		postRepository.updatePostLike(liked, id);
		List<PostDTO> listPostDTO = new ArrayList<PostDTO>();
		PostEntity postEntity = postRepository.getById(id);
		if (postEntity.getLiked() == liked) {
			listPostDTO.add(postConverter.toDTO(postEntity));
		}
		return listPostDTO;
	}
}
