package com.mindtree.industry.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.industry.dto.AccountDto;
import com.mindtree.industry.dto.ProjectDto;
import com.mindtree.industry.entity.Account;
import com.mindtree.industry.entity.Ig;
import com.mindtree.industry.entity.Project;
import com.mindtree.industry.exception.NoSuchIgIdPresentException;
import com.mindtree.industry.exception.NoSuchInsertionAllowed;
import com.mindtree.industry.exception.ServiceException;
import com.mindtree.industry.repositary.AccountRepo;
import com.mindtree.industry.repositary.IgRepo;
import com.mindtree.industry.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	IgRepo igrepo;

	@Autowired
	AccountRepo accountRepo;

	private ModelMapper modelMapper = new ModelMapper();

	public AccountDto insertAccAndProject(AccountDto account) throws ServiceException {
		int costfinal = 0;
		Account accountentity = new Account();
		Project projectentity = new Project();
		List<Account> acclist = new ArrayList<>();
		List<Project> prolist = new ArrayList<>();

		accountentity.setAccID(account.getAccID());
		accountentity.setAacName(account.getAacName());
		// accountentity.setRevenue(account.getRevenue());

		acclist.add(accountentity);

		if (account.getProjectlist() != null) {
			for (ProjectDto p : account.getProjectlist()) {
				projectentity.setProjectId(p.getProjectId());
				projectentity.setProjectName(p.getProjectName());
				projectentity.setCost(p.getCost());
				prolist.add(projectentity);
				costfinal = p.getCost() + costfinal;

			}

			if (costfinal < 1000) {
				accountentity.setRevenue(costfinal);
				accountentity.setProjectlist(prolist);
				projectentity.setAccount(accountentity);
				accountRepo.save(accountentity);
			} else {
				try {
					throw new NoSuchInsertionAllowed("no such insertion allowed");

				} catch (NoSuchInsertionAllowed e) {
					throw new ServiceException(e.getMessage());
				}
			}
		}

		return modelMapper.map(accountentity, AccountDto.class);
	}

	public Account insertInto(int accID, int igId) throws ServiceException {

		try {
			Ig ig2=igrepo.findById(igId)
					.orElseThrow(()->new NoSuchIgIdPresentException("NO SUCH IG PRESENT"));
		} catch (NoSuchIgIdPresentException e)
		{
			throw new ServiceException(e.getMessage());
		}
		Ig ig1 = igrepo.findById(igId).get();
		Account account1 = accountRepo.findById(accID).get();
		account1.setIg(ig1);

		return accountRepo.save(account1);

	}

	@Override
	public List<Account> listAsc(int igId) {
		
		return null;
	}

	@Override
	public List<Account> getAccounts(int igId) {
	   Ig i=igrepo.findById(igId).get();
	   List<Account>acnts=i.getAccountList();
		return acnts;
	}

	
}
