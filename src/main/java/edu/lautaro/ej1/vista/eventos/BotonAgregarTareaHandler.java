package edu.lautaro.ej1.vista.eventos;

import edu.lautaro.ej1.modelo.Tablero;
import edu.lautaro.ej1.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class BotonAgregarTareaHandler implements EventHandler<ActionEvent> {

    ContenedorPrincipal vista;
    Tablero tablero;

    public BotonAgregarTareaHandler(ContenedorPrincipal contenedorPrincipal, Tablero tablero) {
        this.vista = contenedorPrincipal;
        this.tablero = tablero;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Label etiqueta = new Label();
        etiqueta.setText("Add Task"); //Que tarea queremos
        vista.agregarElementosAEjecutar(etiqueta);
    }
}

