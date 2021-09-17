package edu.lautaro.ej1.modelo;

import java.util.ArrayList;
import java.util.Optional;
import java.util.OptionalInt;

public class Tablero {

    protected ArrayList<String> tareasDisponibles = new ArrayList<>();

    public void agregarTarea(String nuevaTarea) {
        tareasDisponibles.add(nuevaTarea);
    }
}
