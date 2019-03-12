package com.wipro.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wipro.bank.bean.Account;
import com.wipro.bank.service.AccountService;

@Controller
public class AccountController {
	
	@Autowired
	private AccountService acctService;

    @RequestMapping(value="/NewCustomerRequest",  method = RequestMethod.POST)
    public String createApplication(@ModelAttribute("account") Account account, Model model)
    {
    	System.out.println(account);
    	String addStatus = acctService.addAccount(account);
    	model.addAttribute("status", addStatus);
    	
    	return "GeneralResponse";
    }
    
    @RequestMapping(value="/AccountInfoById")
    public String getAccountDetailsByAccountId(@RequestParam("accountID") int accountId, Model model)
    {

    	Account accountDetails = acctService.getBalanceOf(accountId);
    	model.addAttribute("account", accountDetails);
    	
    	return "accountDetailsByIdPage";
    }
    
    @RequestMapping(value="/FundTransferRequest")
    public String fundTransferRequest(@RequestParam("fromAccountID") int fromAccountID,
    		@RequestParam("toAccountID") int toAccountID, @RequestParam("balance") double amount, Model model) {
    	
    	String transferResult = acctService.transferFunds(fromAccountID, toAccountID, amount);
    	model.addAttribute("transferResult", transferResult);
    	
    	return "fundTransferResultPage";
    }
    
    @RequestMapping(value="/AllAccountAndCustomersDetails")
    public String findAllAccountsDetails(Model model) {
    	
    	List<Account> accountsDetails = acctService.findAllAccountsDeatils();
    	model.addAttribute("accounts", accountsDetails);
    	
    	return "allAccountsDetailsPage";
    }
    
}
