package services;

import dao.NoteDao;
import models.Note;

import java.util.ArrayList;
import java.util.List;

public class NoteService {
    private String currentCategory;
    private final NoteDao dao;
    ArrayList<String> categories = new ArrayList<>();

    public NoteService() {
        this.dao = new NoteDao();
    }

    public ArrayList<String> getCategories() {

        System.out.println(dao.findAllCategory());
        categories.clear();
        for (String category: dao.findAllCategory()) {
            this.categories.add(category);
        }
        return categories;
    }

    public Note getNoteById(int id) {
        return dao.findById(id);
    }

    public List<Note> getAllNotesForCategory(String category) {
        return dao.findAllNotes(category);
    }

    public void add(Note note) {
        dao.save(note);
    }

    public void update (Note note, String category, String name, String text) {

        dao.update(note, category, name, text);
    }

    public void removeNote(String id){
        dao.delete(dao.findById(Integer.parseInt(id)));
    }



}
