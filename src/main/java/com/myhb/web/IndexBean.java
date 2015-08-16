package com.myhb.web;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.myhb.hibernate.HibernateUtil;
import com.myhb.hibernate.pojo.Event;

@ManagedBean(name="indexB")
@SessionScoped
public class IndexBean implements Serializable {
	/*
	 * 
	 */
	public static final long serialVersionUID = 1L;
	
	private String title = "";
	
	@PostConstruct
	public void init()
	{
	}
	
	public void add()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = null;
		try
		{
			trans = session.beginTransaction();
			
			Event event = new Event();
			event.setTitle(this.title);
			event.setDate(new java.util.Date());
			session.save(event);
			
			trans.commit();
		}
		catch(Exception ex)
		{
			ex.printStackTrace(System.err);
		}
		finally
		{
			session.close();
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
