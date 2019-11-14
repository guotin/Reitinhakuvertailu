package application.ui;

import application.domain.Filereader;
import application.domain.Routefinder;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AppUI extends Application {

    private Filereader reader;
    private Routefinder route;
    private Canvas canvas;
    private GraphicsContext gc;
    private char[][] currentMap;
    private boolean map1;

    @Override
    public void start(Stage primaryStage) throws Exception {
        reader = new Filereader();
        route = new Routefinder();
        loadMap("map1.map");
        map1 = true;
        initCanvas();
        drawMap();
        GridPane buttonGrid = new GridPane();
        Button button1 = new Button("Solve");
        Button button2 = new Button("Change Map");
        buttonGrid.add(button1, 0, 0);
        buttonGrid.add(button2, 1, 0);
        ScrollPane scrollPane = new ScrollPane(canvas);
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(scrollPane);
        borderPane.setBottom(buttonGrid);

        button1.setOnAction((event) -> {
            findRoute();
            drawMap();
        });
        
        button2.setOnAction((event) -> {
            if (map1) {
                loadMap("map2.map");
            } else {
               loadMap("map1.map"); 
            }
            drawMap();
            map1 = !map1;
            
        });

        borderPane.setPrefSize(1024, 720);
        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void initCanvas() {
        canvas = new Canvas(1024, 1024);
        gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, 1024, 1024);
    }

    private void drawMap() {
        gc.scale(2, 2);
        for (int i = 0; i < currentMap.length; i++) {
            for (int j = 0; j < currentMap[0].length; j++) {
                if (currentMap[i][j] == '.') {
                    gc.setFill(Color.WHITE);
                } else if (currentMap[i][j] == 'G') {
                    gc.setFill(Color.RED);
                } else if (currentMap[i][j] == 'S') {
                    gc.setFill(Color.BLUE);
                } else if (currentMap[i][j] == 'p') {
                    gc.setFill(Color.GREEN);
                } else {
                    gc.setFill(Color.BLACK);
                }
                gc.fillRect(i, j, 1, 1);
            }
        }
        gc.scale(0.5, 0.5);

    }

    private void findRoute() {
        route.setMap(currentMap);
        route.findStartAndGoal();
        route.findRouteAstar();
        currentMap = route.copyArray(route.getAstarMap());
    }

    private void loadMap(String file) {
        char[][] map = reader.readFile(file, 512, 512);
        currentMap = map;
    }

}
