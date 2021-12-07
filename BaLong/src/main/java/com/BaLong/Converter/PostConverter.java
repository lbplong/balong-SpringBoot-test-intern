package com.BaLong.Converter;

import org.springframework.stereotype.Component;

import com.BaLong.DTO.PostDTO;
import com.BaLong.Entity.PostEntity;

@Component
public class PostConverter {
	public PostDTO toDTO(PostEntity rs) {
		PostDTO postDTO = new PostDTO();
		postDTO.setId(rs.getId());
		postDTO.setTitle(rs.getTitle());
		postDTO.setDateUpLoad(rs.getDateUpload());
		postDTO.setVideo(rs.getVideo());
		postDTO.setLiked(rs.getLiked());
		return postDTO;
	}
}
