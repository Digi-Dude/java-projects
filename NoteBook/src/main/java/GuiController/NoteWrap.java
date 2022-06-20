package GuiController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.FlowPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Note;
import services.NoteService;

import java.io.IOException;
import java.util.ArrayList;

public class NoteWrap {

    @FXML
    private FlowPane noteWrap;

    @FXML
    private Button addNote;

    @FXML
    private FlowPane objArea;

    @FXML
    private ComboBox<String> chooseCategory;

    private FXMLLoader loader;
    private ArrayList<String> categories = new ArrayList<>();
    private ArrayList<Parent> notesGui = new ArrayList<>();
    private NoteService noteService = new NoteService();
    private String currentCategory = "";

    @FXML
    void initialize() throws IOException {
        createListCategory();
        setDefaultCategory();
        createListNotes(currentCategory);
        listNotesGuiShow();
        changeCategory();
        addNoteEv();
    }

    private void createListCategory() {
        categories = noteService.getCategories();
        categories = new ArrayList<>(noteService.getCategories());
        ObservableList<String> catList = FXCollections.observableList(categories);
        chooseCategory.setItems(catList);
    }

    private void setDefaultCategory() {
        if (currentCategory.equals("")) {
            currentCategory = categories.get(0);
            chooseCategory.setValue(currentCategory);
        }
    }

    private void createListNotes(String currentCategory) throws IOException {
        notesGui.clear();
        for (Note note: noteService.getAllNotesForCategory(currentCategory)) {
            NotesController notesController = new NotesController(note);
            loader = new FXMLLoader(getClass().getResource("/gui/noteForm.fxml"));
            loader.setController(notesController);
            Parent noteGui = loader.load();
            removeEl(notesController);
            editEl(notesController, note);
            notesGui.add(noteGui);
        }
    }

    private void listNotesGuiShow() {
        objArea.getChildren().clear();
        notesGui.forEach(parent -> {
            objArea.getChildren().add(parent);
        });
    }

    private void changeCategory() {
        chooseCategory.setOnAction(event -> {
            try {
                System.out.println(currentCategory);
                currentCategory = chooseCategory.getValue();
                createListNotes(currentCategory);
                listNotesGuiShow();
            } catch (Exception exeption) {
                exeption.fillInStackTrace();
            }
        });
    }

    private void removeEl(NotesController notesController)  {
        notesController.getRemoveBtn().setOnAction(event -> {
            noteService.removeNote(notesController.getID());
            if (!noteService.getAllNotesForCategory(currentCategory).contains(currentCategory)) {
                try {
                    currentCategory = "";
                    createListCategory();
                    setDefaultCategory();
                    createListNotes(currentCategory);
                    listNotesGuiShow();
                }
                catch (Exception exception) {
                    exception.fillInStackTrace();
                }
            }
        });
    }

    private void editEl(NotesController notesController, Note note) {
        notesController.getEditBtn().setOnAction(event -> {
            Stage stage = new Stage();
            AddNotePoput editNote = new AddNotePoput(note);
            loader = new FXMLLoader(getClass().getResource("/gui/notePoput.fxml"));
            loader.setController(editNote);
            try {
                Parent editGui = loader.load();
                stage.setScene(new Scene(editGui));
                stage.setResizable(false);
            }
            catch (Exception exception) {
                exception.fillInStackTrace();
            }
            editNote.getInputCat().setText(note.getCategory());
            editNote.getInputName().setText(note.getName());
            editNote.getInputText().setText(note.getText());

            editNote.getOkBtn().setOnAction(event1 -> {
                if (!editNote.getInputCat().getText().isEmpty()
                        || !editNote.getInputName().getText().isEmpty()
                        || !editNote.getInputText().getText().isEmpty()) {
                    try {
                        noteService.update(note, editNote.getInputCat().getText(), editNote.getInputName().getText(), editNote.getInputText().getText());
                        createListNotes(currentCategory);
                        listNotesGuiShow();
                        stage.close();
                    }
                    catch (Exception exception) {
                        exception.fillInStackTrace();
                    }
                }
            });
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
            editNote.getCancelBtn().setOnAction(event2 -> {
                stage.close();
            });
        });
    }

    private void addNoteEv() {
        addNote.setOnAction(event -> {
            try {
                Stage stage = new Stage();
                AddNotePoput addNotePoput = new AddNotePoput();
                loader = new FXMLLoader(getClass().getResource("/gui/notePoput.fxml"));
                loader.setController(addNotePoput);
                Parent addNote = loader.load();
                stage.setScene(new Scene(addNote));
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setResizable(false);
                stage.show();
                addNotePoput.getOkBtn().setOnAction(event1 -> {
                    if (!addNotePoput.getInputCat().getText().isEmpty()
                            || !addNotePoput.getInputName().getText().isEmpty()
                            || !addNotePoput.getInputText().getText().isEmpty()) {
                        try {
                            noteService.add(new Note(addNotePoput.getInputName().getText(), addNotePoput.getInputCat().getText(), addNotePoput.getInputText().getText()));
                            currentCategory = addNotePoput.getInputCat().getText();
                            chooseCategory.setValue(currentCategory);
                            createListNotes(currentCategory);
                            listNotesGuiShow();
                            stage.close();
                        }
                        catch (Exception exception) {
                            exception.fillInStackTrace();
                        }
                    }
                });
                addNotePoput.getCancelBtn().setOnAction(event1 -> {
                    stage.close();
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}
