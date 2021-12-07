package com.BaLong.Repository;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.BaLong.Entity.PostEntity;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
	@Query(value = "SELECT * FROM post as u WHERE u.date_upload = ?1", nativeQuery = true)
	Page<PostEntity> findPosts(String date, Pageable pageable);

	@Query(value = "SELECT COUNT(*) FROM post as u WHERE u.date_upload= ?1", nativeQuery = true)
	Long findCountByDateUpload(String date);

	@Transactional
	@Modifying
	@Query(value = "update post as u set u.liked = ?1 where u.id = ?2 ;", nativeQuery = true)
	void updatePostLike(Integer liked, Long id);

}
