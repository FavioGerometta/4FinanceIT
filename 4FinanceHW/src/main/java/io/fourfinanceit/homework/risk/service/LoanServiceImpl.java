package io.fourfinanceit.homework.risk.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.fourfinanceit.homework.risk.dao.LoanDao;
import io.fourfinanceit.homework.risk.model.Loan;
import io.fourfinanceit.homework.risk.model.suscriptor.LoanSuscriptor;
import io.fourfinanceit.homework.util.DateUtil;

@Service
@Transactional
public class LoanServiceImpl implements LoanService {

	@Autowired
	private LoanDao loanDao;

	public Loan issueLoan(LoanSuscriptor loanForm, String address) throws Exception {
		if (DateUtil.isNight() && MAX_AMOUNT == loanForm.getAmount()) {
			throw new Exception("Service unavailable at this time.");
		}
		if (MAX_APPLICATIONS == loanDao.getIpCount(address)) {
			throw new Exception("Service unavailable for this IP address.");
		}
		Loan loan = new Loan();
		loan.setFirstname(loanForm.getFirstname());
		loan.setSurname(loanForm.getSurname());
		loan.setAmount(loanForm.getAmount());
		loan.setTerm(loanForm.getTerm());
		loan.setDate(new Date());
		loan.setIp(address);
		return loanDao.issueLoan(loan);
	}

}
