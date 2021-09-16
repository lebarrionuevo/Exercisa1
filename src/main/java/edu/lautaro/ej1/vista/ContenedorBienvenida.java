package edu.lautaro.ej1.vista;

import edu.lautaro.ej1.vista.eventos.BotonEntrarEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class ContenedorBienvenida extends VBox {

    Stage stage;

    public ContenedorBienvenida(Stage stage, Scene proximaEscena) throws FileNotFoundException {

        super();

        this.stage = stage;

        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));


        Button botonEntrar = new Button();
        botonEntrar.setText("Entrar");

        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Tahoma", FontWeight.BOLD, 24));

        etiqueta.setText("Bienvenidos a la aplicación de tareas. Haga click en entrar");
        etiqueta.setTextFill(Color.web("#66A7C5"));

        BotonEntrarEventHandler botonEntrarHandler = new BotonEntrarEventHandler(stage, proximaEscena);
        botonEntrar.setOnAction(botonEntrarHandler);

        this.getChildren().addAll(etiqueta, botonEntrar);
    }
}
