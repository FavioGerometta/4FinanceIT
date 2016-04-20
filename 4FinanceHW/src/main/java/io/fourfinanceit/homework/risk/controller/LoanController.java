package io.fourfinanceit.homework.risk.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;

import io.fourfinanceit.homework.risk.message.LoanAssembler;
import io.fourfinanceit.homework.risk.message.LoanResource;
import io.fourfinanceit.homework.risk.model.Loan;
import io.fourfinanceit.homework.risk.model.suscriptor.LoanSuscriptor;
import io.fourfinanceit.homework.risk.service.LoanService;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("api")
@Controller
public class LoanController {

	@Autowired
	private LoanService loanService;

	@RequestMapping("/issueLoan")
	public HttpEntity<?> issueLoan(@Valid LoanSuscriptor loanForm, BindingResult result, HttpServletRequest request)
			throws Exception {
		if (result.hasErrors()) {
			return new ResponseEntity<Map<String, String>>(getTranslatedErrors(result), HttpStatus.BAD_REQUEST);
		} else {
			try {
				final Loan loan = loanService.issueLoan(loanForm, request.getRemoteAddr());
				final LoanAssembler assembler = new LoanAssembler();
				final LoanResource resource = assembler.toResource(loan);
				return new HttpEntity<LoanResource>(resource);
			} catch (Exception e) {
				return new ResponseEntity<String>("REJECTED", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	}

	private Map<String, String> getTranslatedErrors(final BindingResult result) {
		return new HashMap<String, String>() {
			private static final long serialVersionUID = 5311214869174618636L;
			{
				for (FieldError error : result.getFieldErrors()) {
					put(error.getField(), error.getDefaultMessage());
				}
			}
		};
	}
}
