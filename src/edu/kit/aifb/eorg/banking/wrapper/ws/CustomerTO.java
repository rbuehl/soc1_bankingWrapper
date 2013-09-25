package edu.kit.aifb.eorg.banking.wrapper.ws;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerTO {

    public Long id;

    public String lastName;

    public String firstName;

    public Sex sex;

    public String city;

    public int age;

    public String ageGroup;

    public enum Sex{
        male, female
    }

}
