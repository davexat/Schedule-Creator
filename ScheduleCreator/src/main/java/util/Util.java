/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.Random;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 *
 * @author Pc
 */
public class Util {
    public static double convertirHora(double horaDecimal) {
        int horas = (int) horaDecimal;
        double minutosDecimal = horaDecimal - horas;
        int minutos = (int) (minutosDecimal * 100);
        double fraccionHora = minutos / 60.0;
        return horas + fraccionHora;
    }
    public static Color generarColor(){
        Random random = new Random();
        int minColorValue = 153;
        int red = minColorValue + random.nextInt(256 - minColorValue);
        int green = minColorValue + random.nextInt(256 - minColorValue);
        int blue = minColorValue + random.nextInt(256 - minColorValue);
        return Color.rgb(red, green, blue);
    }
    public static VBox copiarVBox(VBox original) {
        VBox copia = new VBox();
        copia.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
        copia.setLayoutX(original.getLayoutX());
        copia.setLayoutY(original.getLayoutY());
        copia.setPrefSize(original.getPrefWidth(), original.getPrefHeight());
        copia.setPadding(original.getPadding());
        copia.setBackground(original.getBackground());
        copiarLabels(original, copia);
        return copia;
    }
    private static void copiarLabels(VBox original, VBox copia){
        for (var child : original.getChildren()) {
            if (child instanceof Label) {
                Label originalLabel = (Label) child;
                Label copiedLabel = new Label(originalLabel.getText());
                copiedLabel.setWrapText(originalLabel.isWrapText());
                copia.getChildren().add(copiedLabel);
            }
        }
    }
}
