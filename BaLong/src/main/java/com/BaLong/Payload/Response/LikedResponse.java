package com.BaLong.Payload.Response;

import com.BaLong.DTO.LikedDTO;

public class LikedResponse {
	private LikedDTO likedDTO;
	public LikedResponse(LikedDTO likedDTO) {
		this.setLikedDTO(likedDTO);
	}
	public LikedDTO getLikedDTO() {
		return likedDTO;
	}
	public void setLikedDTO(LikedDTO likedDTO) {
		this.likedDTO = likedDTO;
	}
}
