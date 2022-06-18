package main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Do {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String date;

    private String name;

    private String description;

    public Do(String date, String name, String description) {
        this.date = date;
        this.name = name;
        this.description = description;
    }

    public Do() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
