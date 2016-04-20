package io.fourfinanceit.homework.risk.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity(name="loan")
@Table(name="loan")
public class Loan implements java.io.Serializable{

	private static final long serialVersionUID = -258351389853233116L;

	public Loan(){}
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "DATE", nullable = false)
    private Date date;
    @Column(name = "FIRSTNAME", nullable = false)
    private String firstname;
    @Column(name = "SURNAME", nullable = false)
    private String surname;
    @Column(name = "AMOUNT", nullable = false)
    private long amount;
    @Column(name = "TERM", nullable = false)
    private long term;
    @Column(name = "IP", nullable = false)
    private String ip;

    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public long getTerm() {
		return term;
	}
	public void setTerm(long term) {
		this.term = term;
	}

	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}


    
}
