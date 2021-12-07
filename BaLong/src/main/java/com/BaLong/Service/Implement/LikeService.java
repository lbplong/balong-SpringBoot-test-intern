package com.BaLong.Service.Implement;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BaLong.Converter.LikedConverter;
import com.BaLong.DTO.LikedDTO;
import com.BaLong.Entity.AccountEntity;
import com.BaLong.Entity.LikedEntity;
import com.BaLong.Entity.PostEntity;
import com.BaLong.Repository.AccountRepository;
import com.BaLong.Repository.LikedRepository;
import com.BaLong.Repository.PostRepository;
import com.BaLong.Service.ILikedService;

@Service
public class LikeService implements ILikedService {
	@Autowired
	private LikedRepository likedRepository;
	@Autowired
	private LikedConverter likedConverter;
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private PostRepository postRepository;

	@Override
	public LikedDTO getLikeByAccountIdAndPostId(Long accountId, Long postId) {
		Optional<AccountEntity> account = accountRepository.findById(accountId);
		Optional<PostEntity> post = postRepository.findById(postId);
		LikedEntity likedEntity = likedRepository.findByAccountIdAndPostId(account.get(), post.get());

		return likedConverter.toDTO(likedEntity);
	}

	@Override
	public LikedDTO updateLikeModel(Long accountId, Long postId, Integer liked, Long id) {
		likedRepository.updateLikeModel(accountId, postId, liked, id);
		LikedEntity afterUpdate = likedRepository.getById(id);
		return (afterUpdate.getLiked() == liked) ? likedConverter.toDTO(afterUpdate) : null;
	}

}
