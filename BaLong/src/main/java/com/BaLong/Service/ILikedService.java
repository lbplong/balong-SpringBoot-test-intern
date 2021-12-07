package com.BaLong.Service;

import org.springframework.stereotype.Service;

import com.BaLong.DTO.LikedDTO;

@Service
public interface ILikedService {

	LikedDTO getLikeByAccountIdAndPostId(Long accountId, Long postId);

	LikedDTO updateLikeModel(Long accountId, Long postId, Integer liked,Long id);

}
