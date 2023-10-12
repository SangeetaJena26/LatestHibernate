package com.hibernateexamples.sang.HibernateExample1;

import javax.transaction.Transaction;

import org.hibernate.Session;

import com.mysql.cj.xdevapi.SessionFactory;


public class Main1 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        System.out.println("abc4");
        Session session = sessionFactory.openSession();
        System.out.println("abc1");
        try {
            // Create 
        	System.out.println("abc");
            Student student = new Student("Sangeeta", "Pradhan", "sang@example.com");
            Transaction transaction = session.beginTransaction();
            session.save(student);
            System.out.println("abc1");
            Student retrievedStudent = session.get(Student.class, student.getId());
         
            
  
            retrievedStudent.setFirstName("Jane");
            session.update(retrievedStudent);
          
      //      session.delete(retrievedStudent);
            transaction.commit();
        } finally {
        	session.close();
            sessionFactory.close();
        }
    }
}
