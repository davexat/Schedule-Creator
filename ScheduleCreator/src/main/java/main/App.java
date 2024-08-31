package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;
import schedule.Combinator;
import schedule.Curso;
import schedule.LectorArchivo;
import util.ContenedorCreator;

/**
 * JavaFX App
 */
public class App extends Application {
    public static LectorArchivo lector = new LectorArchivo("PlanificacionS4.txt");
    private static Scene scene;
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Schedule Combinator");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/img/icono.png")));
        scene = new Scene(loadFXML("schedule"), 1100, 600);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    public static void main(String[] args) {
        //cargarArchivo();
        launch();
    }
    /*
    public static void cargarArchivo(){
        for (List<Curso> horario: new Combinator(lector).generarCombinacionesConFiltro(new ArrayList<>())){
            System.out.println(horario);
        }
    }*/
}