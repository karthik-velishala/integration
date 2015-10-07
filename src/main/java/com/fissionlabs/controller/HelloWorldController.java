package com.fissionlabs.controller;  
import java.util.Iterator;
import java.util.List;


import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.servlet.ModelAndView;

import com.fissionlabs.dao.EmployeeDao;
import com.fissionlabs.model.Employee; 
 
  
@Controller  
public class HelloWorldController {  
      
    @RequestMapping("/register")  
    public ModelAndView helloWorld(HttpServletRequest request,HttpServletResponse res) {  
        String name=request.getParameter("name");  
        String password=request.getParameter("password");  
        
        ApplicationContext context =   
        	    new ClassPathXmlApplicationContext("applicationContext.xml");  
       
        
        EmployeeDao dao=(EmployeeDao)context.getBean("k1");  
       
        
          
       Employee e=new Employee();
       e.setId(20);
       e.setName(name);
       e.setPassword(password);
       if(EmployeeDao.search(name, password))
       {
    	   return new ModelAndView("alreadyregister");
       }
       dao.saveEmployee(e);
       String message="successfully registered";
       return new ModelAndView("registersuccess");
       }
    @RequestMapping("/login")  
    public ModelAndView helloWorld1(HttpServletRequest request,HttpServletResponse res) {  
        String n=request.getParameter("name");  
        String p=request.getParameter("password");  
        
   
    
        if(EmployeeDao.search(n,p))
        	
        {
        	String message="Welcome"+n;
        	return new ModelAndView("loginsuccess","message",message);
        
        }
        else{
		return new ModelAndView("loginerror");
		}
        } } 

 