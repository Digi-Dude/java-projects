import entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();

        try (SessionFactory factory = metadata.getSessionFactoryBuilder().build()) {

            Session session = factory.openSession();
            Transaction transaction = session.beginTransaction();



            String hql = "From " + Purchase.class.getSimpleName();
            List<Purchase> purchases = session.createQuery(hql).getResultList();

            List<LinkedPurchaseList> linkedPurchaseList = new ArrayList();

            String hqlGetCourseName;
            String hqlGetStudentName;
            for (Purchase purchase : purchases) {
                hqlGetCourseName = "From " + Course.class.getSimpleName() + " Where name = \'" + purchase.getCourseName() + "\'";
                hqlGetStudentName = "From " + Student.class.getSimpleName() + " Where name = \'" + purchase.getStudentName() + "\'";

                List<Course> coursesId = session.createQuery(hqlGetCourseName).getResultList();
                List<Student> studentsId = session.createQuery(hqlGetStudentName).getResultList();

                int courseId = coursesId.get(0).getId();
                int studentId = studentsId.get(0).getId();

                linkedPurchaseList.add(new LinkedPurchaseList(new Key(studentId, courseId), studentId, courseId));
            }

            linkedPurchaseList.forEach(el -> session.save(el));
            transaction.commit();
            session.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
}
