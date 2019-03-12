package com.wipro.bank.dao;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.bank.bean.Account;


@Repository
public interface AccountDao extends CrudRepository<Account,Integer>{
	
	
	
	public Iterable<Account> findAll();
	public Account save(Account act);
	public Account findByAccountID(int accid);
	
	@Modifying
	@Query(value = "UPDATE ACCOUNT SET BALANCE = BALANCE-?1 WHERE ACCOUNTID = ?2", nativeQuery = true)
	@Transactional
	public void updateFromAccount(double amount,int accountId);
	
	@Modifying
	@Query(value = "UPDATE ACCOUNT SET BALANCE = BALANCE+?1 WHERE ACCOUNTID = ?2", nativeQuery = true)
	@Transactional
	public void updateToAccount(double amount,int accountId);


}
