package edu.lautaro.ej1.vista.eventos;

import edu.lautaro.ej1.modelo.Tablero;
import edu.lautaro.ej1.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;

public class BotonEliminarTareasHandler implements EventHandler<ActionEvent> {

    ContenedorPrincipal vista;
    Tablero tablero;

    public BotonEliminarTareasHandler(ContenedorPrincipal contenedorPrincipal, Tablero tablero) {
        this.vista = contenedorPrincipal;
        this.tablero = tablero;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setHeaderText("Delete an existing Task");
        dialog.setContentText("Please write the task: ");
        Optional<String> resultado = dialog.showAndWait();
        if (resultado.isPresent()){
            String antiguaTarea;
            antiguaTarea = resultado.get();
            tablero.quitarTarea(antiguaTarea);
            vista.reiniciarListaDeTareas();
        }
    }
}
