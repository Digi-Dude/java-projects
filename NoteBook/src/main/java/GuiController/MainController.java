package GuiController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import services.NoteService;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
public class MainController {

    @FXML
    private Label nickNameLabel;

    @FXML
    private Button settingBtn;

    @FXML
    private Button logOutBtn;

    @FXML
    private Button notesBtn;

    @FXML
    private Button toDoListBtn;

    @FXML
    private Button calendarBtn;

    @FXML
    private FlowPane mainPane;

    @FXML
    void d9d9d9(ActionEvent event) {}

    private FXMLLoader loader = new FXMLLoader();
    private List<Parent> listNotes = new ArrayList<>();
    private NoteService noteService = new NoteService();
    private List<String> categories = new ArrayList<>();
    private String currentCategory = "";

    @FXML
    void initialize() throws IOException {
        selectNoteMode();
        btnNotesOnClick();
    }

    public void selectNoteMode() throws IOException {
        URL url = getClass().getResource("/gui/noteWrap.fxml");
        loader.setLocation(url);
        Parent notePane = loader.load();
        this.mainPane.getChildren().clear();
        this.mainPane.getChildren().add(notePane);
    }

    public void selectToDoListMode() {

    }

    private void btnNotesOnClick() {
        this.notesBtn.setOnAction(actionEvent -> {
            try {
                selectNoteMode();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }





}

