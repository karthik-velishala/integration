package com.fissionlabs.dao;  
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.fissionlabs.model.Employee;

import java.util.*;  
public class EmployeeDao {  
HibernateTemplate template;  
public void setTemplate(HibernateTemplate template) {  
    this.template = template;  
}  
//method to save employee  
public void saveEmployee(Employee e){  
    template.save(e);  
}   
public static boolean search(String n,String p)
{
	 Configuration cfg=new Configuration();  
     cfg.configure("hibernate.cfg.xml");
     SessionFactory factory1=cfg.buildSessionFactory();  
     Session session=factory1.openSession();  
     Transaction t=session.beginTransaction();  
           
     Query query= (Query) session.createQuery("from Employee where name=:n1 and password=:p1");//here persistent class name is Emp  
    query.setParameter("n1",n );
    query.setParameter("p1", p);
    List<Employee> list= ((org.hibernate.Query) query).list();  
     Iterator<Employee> itr=list.iterator();
     boolean status = false;
	if(itr.hasNext())
    	 status=true;
	return status;
} } 