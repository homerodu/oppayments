package com.coe.cloud.openpay.payments.dao;

import java.math.BigInteger;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.coe.cloud.openpay.payments.entities.ChargeTable;
import com.coe.cloud.openpay.payments.hibernate.HibernateUtil;

public class ChargeDao {
	public void saveCharge(ChargeTable chargeTable) {
        Transaction transaction = null;
        try (
        	Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(chargeTable);
            transaction.commit();
            System.out.println("new charge id:"+chargeTable.getId());
        } catch (Exception e) {
            //if (transaction != null) {
            //    transaction.rollback();
            //}
            e.printStackTrace();
        }
    }
	
	public int countChargesByOrderId(String orderId) {
    	int countOcurrences=0;
        try (
            Session session = HibernateUtil.getSessionFactory().openSession()) {
        	@SuppressWarnings("rawtypes")
			Query query = session.createSQLQuery("SELECT count(*) FROM Charges C WHERE C.order_id=:order_id");
        	query.setParameter("order_id", orderId);
        	Object result=query.uniqueResult();
        	BigInteger resultBigInteger=(BigInteger)result;
        	countOcurrences=(int) resultBigInteger.intValue();
        	session.close();        	
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return countOcurrences;
    }
    
    public ChargeTable getCard(String chargeId) {
    	ChargeTable chargeTable=null;
        try (
            Session session = HibernateUtil.getSessionFactory().openSession()) {
        	//card=(Card)
        	Query<ChargeTable> query = session.createQuery("FROM Charges C WHERE C.id=:id", ChargeTable.class);
        	query.setParameter("id", chargeId);
        	chargeTable=query.getSingleResult();
        	session.close();        	
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return chargeTable;
    }   
}