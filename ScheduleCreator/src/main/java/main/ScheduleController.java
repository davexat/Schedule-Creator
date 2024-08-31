package main;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import util.CircularList;

public class ScheduleController implements Initializable {
    @FXML HBox hola;
    @FXML HBox principal;
    public static CircularList<List<VBox>> horarios = new CircularList<>();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colocarEnPane(horarios.setPointer(null));
    }
    @FXML
    private void horarioIzq(){
        colocarEnPane(horarios.previousPointer());
    }
    @FXML
    private void horarioDer(){
        colocarEnPane(horarios.nextPointer());
    }
    private void colocarEnPane(List<VBox> materias){
        principal.getChildren().clear();
        Group grupo = new Group();
        for (VBox materia: materias){
            grupo.getChildren().add(materia);
        }
        principal.getChildren().add(grupo);
    }
}
