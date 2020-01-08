package com.coe.cloud.openpay.payments.hibernate;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.coe.cloud.openpay.payments.entities.AddressTable;
import com.coe.cloud.openpay.payments.entities.ChargeTable;
import com.coe.cloud.openpay.payments.entities.CustomerTable;
import com.coe.cloud.openpay.payments.entities.DeviceTable;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties properties = new Properties();
                // mysql
                properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                properties.put(Environment.URL, "jdbc:mysql://localhost:3306/payments?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true");
                properties.put(Environment.USER, "root");
                properties.put(Environment.PASS, "EdtiSwud69.");
                properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
                properties.put(Environment.SHOW_SQL, "true");
                properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                properties.put(Environment.HBM2DDL_AUTO, "validate");
                configuration.setProperties(properties);
                configuration.addAnnotatedClass(AddressTable.class);
                //configuration.addAnnotatedClass(Card.class);
                configuration.addAnnotatedClass(CustomerTable.class);
                configuration.addAnnotatedClass(ChargeTable.class);
                configuration.addAnnotatedClass(DeviceTable.class);
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}