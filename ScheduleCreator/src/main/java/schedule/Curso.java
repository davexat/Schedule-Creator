/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schedule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Pc
 */
public class Curso {
    private String materia;
    private String profesor;
    private String paralelo;
    private List<Horario> horarios;
    public Curso(String materia, String profesor, String paralelo){
        this.materia = materia;
        this.profesor = profesor;
        this.paralelo = paralelo;
        horarios = new ArrayList<>();
    }
    public void addHorario(Horario horario){
        horarios.add(horario);
    }
    public String getMateria() {
        return materia;
    }
    public String getProfesor() {
        return profesor;
    }
    public String getParalelo() {
        return paralelo;
    }
    public List<Horario> getHorarios() {
        return Collections.unmodifiableList(horarios);
    }
    public boolean esCompatible(Curso c){
        for (Horario h1: this.horarios){
            for (Horario h2: c.horarios){
                if (!this.materia.equalsIgnoreCase(c.materia) && !h1.esCompatible(h2)) return false;
            }
        }
        return true;
    }
}
