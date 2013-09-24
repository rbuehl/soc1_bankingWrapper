package edu.kit.aifb.eorg.banking.wrapper.ws;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class AccountTO {

    public Long id;
    public CustomerTO owner;
    public String iban;

    public BigDecimal balance;

    public Type typeOf;

    public enum Type{
	        Checking, Savings, Loan
    }
}
