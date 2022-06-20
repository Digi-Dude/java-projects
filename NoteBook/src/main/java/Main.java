import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.Note;
import services.NoteService;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class Main extends Application{
    List<String> category = new ArrayList<>();
    List<Note> notesList = new ArrayList<>();
    NoteService noteService = new NoteService();



    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void init() {
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        URL url = getClass().getResource("/gui/mainForm.fxml");
        loader.setLocation(url);
        Parent root = loader.load();

        stage.setTitle("Notebook");
        stage.setScene(new Scene(root, 1256, 650));
        stage.setResizable(false);
        stage.show();
    }

}
