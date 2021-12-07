package com.BaLong.Service;

import com.BaLong.DTO.AccountDTO;

public interface IAccountService {

	AccountDTO getLogin(String username, String password);

	AccountDTO getAccountByUsername(String userNameFromJwtToken);

	AccountDTO accountExit(String emailAddress);

	AccountDTO registerNew(String fullName, String emailAddress, String username, String password);

}
