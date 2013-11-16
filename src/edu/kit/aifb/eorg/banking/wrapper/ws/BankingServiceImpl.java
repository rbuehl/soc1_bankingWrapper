package edu.kit.aifb.eorg.banking.wrapper.ws;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import edu.kit.aifb.eorg.banking.wrapper.test.TestWsServer;

@WebService(endpointInterface = "edu.kit.aifb.eorg.banking.wrapper.ws.BankingServiceInterface")
public class BankingServiceImpl implements BankingServiceInterface {

	@Override
	public TransactionTO[] getDebitsForAccount(
			@WebParam(name = "accountID") Long id) {

		// TODO Call RESTful service.

		String resource = "/accounts/";
		String suffix ="/debit";

		Client client = Client.create();
		WebResource webResource = client
//				.resource("http://ec2-54-221-106-18.compute-1.amazonaws.com:9000/"
				.resource(TestWsServer.endpointJSON + resource + 
						+ id + suffix);

		String response = webResource.get(String.class);
//		System.out.println(response);

		TransactionTO[] transactions = null;
		
		// TODO Transform JSON to TransactionTO
		ObjectMapper mapper = new ObjectMapper();
//        mapper.setSerializationInclusion(JsonInclude.Include.NON_DEFAULT)
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
		
		
		String resource = "/accounts/";
		String suffix ="/credit";

		Client client = Client.create();
		WebResource webResource = client
//				.resource("http://ec2-54-221-106-18.compute-1.amazonaws.com:9000/"
				.resource(TestWsServer.endpointJSON + resource + 
						+ id + suffix);

		String response = webResource.get(String.class);
//		System.out.println(response);

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

	@Override
	public String createTransaction(Long fromId, Long toId, String currency,
			String category, String status, String purpose, BigDecimal value) {
		String result = null;
		
		String resource = "/transactions";
		String suffix ="/add";
	//	String params="?"+ "fromId="+ fromId + "&" + "toId=" + toId + "&" + "currency=\"" + currency + "\"&" + "category=\"" + category +"\"&" + "status=\"" + status + "\"&" + "purpose=\"" + purpose + "\"&" + "value=\"" + value + "\"";
		String params="?"+ "fromId="+ fromId + "&" + "toId=" + toId + "&" + "currency=" + currency + "&" + "category=" + category +"&" + "status=" + status + "&" + "purpose=" + purpose + "&" + "value=" + value + "";
		System.out.println(resource+suffix+params);
		
		Client client = Client.create();
		WebResource webResource = client
				.resource(TestWsServer.endpointJSON + resource + suffix + params);

		String response = webResource.get(String.class);
		System.out.println(response);

		// TODO Transform JSON to TransactionTO
		ObjectMapper mapper = new ObjectMapper(); 
		try {
			result = mapper.readValue(response, String.class);
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
