package com.coe.cloud.openpay.payments.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.coe.cloud.openpay.payments.hibernate.HibernateUtil;

import mx.openpay.client.Card;

public class CardDao {
	public void saveCard(Card card) {
        Transaction transaction = null;
        try (
        	Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(card);
            transaction.commit();
            System.out.println("new card id");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public Card getCard(String cardId) {
    	Card card=null;
        try (
            Session session = HibernateUtil.getSessionFactory().openSession()) {
        	//card=(Card)
        	Query<Card> query = session.createQuery("FROM Card C WHERE C.id=?", Card.class);
        	query.setParameter("id", cardId);
        	card=query.getSingleResult();
        	session.close();        	
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return card;
    }
}
