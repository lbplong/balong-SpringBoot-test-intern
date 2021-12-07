package com.BaLong.Converter;

import org.springframework.stereotype.Component;

import com.BaLong.DTO.LikedDTO;
import com.BaLong.Entity.LikedEntity;

@Component
public class LikedConverter {
	
	public LikedDTO toDTO(LikedEntity rs) {
		LikedDTO likedDTO = new LikedDTO();
		likedDTO.setId(rs.getId());
		likedDTO.setAccountId(rs.getAccountId().getId());
		likedDTO.setPostId(rs.getPostId().getId());
		likedDTO.setLiked(rs.getLiked());
		return likedDTO;
	}
}
