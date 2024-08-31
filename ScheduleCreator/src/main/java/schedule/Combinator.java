/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schedule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Pc
 */
public class Combinator {
    private HashMap<String, List<Curso>> cursosPorMateria;
    private List<List<Curso>> combinaciones;
    public Combinator(LectorArchivo lector) {
        this.cursosPorMateria = lector.leerArchivo();
        combinaciones = new ArrayList<>();
    }
    public List<List<Curso>> generarCombinacionesConFiltro(List<String> materiasExcluidas) {
        HashMap<String, List<Curso>> cursosFiltrados = new HashMap<>();
        for (String materia : cursosPorMateria.keySet()) {
            if (!materiasExcluidas.contains(materia)) {
                cursosFiltrados.put(materia, cursosPorMateria.get(materia));
            }
        }
        permutarElementos(new ArrayList<>(cursosFiltrados.values()), 0, new ArrayList<>());
        return combinaciones;
    }
    private void permutarElementos(List<List<Curso>> listasDeCursos, int index, List<Curso> combinacionActual) {
        if (index == listasDeCursos.size()) {
            combinaciones.add(new ArrayList<>(combinacionActual));
            return;
        }
        for (Curso curso : listasDeCursos.get(index)) {
            if (esCompatibleConTodos(combinacionActual, curso)) {
                combinacionActual.add(curso);
                permutarElementos(listasDeCursos, index + 1, combinacionActual);
                combinacionActual.remove(combinacionActual.size() - 1);
            }
        }
    }
    private static boolean esCompatibleConTodos(List<Curso> combinacionActual, Curso nuevoCurso) {
        for (Curso curso : combinacionActual) {
            if (!curso.esCompatible(nuevoCurso)) {
                return false;
            }
        }
        return true;
    }
}
