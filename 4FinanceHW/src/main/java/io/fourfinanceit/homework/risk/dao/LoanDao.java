package io.fourfinanceit.homework.risk.dao;

import io.fourfinanceit.homework.risk.model.Loan;


public interface LoanDao  {

	Loan get(long id);

	Long getIpCount(String address);

	Loan issueLoan(Loan loan);
}
