package com.hinernate6.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.SelectionQuery;

import com.hibernate6.entity.Student;
import com.hibernate6.utility.HibernateUtil;

public class StudentList {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		SelectionQuery<Student> query = session.createSelectionQuery("from Student", Student.class);
		List<Student> studList = query.list();
		
		/*
		* for (Student stud : studList) {
		*	System.out.println(stud);//invoke toString() implicitly
		*/
		
		//studList.forEach(stud -> System.out.println(stud));
	
		studList.forEach(System.out::println); //method reference
			session.close();
		}
		
	}
