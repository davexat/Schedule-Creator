/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schedule;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 *
 * @author Pc
 */
public class ContenedorCreator {
    private final int layoutY = 50;
    private final int layoutX = 100;
    List<VBox> contenedores;
    List<Curso> horario;
    public ContenedorCreator(List<Curso> horario){
        this.horario = horario;
        this.contenedores = new ArrayList<>();
    }
    public void crearContenedores() {
        for (Curso curso : horario) {
            VBox contenedor = new VBox();
            decorarContenedor(contenedor, curso);
            for (Horario h : curso.getHorarios()) {
                asignarArea(contenedor, h);
                contenedores.add(contenedor);
            }
        }
    }
    private Color generarColor(){
        Random random = new Random();
        int minColorValue = 153;
        int red = minColorValue + random.nextInt(256 - minColorValue);
        int green = minColorValue + random.nextInt(256 - minColorValue);
        int blue = minColorValue + random.nextInt(256 - minColorValue);
        return Color.rgb(red, green, blue);
    }
    private int asignarLayoutX(Horario h){
        switch (h.getDia()) {
            case "Lunes" : return 190;
            case "Martes" : return 280;
            case "Miércoles" : return 370;
            case "Jueves" : return 460;
            case "Viernes" : return 550;
            default : return 0;
        }
    }
    private void asignarArea(VBox c, Horario h) {
        c.setLayoutX(layoutX + asignarLayoutX(h));
        c.setLayoutY(layoutY + 90 * (h.getHoraInicio() - 7));
        c.setMinSize(90, h.getDiferencia());
        c.setMaxSize(90, h.getDiferencia());
    }
    private void decorarContenedor(VBox c, Curso curso){
        Label materia = new Label(curso.getMateria() + " " + curso.getParalelo());
        Label profesor = new Label(curso.getProfesor());
        profesor.setWrapText(true);
        c.getChildren().addAll(materia, profesor);
        c.setMaxWidth(90);
        c.setMinWidth(90);
        c.setPadding(new Insets(10, 5, 10, 5));
        BackgroundFill relleno = new BackgroundFill(generarColor(), CornerRadii.EMPTY, null);
        c.setBackground(new Background(relleno));
    }
}
