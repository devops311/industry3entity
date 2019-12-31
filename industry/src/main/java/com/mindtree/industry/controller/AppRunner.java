package com.mindtree.industry.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.industry.dto.AccountDto;
import com.mindtree.industry.dto.IgDto;
import com.mindtree.industry.entity.Account;
import com.mindtree.industry.exception.IndustryException;
import com.mindtree.industry.exception.ServiceException;
import com.mindtree.industry.service.AccountService;
import com.mindtree.industry.service.IgService;
import com.mindtree.industry.service.ProjectService;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

@RestController
public class AppRunner {

	@Autowired
	AccountService accountService;

	@Autowired
	IgService igService;

	@Autowired
	ProjectService projectService;

	@PostMapping("/insertIg")
	public ResponseEntity<IgDto> insertIntoIg(@RequestBody IgDto ig) {
		IgDto ig1 = igService.insert(ig);

		return ResponseEntity.status(HttpStatus.OK).body(ig1);

	}

	@PostMapping("/insertAccountandProject")
	public ResponseEntity<AccountDto> insertAccount(@RequestBody AccountDto account) throws IndustryException {

		try {
			AccountDto accountDto = accountService.insertAccAndProject(account);

			return ResponseEntity.status(HttpStatus.OK).body(accountDto);
		} catch (ServiceException e) {
			throw new IndustryException(e.getMessage());
		}
	}

	@PostMapping("/addIgToAcc/{accID}/{igId}")
	public Account add(@PathVariable int accID, @PathVariable int igId) throws IndustryException {
		try {
			return accountService.insertInto(accID, igId);

		} catch (ServiceException e) {
			throw new IndustryException(e.getLocalizedMessage());
		}
	}

	@GetMapping("/sort/{igId}")
	public List<Account> list(@PathVariable int igId) {
		List<Account>accounts=accountService.getAccounts(igId);
        java.util.Collections.sort(accounts);
		return accounts;

	}
}