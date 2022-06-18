import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();

        List<Course> courses = new ArrayList<>();
        List<Teacher> teachers = new ArrayList<>();

        for (int i = 1;; i++) {
            if (session.get(Teacher.class, i) == null) {break;}
            teachers.add(session.get(Teacher.class, i));
        }
        teachers.forEach(teacher -> {
            System.out.println("Имя учителя: " + teacher.getName() + ".  Возрвст: " + teacher.getAge());
        });

        for (int i = 1;; i++) {
            if (session.get(Course.class, i) == null) {break;}
            courses.add(session.get(Course.class, i));
        }

        courses.forEach(course -> {
            System.out.println("Имя курса: " + course.getName() + "; Количество студентов: " + course.getStudentsCount());
        });

        sessionFactory.close();
    }
}
