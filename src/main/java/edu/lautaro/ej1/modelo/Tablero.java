package edu.lautaro.ej1.modelo;

import java.util.ArrayList;

public class Tablero {

    protected ArrayList<String> tareasDisponibles = new ArrayList<>();

    public void agregarTarea(String nuevaTarea) {
        tareasDisponibles.add(nuevaTarea);
    }

    public void quitarTarea(String antiguaTarea) {
        if(tareasDisponibles.contains(antiguaTarea)){
            tareasDisponibles.remove(antiguaTarea);
        }
    }

    public ArrayList<String> obtenerTareas() {
        return tareasDisponibles;
    }

    public void editarTareaExistente(String tareaEditable, String tareaEditada) {
        if(tareasDisponibles.contains(tareaEditable)) {
            int posicionAModificar;
            posicionAModificar = tareasDisponibles.indexOf(tareaEditable);
            tareasDisponibles.set(posicionAModificar, tareaEditada);
        }
    }
}
