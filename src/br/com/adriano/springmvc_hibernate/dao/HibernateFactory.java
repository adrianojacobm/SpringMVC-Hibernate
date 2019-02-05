package br.com.adriano.springmvc_hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateFactory
{
	
	public static SessionFactory factory;
	
	public static Session session; 
	

    public static synchronized SessionFactory getSessionFactory() 
    {  	
        if (factory == null) 
            factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        
        return factory;
    }
    
    public static synchronized Session getSession()
    {
    	getSessionFactory();
    	if(session == null)
    		session = factory.getCurrentSession();    	   	
    	
    	if(!session.isOpen())
    		session = factory.openSession();
    	
    	return session;
    }
    
	public static void openSession() 
	{
		HibernateFactory.getSession(); 
		if(!HibernateFactory.session.getTransaction().isActive())
			HibernateFactory.session.beginTransaction();
	;}
	
	public static  void closeSession() {HibernateFactory.session.close();}

}
