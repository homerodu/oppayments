package com.coe.cloud.openpay.payments.dao;

import java.math.BigInteger;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.coe.cloud.openpay.payments.entities.DeviceTable;
import com.coe.cloud.openpay.payments.hibernate.HibernateUtil;

public class DeviceDao {
	public void saveDevice(DeviceTable device) {
        Transaction transaction = null;
        try (
        	Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(device);
            transaction.commit();
            System.out.println("new Device id:"+device.getId());
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
	
	public int countDevicesByDeviceId(String deviceId) {
    	int countOcurrences=0;
        try (
            Session session = HibernateUtil.getSessionFactory().openSession()) {
        	@SuppressWarnings("rawtypes")
			Query query = session.createSQLQuery("SELECT count(*) FROM Devices D WHERE D.id=:id");
        	query.setParameter("id", deviceId);
        	Object result=query.uniqueResult();
        	BigInteger resultBigInteger=(BigInteger)result;
        	countOcurrences=(int) resultBigInteger.intValue();
        	session.close();        	
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return countOcurrences;
    }
    
    public DeviceTable getDevice(String deviceId) {
    	DeviceTable device=null;
        try (
            Session session = HibernateUtil.getSessionFactory().openSession()) {
        	Query<DeviceTable> query = session.createQuery("FROM Devices D WHERE D.id=:id", DeviceTable.class);
        	query.setParameter("id", deviceId);
        	device=query.getSingleResult();
        	session.close();        	
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return device;
    }
    
    
}
