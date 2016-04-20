package io.fourfinanceit.homework.risk.message;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;

import io.fourfinanceit.homework.risk.model.Loan;


public class LoanResource extends Resource<Loan> {

	public LoanResource(Loan content, Link link) {
		super(content, link);
	}

}
