package edu.lautaro.ej1.vista.eventos;

import edu.lautaro.ej1.modelo.Tablero;
import edu.lautaro.ej1.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;

public class BotonEditarTareasHandler implements EventHandler<ActionEvent> {

    ContenedorPrincipal vista;
    Tablero tablero;

    public BotonEditarTareasHandler(ContenedorPrincipal contenedorPrincipal, Tablero tablero) {
        this.vista = contenedorPrincipal;
        this.tablero = tablero;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Add new Task");
        dialog.setHeaderText("Add a new task for your list");
        dialog.setContentText("Please write your task: ");
        Optional<String> resultado = dialog.showAndWait();
        if (resultado.isPresent()){
            String nuevaTarea;
            nuevaTarea = resultado.get();
            vista.agregarTareas(nuevaTarea);
            tablero.agregarTarea(nuevaTarea);
        }
    }
}
