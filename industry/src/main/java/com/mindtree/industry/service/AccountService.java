package com.mindtree.industry.service;

import java.util.List;

import com.mindtree.industry.dto.AccountDto;
import com.mindtree.industry.entity.Account;
import com.mindtree.industry.exception.ServiceException;

public interface AccountService {

	AccountDto insertAccAndProject(AccountDto account) throws ServiceException;

	Account insertInto(int accID, int igId) throws ServiceException;

	List<Account> listAsc(int igId);

	List<Account> getAccounts(int igId);

	
}
