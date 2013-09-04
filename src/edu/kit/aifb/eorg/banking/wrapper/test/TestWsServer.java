package edu.kit.aifb.eorg.banking.wrapper.test;

import javax.swing.JOptionPane;
import javax.xml.ws.Endpoint;

import edu.kit.aifb.eorg.banking.wrapper.ws.BankingServiceImpl;

public class TestWsServer {
	
	public static void main(String[] args) {
		String url = (args.length >0 ) ? args[0] : "http://localhost:4434/bankingservice";
		Endpoint ep = Endpoint.publish(url, new BankingServiceImpl());
	}
}
