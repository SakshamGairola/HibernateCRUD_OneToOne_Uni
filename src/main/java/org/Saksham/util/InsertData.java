package org.Saksham.Util;

import org.Saksham.model.Address;
import org.Saksham.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InsertData {
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

            Student student1 = new Student("Saksham");
            Address address1 = new Address("Kanpur", "UP");

            Student student2 = new Student("Gairola");
            Address address2 = new Address("Manchester", "UK");

            student1.setAddress(address1);
            session.save(student1);

            student2.setAddress(address2);
            session.save(student2);
            //session.save(address1);

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactory.close();
        }
    }
}
