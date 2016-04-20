package io.fourfinanceit.homework.risk.message;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import io.fourfinanceit.homework.risk.controller.LoanController;
import io.fourfinanceit.homework.risk.model.Loan;

public class LoanAssembler  extends ResourceAssemblerSupport<Loan, LoanResource> {

	private static String URI = "localhost:8080/api/loans/"; // should come from another place
	
	public LoanAssembler(Class<?> controllerClass, Class<LoanResource> resourceType) {
		super(controllerClass, resourceType);
	}

	public LoanAssembler() {
		super(LoanController.class,LoanResource.class);
	}

	public LoanResource toResource(Loan loan) {
		return new LoanResource(loan, new Link( URI + loan.getId(), "rel"));
	}



}
