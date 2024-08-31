/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

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
import schedule.Curso;
import schedule.Horario;

/**
 *
 * @author Pc
 */
public class ContenedorCreator {
    private final int layoutY = 50;
    private final int layoutX = 0;
    List<Curso> horario;
    public ContenedorCreator(List<Curso> horario){
        this.horario = horario;
    }
    public List<VBox> crearContenedores() {
        List<VBox> contenedores = new ArrayList<>();
        for (Curso curso : horario) {
            VBox plantilla = new VBox();
            decorarContenedor(plantilla, curso);
            for (Horario h : curso.getHorarios()) {
                asignarArea(plantilla, h);
                contenedores.add(Util.copiarVBox(plantilla));
            }
        }
        return contenedores;
    }
    private int asignarLayoutX(Horario h){
        int layout = 0;
        switch (h.getDia()) {
            case "Lunes" : layout = 200; break;
            case "Martes" : layout = 350; break;
            case "Miércoles" : layout = 500; break;
            case "Jueves" : layout = 650; break;
            case "Viernes" : layout = 800; break;
            default : layout = 0; break;
        }
        return layout;
    }
    private void asignarArea(VBox c, Horario h) {
        c.setLayoutX(layoutX + asignarLayoutX(h));
        c.setLayoutY(layoutY + 50*(h.getHoraInicio()-7));
        c.setPrefSize(150, 50*h.getDiferencia());
    }
    private void decorarContenedor(VBox c, Curso curso){
        Label materia = new Label(curso.getMateria() + " " + curso.getParalelo());
        Label profesor = new Label(curso.getProfesor());
        profesor.setWrapText(true);
        c.getChildren().addAll(materia, profesor);
        c.setPadding(new Insets(10, 5, 10, 5));
        BackgroundFill relleno = new BackgroundFill(Util.generarColor(), CornerRadii.EMPTY, Insets.EMPTY);
        c.setBackground(new Background(relleno));
    }
}
