/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schedule;

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
}
