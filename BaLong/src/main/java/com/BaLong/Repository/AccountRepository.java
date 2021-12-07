package com.BaLong.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.BaLong.Entity.AccountEntity;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
	AccountEntity findByEmailAddressAndPassword(String emailAddress, String password);

	AccountEntity findByUsername(String userNameFromJwtToken);

	AccountEntity findByEmailAddress(String emailAddress);
}
