package com.wipro.bank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestController {
	
	@RequestMapping("/")
    public String home()
    {
        return "home";
    }
    
    
    @RequestMapping("/CreateNewAccountForm")
    public String createApplication()
    {
    	return "CreateNewAccountForm";
    }
    
    @RequestMapping("/getAccountBalance")
    public String getAccountDetilsById()
    {
    	return "getAccountBalance";
    }
    
    @RequestMapping("/FundTransferForm")
    public String fundTransfer()
    {
    	return "TransferFunds";
    }
    
    @RequestMapping("/DisplayAccountsDetailsForm")
    public String accountsDeatils()
    {
    	return "DisplayAccountsORCustomers";
    }


}
