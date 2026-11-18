package com.example.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.model.Student;

public class HibernateStudentDemo {

    public static void runDemo() {
        System.out.println("==================================================");
        System.out.println(">>> STARTING HIBERNATE ORM APPROACH DEMO");
        System.out.println("==================================================");

        Long charlieId = null;
        Long davidId = null;

        // 1. CREATE / INSERT entities
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            System.out.println("\n[Hibernate] Creating and persisting Student entities...");
            Student student1 = new Student("Charlie Brown", "charlie.hib@example.com", "Cloud Computing");
            Student student2 = new Student("David Miller", "david.hib@example.com", "Cyber Security");

            session.persist(student1);
            session.persist(student2);

            transaction.commit();

            charlieId = student1.getId();
            davidId = student2.getId();
            System.out.println("[Hibernate] Persisted Charlie (ID: " + charlieId + ")");
            System.out.println("[Hibernate] Persisted David (ID: " + davidId + ")");
        } catch (Exception e) {
            System.err.println("[Hibernate Error] Failed to persist students: " + e.getMessage());
            e.printStackTrace();
        }

        // 2. READ / QUERY ALL using HQL
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            System.out.println("\n[Hibernate] Fetching all students using HQL (FROM Student)...");
            List<Student> students = session.createQuery("FROM Student", Student.class).list();

            for (Student s : students) {
                System.out.println("  -> " + s);
            }
        } catch (Exception e) {
            System.err.println("[Hibernate Error] Query failed: " + e.getMessage());
            e.printStackTrace();
        }

        // 3. READ by ID & UPDATE
        if (charlieId != null) {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();

                System.out.println("\n[Hibernate] Fetching Charlie (ID: " + charlieId + ") to update course...");
                Student studentToUpdate = session.get(Student.class, charlieId);
                if (studentToUpdate != null) {
                    System.out.println("[Hibernate] Before update: " + studentToUpdate);
                    studentToUpdate.setCourse("Full Stack Engineering");
                    // In Hibernate, modifying a managed entity inside a transaction
                    // automatically synchronizes with the database on commit!
                    transaction.commit();
                    System.out.println("[Hibernate] After update: " + studentToUpdate);
                }
            } catch (Exception e) {
                System.err.println("[Hibernate Error] Update failed: " + e.getMessage());
                e.printStackTrace();
            }
        }

        // 4. DELETE by ID
        if (davidId != null) {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();

                System.out.println("\n[Hibernate] Deleting David (ID: " + davidId + ")...");
                Student studentToDelete = session.get(Student.class, davidId);
                if (studentToDelete != null) {
                    session.remove(studentToDelete);
                    transaction.commit();
                    System.out.println("[Hibernate] David was successfully removed.");
                }
            } catch (Exception e) {
                System.err.println("[Hibernate Error] Delete failed: " + e.getMessage());
                e.printStackTrace();
            }
        }

        // 5. Final verification: Read all
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            System.out.println("\n[Hibernate] Final student list from database:");
            List<Student> remaining = session.createQuery("FROM Student", Student.class).list();
            for (Student s : remaining) {
                System.out.println("  -> " + s);
            }
        } catch (Exception e) {
            System.err.println("[Hibernate Error] Final fetch failed: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("\n>>> [Hibernate] Demo completed successfully!\n");
    }

    public static void main(String[] args) {
        try {
            runDemo();
        } finally {
            HibernateUtil.shutdown();
            com.mysql.cj.jdbc.AbandonedConnectionCleanupThread.checkedShutdown();
        }
    }
}
