package com.myhb.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory()
	{
		try
		{
			//get configuration
			Configuration configuration = new Configuration();
			//point to config file
			configuration.configure("/hibernate.cfg.xml");
			//get settings from file
			ServiceRegistry serviceRegistry 
				= new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			//build session
			return configuration.buildSessionFactory(serviceRegistry);
		}
		catch(Throwable ex)
		{
			System.err.println("\n\n---------------- Error ------------- \n\n");
			ex.printStackTrace(System.err);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}
}
