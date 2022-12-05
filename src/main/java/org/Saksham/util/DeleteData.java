package org.Saksham.Util;

import org.Saksham.model.Address;
import org.Saksham.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteData {
    public static void main(String[] args) {
        SessionFactory sessionFactory = null;
        Session session = null;

        //add configuration and classes to sessionFactory object
        sessionFactory = new Configuration()
                .configure("hibernateCfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Address.class)
                .buildSessionFactory();

        //get current session
        session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            int studentID = 2;

            Student student = session.get(Student.class, studentID);

            if(student!=null){
                System.out.println("Deleting: \n" + student);
                session.delete(student);
            }
            session.getTransaction().commit();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sessionFactory.close();
        }
    }
}
