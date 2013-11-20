package edu.kit.aifb.eorg.banking.wrapper.ws;

import java.math.BigDecimal;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface BankingServiceInterface {
	
	TransactionTO[] getDebitsForAccount(@WebParam(name="accountID") Long id);
	TransactionTO[] getCreditsForAccount(@WebParam(name="accountID") Long id);
	TransactionTO createTransaction(
			@WebParam(name="accountFromID") Long fromId, 
			@WebParam(name="accountToID") Long toId,
			@WebParam(name="currency") String currency, 
			@WebParam(name="category") String category,
			//@WebParam(name="status") String status, 
			@WebParam(name="purpose") String purpose, 			
			@WebParam(name="value") BigDecimal value);
}
