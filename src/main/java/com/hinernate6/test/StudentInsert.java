package com.hinernate6.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate6.entity.Student;
import com.hibernate6.utility.HibernateUtil;

public class StudentInsert {
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Student stu = new Student();
		stu.setSno(111);
		stu.setSname("Raj");
		stu.setMarks(500.0);
		
		Student stu2 = new Student();
		stu2.setSno(333);
		stu2.setSname("Aimable");
		stu2.setMarks(300.0);
		
		session.persist(stu);
		session.persist(stu2);//insert into StudentInfo values (?,?,?)
		tx.commit();
		session.close();
	}

}
