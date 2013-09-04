package edu.kit.aifb.eorg.banking.wrapper.ws;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

@WebService(endpointInterface = "edu.kit.aifb.eorg.banking.wrapper.ws.BankingServiceInterface")
public class BankingServiceImpl implements BankingServiceInterface {

	@Override
	public TransactionTO[] getDebitsForAccount(
			@WebParam(name = "accountID") Long id) {

		// TODO Call RESTful service.

		String requestType = "debit";

		Client client = Client.create();
		WebResource webResource = client
				.resource("http://ec2-50-19-50-143.compute-1.amazonaws.com:9000/accounts/"
						+ id + "/" + requestType);

		String response = webResource.get(String.class);
		System.out.println(response);

		TransactionTO[] transactions = null;
		
		// TODO Transform JSON to TransactionTO
		ObjectMapper mapper = new ObjectMapper();
		try {
			transactions = mapper.readValue(response, TransactionTO[].class);
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 'src' can be File, InputStream, Reader, String 

		return transactions;
	}

	@Override
	public TransactionTO[] getCreditsForAccount(
			@WebParam(name = "accountID") Long id) {
		
		
		String requestType = "credit";

		Client client = Client.create();
		WebResource webResource = client
				.resource("http://ec2-50-19-50-143.compute-1.amazonaws.com:9000/accounts/"
						+ id + "/" + requestType);

		String response = webResource.get(String.class);
		System.out.println(response);

		// TODO Transform JSON to TransactionTO
		ObjectMapper mapper = new ObjectMapper();
		TransactionTO[] transactions = null; 
		try {
			transactions = mapper.readValue(response, TransactionTO[].class);
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 'src' can be File, InputStream, Reader, String 
		return transactions;
	}

}
