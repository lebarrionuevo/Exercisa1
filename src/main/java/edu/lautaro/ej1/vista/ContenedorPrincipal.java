package edu.lautaro.ej1.vista;

import edu.lautaro.ej1.modelo.Tablero;
import edu.lautaro.ej1.vista.eventos.*;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Optional;

public class ContenedorPrincipal extends BorderPane {

    VBox contenedorVerticalDerecho;
    Canvas canvasCentral;
    VBox contenedorCentral;
    VBox contenedorInferiorCentral;
    //Canvas dibujoDelPersonaje;
    Stage stage;

    public ContenedorPrincipal(Stage stage, Tablero tablero) throws FileNotFoundException {

        //this.setCentro(tablero);
        //this.setConsola();

        this.setBotonera(tablero);
        this.setEspacioParaAgregarTarea(tablero);

        this.stage = stage;
    }


    private void setBotonera(Tablero tablero) throws FileNotFoundException {


        Button botonAgregarTarea = new Button();
        botonAgregarTarea.setStyle("-fx-background-color: #e129e5; ");
        botonAgregarTarea.setText("Add Task");
        botonAgregarTarea.setTextFill(Color.GREEN);
        BotonAgregarTareaHandler AgregarTareaHandler = new BotonAgregarTareaHandler(this, tablero);
        botonAgregarTarea.setOnAction(AgregarTareaHandler);
        botonAgregarTarea.setTranslateX(20);
        botonAgregarTarea.setTranslateY(-168);


        VBox contenedorVertical = new VBox(botonAgregarTarea);
        contenedorVertical.setSpacing(10);
        contenedorVertical.setPadding(new Insets(15));

        contenedorVertical.setPrefWidth(285);
        this.setLeft(contenedorVertical);
    }


    private void setEspacioParaAgregarTarea(Tablero tablero){

        Label etiqueta = new Label();
        etiqueta.setText(" Tareas ");
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

        VBox contenedorInferior = new VBox(botonAgregarTarea);
        contenedorInferior.setSpacing(1);
        contenedorInferior.setPadding(new Insets(15));

        this.contenedorInferiorCentral = contenedorInferior;
        this.setBottom(contenedorInferiorCentral);

    }


    public void agregarTareas(Label label){
        this.contenedorCentral.getChildren().add(label);
    }

    public void reiniciartareas() {
        this.contenedorCentral.getChildren().clear();
        Label etiqueta = new Label();
        etiqueta.setText(" Algoritmo ");
        etiqueta.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 22));
        etiqueta.setTextFill(Color.GREEN);
        this.agregarTareas(etiqueta);
    }

}
