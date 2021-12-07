package com.BaLong.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.BaLong.Entity.AccountEntity;
import com.BaLong.Entity.LikedEntity;
import com.BaLong.Entity.PostEntity;

public interface LikedRepository extends JpaRepository<LikedEntity, Long> {
	public LikedEntity findByAccountIdAndPostId(AccountEntity accountId, PostEntity postId);

	@Transactional
	@Modifying
	@Query(value = "update liked as u set u.account_id = ?1 , u.post_id = ?2 , u.liked = ?3 where u.id = ?4 ;", nativeQuery = true)
	public void updateLikeModel(Long accountId, Long postId, Integer liked, Long id);
}
