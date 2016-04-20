package io.fourfinanceit.homework.risk.dao;

import java.util.Calendar;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.fourfinanceit.homework.risk.model.Loan;

@Repository
public class LoanDaoImpl implements LoanDao {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	protected SessionFactory sessionFactory;

	public Loan get(long id) {
		Session session = sessionFactory.getCurrentSession();
		return (Loan) session.get(Loan.class, id);
	}

	public Long getIpCount(String address) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, -1);
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Loan.class);
		Criteria projection = criteria.setProjection(Projections.rowCount());
		return (Long) projection.uniqueResult();
	}

	public Loan issueLoan(Loan loan) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(loan);
		return loan;
	}

}
