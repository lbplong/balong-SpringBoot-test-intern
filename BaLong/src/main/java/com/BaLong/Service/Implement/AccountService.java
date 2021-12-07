package com.BaLong.Service.Implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BaLong.Converter.AccountConverter;
import com.BaLong.DTO.AccountDTO;
import com.BaLong.Service.IAccountService;
import com.BaLong.Entity.AccountEntity;
import com.BaLong.Entity.LikedEntity;
import com.BaLong.Entity.PostEntity;
import com.BaLong.Repository.AccountRepository;
import com.BaLong.Repository.LikedRepository;
import com.BaLong.Repository.PostRepository;

@Service
public class AccountService implements IAccountService {

	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private AccountConverter accountConverter;
	@Autowired
	private LikedRepository likedRepository;
	
	@Override
	public AccountDTO getLogin(String emailAddress, String password) {
		AccountEntity accountEntity = accountRepository.findByEmailAddressAndPassword(emailAddress, password);
		AccountDTO account = (accountEntity == null) ? null : accountConverter.toDTO(accountEntity);
		return account;
	}

	@Override
	public AccountDTO getAccountByUsername(String userNameFromJwtToken) {
		AccountEntity accountEntity = accountRepository.findByUsername(userNameFromJwtToken);
		AccountDTO account = (accountEntity == null) ? null : accountConverter.toDTO(accountEntity);
		return account;	
	}

	@Override
	public AccountDTO accountExit(String emailAddress) {
		AccountEntity accountEntity = accountRepository.findByEmailAddress(emailAddress);
		AccountDTO accountDTO = (accountEntity == null)? null: accountConverter.toDTO(accountEntity);
		return accountDTO;
	}

	@Override
	public AccountDTO registerNew(String fullName, String emailAddress, String username, String password) {
		AccountEntity newAccount = new AccountEntity();
		newAccount.setEmailAddress(emailAddress);
		newAccount.setFullName(fullName);
		newAccount.setPassword(password);
		newAccount.setUsername(username);
		AccountEntity accountEntity = accountRepository.save(newAccount);
		List<PostEntity> listPost = postRepository.findAll();
		for (int i = 0; i < listPost.size(); i++) {
			LikedEntity likedEntity = new LikedEntity();
			likedEntity.setAccountId(accountEntity);
			likedEntity.setPostId(listPost.get(i));
			likedEntity.setLiked(0);
			likedRepository.save(likedEntity);
		}
		return accountConverter.toDTO(accountEntity);
	}

}
