package com.wipro.bank.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wipro.bank.bean.Account;
import com.wipro.bank.dao.AccountDao;


@Component
public class AccountService {
	
	@Autowired
	private AccountDao accountDao;
	
	
	
	public String addAccount(Account acct)
	{
		Account account=accountDao.save(acct);
		if(account!=null)
		{
			return "Success";
		}
		else{
			return "Failed";
		}
	}
	
	public String transferFunds(int from,int to,double amount)
	{
		Account fromAccountDetails =getBalanceOf(from);
		Account toAccountDetails= getBalanceOf(to);
		if(fromAccountDetails==null)
		{
			return "From Account Does not Exist";
		}
		if(toAccountDetails==null)
		{
			return "To Account Does not Exist";
		}
		
		if(fromAccountDetails.getBalance()<amount)
		{
			return "insufficeint balance";
		}
		
		accountDao.updateFromAccount(amount, from);
		accountDao.updateToAccount(amount, to);
		
		return "Fund Transferred Successfully";
			 
	}
	
	public List<Account> findAllAccountsDeatils()
	{
		Iterable<Account> iterable= accountDao.findAll();
        List<Account> accounts =new ArrayList<Account>();
        for(Account account: iterable)
        {
            accounts.add(account);
        }
        return accounts;
	}
	
	public Account getBalanceOf(int accountNumber)
	{
		Account account = getAccountDetailsById(accountNumber);
		return account;
	}
	
	public Account getAccountDetailsById(int accountNumber){
		Account account = accountDao.findByAccountID(accountNumber);
		return account;
	}
}
