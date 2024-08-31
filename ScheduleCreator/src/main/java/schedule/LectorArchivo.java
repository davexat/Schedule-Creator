/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schedule;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Pc
 */
public class LectorArchivo {
    private File archivo;
    public LectorArchivo(String nombreArchivo){
        archivo = new File("files/"+nombreArchivo);
    }
    public HashMap<String, List<Curso>> leerArchivo(){
        HashMap<String, List<Curso>> cursos = new HashMap<>();
        try (BufferedReader bf = new BufferedReader(new FileReader(archivo))){
            separarDatos(cursos, bf);
        }catch (IOException ioe){
            System.out.println(ioe.getMessage());
        }
        return cursos;
    }
    private void separarDatos(HashMap<String, List<Curso>> cursos, BufferedReader bf) throws IOException {
        String linea;
        while ((linea = bf.readLine()) != null){
            String[] datos = linea.split(",");
            if (!cursos.containsKey(datos[0])) cursos.put(datos[0], new ArrayList<>());
            else cursos.get(datos[0]).add(crearCurso(datos));
        }
    }
    private Curso crearCurso(String[] datos) {
        Curso curso = new Curso(datos[0], datos[1], datos[2]);
        for (int i = 3; i < datos.length; i += 2) {
            Horario horario = crearHorario(datos[i], datos[i + 1]);
            curso.addHorario(horario);
        }
        return curso;
    }
    private Horario crearHorario(String dia, String formato) {
        String[] horas = formato.replace(":", ".").split("-");
        double horaIni = Double.parseDouble(horas[0].strip());
        double horaFin = Double.parseDouble(horas[1].strip());
        return new Horario(dia, Util.convertirHora(horaIni), Util.convertirHora(horaFin));
    }
}
