package edu.kit.aifb.eorg.banking.wrapper.ws;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface BankingServiceInterface {
	
	TransactionTO[] getDebitsForAccount(@WebParam(name="accountID") Long id);
	TransactionTO[] getCreditsForAccount(@WebParam(name="accountID") Long id);
}
