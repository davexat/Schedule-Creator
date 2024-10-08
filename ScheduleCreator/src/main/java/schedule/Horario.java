/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schedule;

/**
 *
 * @author Pc
 */
public class Horario {
    private String dia;
    private double horaInicio;
    private double horaFin;
    public Horario(String dia, double horaInicio, double horaFin) {
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.dia = dia;
    }
    public double getDiferencia(){
        return horaFin - horaInicio;
    }
    public boolean esCompatible(Horario h){
        if (!this.dia.equalsIgnoreCase(h.dia)) return true;
        return this.horaFin <= h.horaInicio || this.horaInicio >= h.horaFin;
    }
    public String getDia() {
        return dia;
    }
    public double getHoraInicio() {
        return horaInicio;
    }
    public double getHoraFin() {
        return horaFin;
    }
}
