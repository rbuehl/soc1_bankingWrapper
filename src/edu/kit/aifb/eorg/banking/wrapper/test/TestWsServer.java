package edu.kit.aifb.eorg.banking.wrapper.test;

import javax.xml.ws.Endpoint;

import edu.kit.aifb.eorg.banking.wrapper.ws.BankingServiceImpl;

public class TestWsServer {
	
	public static String endpointJSON;
		
	public static void main(String[] args) {
		String url = (args.length >0 ) ? args[0] : "http://localhost:4435/bankingservice";
		endpointJSON = (args.length >1 ) ? args[1] : "http://localhost:9000";
		System.out.println("Starting with url: " + url);
		System.out.println("Connected endpointJSON: " + endpointJSON);
		Endpoint ep = Endpoint.publish(url, new BankingServiceImpl());
	}
}
