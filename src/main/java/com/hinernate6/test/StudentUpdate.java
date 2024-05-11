package com.hinernate6.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.MutationQuery;

import com.hibernate6.entity.Student;
import com.hibernate6.utility.HibernateUtil;

public class StudentUpdate {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		// Method1
		// Student stud = session.get(Student.class,111); //select * form StudentInfo
		// where sno=111;
		// stud.setMarks(550.0);
		// session.merge(stud);
		
		// Old Hibernate Version
		/*
		 * Student stud = (Session) session.get(Student.class,111);
		 * stud.setMarks(550.0); session.merge(stud); session.merge(stud);
		 */

		// Method2 - Using HQL (Hinbernate Query Language) - applied on Model (class),
		// not on table
		MutationQuery query = session.createMutationQuery("update Student set marks = :marks where sname =:sname");
		query.setParameter("marks", 550.0);
		query.setParameter("sname", "Raj");
		query.executeUpdate();
		
		// Old Hibernate Version
		/*
		 * Query query = session.
		 * createMutationQuery("update Student set marks = :marks where sname =:sname");
		 * query.setParameter("marks", 650.0); query.setParameter("sname", "Ram");
		 * query.executeUpdate();
		 */
		tx.commit();
		session.close();

	}

}
