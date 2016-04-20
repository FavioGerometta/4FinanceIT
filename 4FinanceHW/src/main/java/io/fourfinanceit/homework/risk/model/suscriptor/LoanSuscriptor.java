package io.fourfinanceit.homework.risk.model.suscriptor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;


public class LoanSuscriptor {

		@NotEmpty
	    private String firstname;
		@NotEmpty
	    private String surname;
	    @NotNull
	    @Min(1)
	    private long amount;
	    @NotNull
	    @Min(1)
	    private int term;
	    
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
		public int getTerm() {
			return term;
		}
		public void setTerm(int term) {
			this.term = term;
		}

}
