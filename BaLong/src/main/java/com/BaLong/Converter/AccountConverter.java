package com.BaLong.Converter;

import org.springframework.stereotype.Component;

import com.BaLong.DTO.AccountDTO;
import com.BaLong.Entity.AccountEntity;

@Component
public class AccountConverter {
	
	public AccountEntity toEntity(AccountDTO rs) {
		AccountEntity accountEntity = new AccountEntity();
		accountEntity.setId(rs.getId());
		accountEntity.setFullName(rs.getFullName());
		accountEntity.setEmailAddress(rs.getEmailAddress());
		accountEntity.setUsername(rs.getUsername());
		accountEntity.setPassword(rs.getPassword());
		return accountEntity;
	}

	public AccountDTO toDTO(AccountEntity rs) {
		AccountDTO accountDTO = new AccountDTO();
		if (rs.getId() != null) {
			accountDTO.setId(rs.getId());
		}
		accountDTO.setFullName(rs.getFullName());
		accountDTO.setEmailAddress(rs.getEmailAddress());
		accountDTO.setUsername(rs.getUsername());
		accountDTO.setPassword(rs.getPassword());
		return accountDTO;

	}

}
