package GuiController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import models.Note;

import java.net.URL;
import java.util.ResourceBundle;

public class AddNotePoput {

    private int id;
    private String name;
    private String category;
    private String text;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField inputCat;

    @FXML
    private Button cancelBtn;

    @FXML
    private TextArea inputText;

    @FXML
    private Button okBtn;

    @FXML
    private TextField inputName;

    @FXML
    void initialize() {
        this.inputCat.setText(category);
        this.inputName.setText(name);
        this.inputText.setText(text);
    }

    public AddNotePoput(Note note) {
        id = note.getId();
        category = note.getCategory();
        name = note.getName();
        text = note.getText();
    }

    public AddNotePoput() {}

    public Button getCancelBtn() {
        return cancelBtn;
    }

    public Button getOkBtn() {
        return okBtn;
    }

    public TextField getInputCat() {
        return inputCat;
    }

    public TextArea getInputText() {
        return inputText;
    }

    public TextField getInputName() {
        return inputName;
    }

}

