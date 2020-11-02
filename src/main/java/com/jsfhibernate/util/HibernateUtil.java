package com.jsfhibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.metamodel.Metadata;
import org.hibernate.metamodel.MetadataSources;

public class HibernateUtil {

	private static SessionFactory sessionFactoryObj = buildSessionFactoryObj();

	// Create The SessionFactory Object From Standard (Hibernate.cfg.xml) Configuration File
	public static SessionFactory buildSessionFactoryObj() {
		try {
			sessionFactoryObj = new Configuration().configure().buildSessionFactory();
		} catch (ExceptionInInitializerError exceptionObj) {
			exceptionObj.printStackTrace();
		}
		return sessionFactoryObj;
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactoryObj;
	}
}


