package dao;

import models.Note;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class NoteDao {

    public Note findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Note.class, id);
    }

    public List<String> findAllCategory() {
        List<String> notes =  (List<String>)HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("Select distinct category FROM Note").list();
        return  notes;
    }

    public List<Note> findAllNotes(String category) {
        List<Note> notes = (List<Note>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM Note WHERE category = \'" + category + "\'").list();
        return  notes;
    }

    public Note findNoteByName(String category, String name) {
        List<Note> notes = (List<Note>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM Note e WHERE category = \'" + category + "\'" + " and " + "name = " + "\'" + name + "\'").list();
        return notes.get(0);
    }


    public void save(Note note) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(note);
        tx1.commit();
        session.close();
    }

    public void update(Note note, String category, String name, String text) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.evict(note);
        note.setCategory(category);
        note.setName(name);
        note.setText(text);
        session.update(note);
        tx1.commit();
        session.close();
    }

    public void delete(Note note) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(note);
        tx1.commit();
        session.close();
    }
}
