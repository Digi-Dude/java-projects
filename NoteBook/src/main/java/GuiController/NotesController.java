package GuiController;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import models.Note;
import services.NoteService;

import java.net.URL;
import java.util.ResourceBundle;

public class NotesController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private FlowPane noteView;

    @FXML
    private Label noteText;

    @FXML
    private Label noteName;

    @FXML
    private Button editBtn;

    @FXML
    private Button removeBtn;

    @FXML
    void f06500(ActionEvent event) {
    }

    NoteService noteService = new NoteService();
    private SimpleStringProperty name = new SimpleStringProperty();
    private SimpleStringProperty text = new SimpleStringProperty();
    private SimpleStringProperty id = new SimpleStringProperty();

    public NotesController(Note note) {
        name.set(note.getName());
        text.set(note.getText());
        id.set(String.valueOf(note.getId()));
    }

    @FXML
    void initialize() {
        noteName.setText(name.get());
        noteText.setText(text.get());
        noteView.setId(id.get());
    }

    public Button getRemoveBtn() {
        return removeBtn;
    }

    public Button getEditBtn() {
        return editBtn;
    }

    public String getID() {
        return this.id.get();
    }

}
