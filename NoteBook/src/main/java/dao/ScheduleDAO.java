package dao;

import models.Note;
import models.Schedule;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.DateUtils;
import utils.HibernateSessionFactoryUtil;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ScheduleDAO {

    public Schedule findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Schedule.class, id);
    }

    public List findAllSchedule() {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM Schedule").list();
    }

    public void save(Schedule schedule) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(schedule);
        tx1.commit();
        session.close();
    }

    public void update(Schedule schedule) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(schedule);
        tx.commit();
        session.close();
    }

    public List<Schedule> getWeek(LocalDate day) {
        String beginWeekStr = day.format(DateTimeFormatter.ISO_DATE);
        String endWeekStr = DateUtils.getEndWeek(day).format(DateTimeFormatter.ISO_DATE);
        return HibernateSessionFactoryUtil.getSessionFactory().openSession()
                .createSQLQuery("Select * FROM Schedule where schedule.date between '" + beginWeekStr + "' and '" + endWeekStr + "'")
                .addEntity(Schedule.class)
                .list();
    }

}
