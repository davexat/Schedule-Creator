package main;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import schedule.Combinator;
import schedule.Curso;
import util.CircularList;
import util.ContenedorCreator;

public class ScheduleController implements Initializable {
    @FXML private HBox principal;
    @FXML private VBox cajaFiltros;
    private List<CheckBox> checkBoxes = new ArrayList<>();
    private CircularList<List<VBox>> horarios = new CircularList<>();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        agregarMaterias(App.lector.getMaterias());
        for (List<Curso> horario: new Combinator(App.lector).generarCombinacionesConFiltro(new ArrayList<>())){
            horarios.add(new ContenedorCreator(horario).crearContenedores());
        }
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
        if(materias==null) return;
        principal.getChildren().clear();
        Group grupo = new Group();
        for (VBox materia: materias){
            grupo.getChildren().add(materia);
        }
        principal.getChildren().add(grupo);
    }
    private void agregarMaterias(Set<String> materias) {
        for (String materia : materias) {
            CheckBox checkBox = new CheckBox(materia);
            checkBoxes.add(checkBox);
            cajaFiltros.getChildren().add(checkBox);
        }
    }
    @FXML
    private void filtrar() {
        List<String> materiasExcluidas = new ArrayList<>();
        for (CheckBox checkBox : checkBoxes) {
            if (!checkBox.isSelected()) {
                materiasExcluidas.add(checkBox.getText());
            }
        }
        horarios.clear();
        for (List<Curso> horario: new Combinator(App.lector).generarCombinacionesConFiltro(materiasExcluidas)){
            horarios.add(new ContenedorCreator(horario).crearContenedores());
        }
        colocarEnPane(horarios.setPointer(null));
    }
}
