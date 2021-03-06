package edu.kit.aifb.eorg.banking.wrapper.ws;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import edu.kit.aifb.eorg.banking.wrapper.test.TestWsServer;

/**** DE - Remember to also change the DB  ***/
@WebService(
        name = "DEBankingPortType",
        portName = "DEBankingPort",
        serviceName = "DEBankingService",
        targetNamespace = "http://bank.de/DEbanking"
)   /* */
/*** CH - Remember to also change the DB ***
 @WebService(
     name = "SwissBankingPortType",
     portName = "SwissBankingPort",
     serviceName = "SwissBankingService",
     targetNamespace = "http://bank.ch/swissbanking"
 )                                    /**/
//public class BankingServiceImpl implements BankingServiceInterface {
public class BankingServiceImpl{

	@WebMethod
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

	@WebMethod
    public TransactionTO[] getCreditsForAccount(@WebParam(name="accountID") Long id)
    {
		
		
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

	@WebMethod
	public TransactionTO createTransaction(
            @WebParam(name="accountFromID") Long fromId,
            @WebParam(name="accountToID") Long toId,
            @WebParam(name="currency") String currency,
            @WebParam(name="category") String category,
            //@WebParam(name="status") String status,
            @WebParam(name="purpose") String purpose,
            @WebParam(name="value") BigDecimal value){

		TransactionTO result = null;
		
		try {
		purpose = URLEncoder.encode(purpose, "UTF-8");
		
		String status = "Processed";
		/** Comment if SwissBank **/
		if (Math.random()>0.8) status = "Error";
		String resource = "/transactions";
		String suffix ="/add";
	//	String params="?"+ "fromId="+ fromId + "&" + "toId=" + toId + "&" + "currency=\"" + currency + "\"&" + "category=\"" + category +"\"&" + "status=\"" + status + "\"&" + "purpose=\"" + purpose + "\"&" + "value=\"" + value + "\"";
		String params="?"+ "fromId="+ fromId + "&" + "toId=" + toId + "&" + "currency=" + currency + "&" + "category=" + category +"&" + "status=" + status + "&" + "purpose=" + purpose + "&" + "value=" + value + "";

		System.out.println(resource+suffix+params);
		
		Client client = Client.create();
		WebResource webResource = client
				.resource(TestWsServer.endpointJSON + resource + suffix + params);

		String response = webResource.post(String.class);
		System.out.println(response);

		ObjectMapper mapper = new ObjectMapper(); 
			result = mapper.readValue(response, TransactionTO.class);
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}


    @WebMethod
    public TransactionTO createTransactionWithDate(
            @WebParam(name="accountFromID") Long fromId,
            @WebParam(name="accountToID") Long toId,
            @WebParam(name="currency") String currency,
            @WebParam(name="category") String category,
            //@WebParam(name="status") String status,
            @WebParam(name="purpose") String purpose,
            @WebParam(name="value") BigDecimal value,
            @WebParam(name="date") String date){

        TransactionTO result = null;

        try {
            purpose = URLEncoder.encode(purpose, "UTF-8");

            String status = "Processed";
            String resource = "/transactions";
            String suffix ="/addWithDate";
            //	String params="?"+ "fromId="+ fromId + "&" + "toId=" + toId + "&" + "currency=\"" + currency + "\"&" + "category=\"" + category +"\"&" + "status=\"" + status + "\"&" + "purpose=\"" + purpose + "\"&" + "value=\"" + value + "\"";
            String params="?"+ "fromId="+ fromId + "&" + "toId=" + toId +
                    "&" + "currency=" + currency +
                    "&" + "category=" + category +
                    "&" + "status=" + status +
                    "&" + "purpose=" + purpose +
                    "&" + "value=" + value +
                    "&" + "date=" + date;

            System.out.println(resource+suffix+params);

            Client client = Client.create();
            WebResource webResource = client
                    .resource(TestWsServer.endpointJSON + resource + suffix + params);

            String response = webResource.post(String.class);
            System.out.println(response);

            ObjectMapper mapper = new ObjectMapper();
            result = mapper.readValue(response, TransactionTO.class);
        } catch ( IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

}
