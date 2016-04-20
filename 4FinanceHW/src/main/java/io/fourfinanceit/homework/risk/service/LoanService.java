package io.fourfinanceit.homework.risk.service;

import io.fourfinanceit.homework.risk.model.Loan;
import io.fourfinanceit.homework.risk.model.suscriptor.LoanSuscriptor;

public interface LoanService {

	static int MAX_AMOUNT = 10000;
	static int MAX_APPLICATIONS = 3;
	Loan issueLoan(LoanSuscriptor loanForm, String remoteAddr) throws Exception;

}
