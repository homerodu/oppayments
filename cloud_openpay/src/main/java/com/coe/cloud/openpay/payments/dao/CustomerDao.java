package com.coe.cloud.openpay.payments.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.coe.cloud.openpay.payments.entities.CustomerTable;
import com.coe.cloud.openpay.payments.hibernate.HibernateUtil;

public class CustomerDao {
    public void saveCustomer(CustomerTable customer) {
        Transaction transaction = null;
        try (
        	Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(customer);
            transaction.commit();
            System.out.println("new customer id:"+customer.getId());
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public CustomerTable getCustomer(String customerId) {
    	CustomerTable customerTable=null;
        try (
            Session session = HibernateUtil.getSessionFactory().openSession()) {
        	//customer=(Customer)
        	Query<CustomerTable> query = session.createQuery("FROM Customers C WHERE C.id=:id", CustomerTable.class);
        	query.setParameter("id", customerId);
        	//Customer customerOp=query.getSingleResult();
        	customerTable=query.getSingleResult();
        	session.close();        	
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return customerTable;
    }
}