package edu.lautaro.ej1;

import edu.lautaro.ej1.modelo.Tablero;
import edu.lautaro.ej1.vista.ContenedorBienvenida;
import edu.lautaro.ej1.vista.ContenedorPrincipal;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(final Stage stage) throws Exception{

        stage.setTitle("Tasks To-do");

        Tablero tablero = crearModelo();

        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage, tablero);
        Scene escenaJuego = new Scene(contenedorPrincipal, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE);

        ContenedorBienvenida contenedorBienvenidos = new ContenedorBienvenida(stage, escenaJuego);
        Scene escenaBienvenidos = new Scene(contenedorBienvenidos, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE);

        stage.setScene(escenaBienvenidos);
        stage.setFullScreen(true);

        stage.show();
    }

    private Tablero crearModelo() {
        //Terreno terreno = new Terreno(460,250);
        Tablero tablero = new Tablero();
        return tablero;
    }

    public static void main(String[] args) {
        launch();
    }

}
