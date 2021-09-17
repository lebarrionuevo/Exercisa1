package edu.lautaro.ej1.vista;

import edu.lautaro.ej1.modelo.Tablero;
import edu.lautaro.ej1.vista.eventos.*;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class ContenedorPrincipal extends BorderPane {

    VBox contenedorCentral;
    VBox contenedorInferiorCentral;
    Tablero tablero;
    Stage stage;

    public ContenedorPrincipal(Stage stage, Tablero tablero) throws FileNotFoundException {

        this.tablero = tablero;
        this.setEspacioParaAdministrarTareas();
        this.stage = stage;
    }


    private void setEspacioParaAdministrarTareas(){

        Label etiqueta = new Label();
        etiqueta.setText(" List of tasks ");
        etiqueta.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 22));
        etiqueta.setTextFill(Color.GREEN);
        VBox contenedorCentral = new VBox(etiqueta);
        contenedorCentral.setSpacing(1);
        contenedorCentral.setPadding(new Insets(15));

        this.contenedorCentral = contenedorCentral;
        this.setCenter(contenedorCentral);

        Button botonAgregarTarea = new Button();
        botonAgregarTarea.setText("Add Task");
        botonAgregarTarea.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 18));
        botonAgregarTarea.setTextFill(Color.GREEN);
        BotonAgregarTareaHandler AgregarTareaHandler = new BotonAgregarTareaHandler(this, tablero);
        botonAgregarTarea.setOnAction(AgregarTareaHandler);

        Button botonEditarTareas = new Button();
        botonEditarTareas.setText("Edit Tasks");
        botonEditarTareas.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 18));
        botonEditarTareas.setTextFill(Color.GREEN);
        BotonEditarTareasHandler EditarTareasHandler = new BotonEditarTareasHandler(this, tablero);
        botonEditarTareas.setOnAction(EditarTareasHandler);

        Button botonEliminarTareas = new Button();
        botonEliminarTareas.setText("Delete Tasks");
        botonEliminarTareas.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 18));
        botonEliminarTareas.setTextFill(Color.GREEN);
        BotonEliminarTareasHandler EliminarTareasHandler = new BotonEliminarTareasHandler(this, tablero);
        botonEliminarTareas.setOnAction(EliminarTareasHandler);

        VBox contenedorInferior = new VBox(botonAgregarTarea, botonEditarTareas, botonEliminarTareas);
        contenedorInferior.setSpacing(1);
        contenedorInferior.setPadding(new Insets(15));

        this.contenedorInferiorCentral = contenedorInferior;
        this.setBottom(contenedorInferiorCentral);

    }


    public void agregarTareas(String tarea){

        // create a checkbox
        CheckBox c = new CheckBox(tarea);

        // set IndeterMinate
        c.setIndeterminate(true);

        this.contenedorCentral.getChildren().add(c);
    }

    public void reiniciarListaDeTareas() {
        this.contenedorCentral.getChildren().clear();
        Label etiqueta = new Label();
        etiqueta.setText(" List of tasks ");
        etiqueta.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 22));
        etiqueta.setTextFill(Color.GREEN);
        VBox contenedorCentral = new VBox(etiqueta);
        contenedorCentral.setSpacing(1);
        contenedorCentral.setPadding(new Insets(15));

        this.contenedorCentral = contenedorCentral;
        this.setCenter(contenedorCentral);
        this.renovarTareas();
    }

    public void renovarTareas(){

        for (int i = 0; i < tablero.obtenerTareas().size() ; i++) {

            this.agregarTareas(tablero.obtenerTareas().get(i));

        }
    }

}
