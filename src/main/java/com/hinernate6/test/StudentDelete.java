package com.hinernate6.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.query.SelectionQuery;

import com.hibernate6.entity.Student;
import com.hibernate6.utility.HibernateUtil;

public class StudentDelete {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		//Method1
		
		/*Student stud = new Student();
		stud.setSno(111);
		session.remove(stud);
		//session.delete(stud); //prior to Hibernate 6 version
		*/
		
		//Method2
		/*
		Student stud = session.get(Student.class, 222);
		session.remove(stud); */
		
		//Method3 -Deleting multiple persistent objects
		SelectionQuery<Student> query = session.createSelectionQuery("from Student where marks >= : marks", Student.class);
		query.setParameter("marks", 400.0);
		List<Student> studList = query.list();
		for(Student stud : studList)
			session.remove(stud);
		
		//old version of hibernate
		/*
		Query query = session.createQuery("from Student where marks >= : marks");
		List<Student> studList = query.list();
		for(Student stud : studList)
			session.delete(stud);
		*/
		tx.commit();
		session.close();

	}

}
