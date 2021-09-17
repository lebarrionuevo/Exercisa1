package edu.lautaro.ej1.vista.eventos;

import edu.lautaro.ej1.modelo.Tablero;
import edu.lautaro.ej1.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ChoiceDialog;
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


        ChoiceDialog<String> choiceDialog = new ChoiceDialog<>(" ", tablero.obtenerTareas());
        choiceDialog.setHeaderText("Select the task to edit");
        choiceDialog.setContentText("Choose your task:");

        Optional<String> resultado = choiceDialog.showAndWait();
        if (resultado.isPresent()) {
            String tareaAModificar;
            tareaAModificar = resultado.get();
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("");
            dialog.setHeaderText("Editing Task '" + tareaAModificar + "'");
            dialog.setContentText("Please rewrite the task: ");
            Optional<String> task = dialog.showAndWait();
            if (task.isPresent()) {
                String nuevaTarea;
                nuevaTarea = task.get();
                tablero.editarTareaExistente(tareaAModificar, nuevaTarea);
            }
        }
        vista.reiniciarListaDeTareas();
    }
}


