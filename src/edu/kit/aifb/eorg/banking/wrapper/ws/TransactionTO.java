package edu.kit.aifb.eorg.banking.wrapper.ws;

import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
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
        USD, EUR, GBP
    }

    public enum Status{
        Processed, Pending, Error
    }


    
	
//	public Long getId() {
//		return id;
//	}
//
//	public AccountTO getAccountFrom() {
//		return accountFrom;
//	}
//
//	public AccountTO getAccountTo() {
//		return accountTo;
//	}
//
//	public String getReference() {
//		return reference;
//	}
//
//	public Date getDate() {
//		return date;
//	}
//
//	public BigDecimal getValue() {
//		return value;
//	}
//
//	public Currency getCurrency() {
//		return currency;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public void setAccountFrom(AccountTO accountFrom) {
//		this.accountFrom = accountFrom;
//	}
//
//	public void setAccountTo(AccountTO accountTo) {
//		this.accountTo = accountTo;
//	}
//
//	public void setReference(String reference) {
//		this.reference = reference;
//	}
//
//	public void setDate(Date date) {
//		this.date = date;
//	}
//
//	public void setValue(BigDecimal value) {
//		this.value = value;
//	}
//
//	public void setCurrency(Currency currency) {
//		this.currency = currency;
//	}
//	
	
	
}
