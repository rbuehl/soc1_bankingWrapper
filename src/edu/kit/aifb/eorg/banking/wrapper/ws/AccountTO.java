package edu.kit.aifb.eorg.banking.wrapper.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class AccountTO {

	public Long id;
	public String owner;
	public String iban;
	
	
//	public Long getId() {
//		return id;
//	}
//	public String getOwner() {
//		return owner;
//	}
//	public String getIban() {
//		return iban;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	public void setOwner(String owner) {
//		this.owner = owner;
//	}
//	public void setIban(String iban) {
//		this.iban = iban;
//	}
}
