package edu.kit.aifb.eorg.banking.wrapper.test;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import edu.kit.aifb.eorg.banking.wrapper.ws.BankingServiceInterface;
import edu.kit.aifb.eorg.banking.wrapper.ws.TransactionTO;


public class TestWsClient {
	
	public static void main(String[] args) {
		String url = (args.length >0 ) ? args[0] : "http://localhost:4434/bankingservice";

		BankingServiceInterface bankingService ;
		Service service = null;
		try {
			service = service.create(		
					new URL ( url + "?wsdl"),
					new QName("http://ws.wrapper.banking.eorg.aifb.kit.edu/", "BankingServiceImplService"));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bankingService = service.getPort(BankingServiceInterface.class);
		
//		TransactionTO transTOResp = bankingService.getDebitsForAccount(5L);
//		System.out.println(transTOResp.toString());
	}
}
