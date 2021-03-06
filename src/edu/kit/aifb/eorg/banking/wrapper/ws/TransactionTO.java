package edu.kit.aifb.eorg.banking.wrapper.ws;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionTO {
	
	public Long id;
	public AccountTO accountFrom;
	public AccountTO accountTo;
	public String purpose;
	public Date date;
	public BigDecimal value;	//TODO:Format to 2 Decimals
	public Currency currency;
    
	public String category;
    public Status status;  
	
    /**
     * ENUMERATIONS
     */

    public enum Currency {
        CHF, EUR, USD
    }

    public enum Status{
        Processed, Pending, Error, Rejected
    }
	
}
