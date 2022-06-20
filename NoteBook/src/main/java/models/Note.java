package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "notes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private String category;

    @Column(name = "text")
    private String text;


    public Note(String name, String category, String text) {
        id = 0;
        this.name = name;
        this.category = category;
        this.text = text;

    }

    @Override
    public String toString() {
        return "ID: " + this.id + "name: " + this.name + " category: " + this.getCategory();
    }
}
