package application.ui;

import application.domain.Filereader;
import application.datastructures.Position;
import application.domain.Benchmark;
import application.domain.Routefinder;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * JavaFX GUI
 */
public class AppUI extends Application {

    private Filereader reader;
    private Routefinder route;
    private Benchmark benchmark;
    private Canvas canvas;
    private GraphicsContext gc;
    private char[][] currentMap;
    private Position start;
    private Position goal;

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Init canvas and draw file 'map1.map'
        reader = new Filereader();
        route = new Routefinder();
        benchmark = new Benchmark(route);
        loadMap("map1.map");
        initCanvas();
        drawMap();

        //Gridpane for buttons
        GridPane buttonGrid = new GridPane();
        buttonGrid.setPadding(new Insets(20, 20, 20, 20));

        //Main functionality buttons
        Label mapSelectionLabel = new Label("Current map: map1.map");
        Button button1 = new Button("Change Map");
        Button button2 = new Button("Solve with Astar");
        Button button3 = new Button("Solve with DFS");
        Button button4 = new Button("Solve with Dijkstra");
        Button button5 = new Button("Benchmark");
        Button button6 = new Button("Info");

        //Start and goal selection
        RadioButton startSelection = new RadioButton("Start");
        RadioButton goalSelection = new RadioButton("Goal");
        ToggleGroup group = new ToggleGroup();
        startSelection.setToggleGroup(group);
        goalSelection.setToggleGroup(group);
        startSelection.setSelected(true);

        Label startPosition = new Label("Not yet selected");
        Label goalPosition = new Label("Not yet selected");
        
        //Benchmark map selection
        RadioButton benchmarkMapOne = new RadioButton("map1.map");
        RadioButton benchmarkMapTwo = new RadioButton("map2.map");
        RadioButton benchmarkMapThree = new RadioButton("map3.map");
        ToggleGroup benchmarkGroup = new ToggleGroup();
        benchmarkMapOne.setToggleGroup(benchmarkGroup);
        benchmarkMapTwo.setToggleGroup(benchmarkGroup);
        benchmarkMapThree.setToggleGroup(benchmarkGroup);
        benchmarkMapOne.setSelected(true);

        //Info table
        TextArea statistics = new TextArea();
        statistics.setMaxSize(400, 400);
        statistics.setEditable(false);
        
        //Benchmark iterations selector
        TextField benchmarkIterations = new TextField();
        benchmarkIterations.setText("500");
        
        //List of maps available
        ListView mapList = new ListView();
        for (int i = 1; i < 12; i++) {
            mapList.getItems().add("map" + i + ".map");
        }
        mapList.setMaxSize(200, 200);

        //Interface layout
        buttonGrid.add(new Label("List of available maps"), 0, 0);
        buttonGrid.add(mapSelectionLabel, 1, 0);
        buttonGrid.add(mapList, 0, 1);
        buttonGrid.add(button1, 1, 1);
        buttonGrid.add(new Label("Point selection:"), 1, 2);
        buttonGrid.add(new Label("Start position: "), 1, 3);
        buttonGrid.add(startPosition, 2, 3);
        buttonGrid.add(new Label("Goal position: "), 1, 4);
        buttonGrid.add(goalPosition, 2, 4);
        buttonGrid.add(startSelection, 2, 2);
        buttonGrid.add(goalSelection, 3, 2);
        buttonGrid.add(button2, 2, 1);
        buttonGrid.add(button3, 3, 1);
        buttonGrid.add(button4, 4, 1);
        buttonGrid.add(new Label("Information"), 5, 0);
        buttonGrid.add(statistics, 5, 1);
        buttonGrid.add(button6, 5, 2);
        buttonGrid.add(button5, 6, 1);
        buttonGrid.add(new Label("Benchmark map         "), 6, 2);
        buttonGrid.add(benchmarkMapOne, 6, 3);
        buttonGrid.add(benchmarkMapTwo, 6, 4);
        buttonGrid.add(benchmarkMapThree, 6, 5);
        buttonGrid.add(new Label("Benchmark iterations"),7,2);
        buttonGrid.add(benchmarkIterations, 7, 3);
              
        //Map change button functionality
        button1.setOnAction((event) -> {
            try {
                String selection = mapList.getFocusModel().getFocusedItem().toString();
                mapSelectionLabel.setText("Current map: " + selection);
                loadMap(selection);
                drawMap();
                statistics.setText("");
                startPosition.setText("Not yet selected");
                goalPosition.setText("Not yet selected");
                start = null;
                goal = null;
            } catch (NullPointerException e) {
            }
        });

        //Astar button functionality
        button2.setOnAction((event) -> {
            findRouteAstar();
            drawMap();
            boolean found = route.isAstarFoundPath();
            if (found) {
                int pathLength = route.getAstarPathLength();
                int steps = route.getAstarStepsTaken();
                long time = route.getAstarTimeSpent();
                statistics.setText("Tried to find path with A* algorithm \n \n"
                        + "Path was found! \n"
                        + "Path length: " + pathLength + "\n"
                        + "Steps taken (visited nodes): " + steps + "\n"
                        + "Time spent finding path: " + time + "ms");
            } else {
                statistics.setText("Tried to find path with A* algorithm \n \n"
                        + "Path was not found. \n");
            }
        });

        //Dfs button functionality
        button3.setOnAction((event) -> {
            findRouteDFS();
            drawMap();
            boolean found = route.isDfsFoundPath();
            if (found) {
                int pathLength = route.getDfsPathLength();
                int steps = route.getDfsStepsTaken();
                long time = route.getDfsTimeSpent();
                statistics.setText("Tried to find path with Depth-first-search \n \n"
                        + "Path was found! \n"
                        + "Path length: " + pathLength + "\n"
                        + "Steps taken (visited nodes): " + steps + "\n"
                        + "Time spent finding path: " + time + "ms");
            } else {
                statistics.setText("Tried to find path with Depth-first-search \n \n"
                        + "Path was not found. \n");
            }
        });

        //Dijkstra button functionality
        button4.setOnAction((event) -> {
            findRouteDijkstra();
            drawMap();
            boolean found = route.isDijkstraFoundPath();
            if (found) {
                int pathLength = route.getDijkstraPathLength();
                int steps = route.getDijkstraStepsTaken();
                long time = route.getDijkstraTimeSpent();
                statistics.setText("Tried to find path with Dijkstra's algorithm \n \n"
                        + "Path was found! \n"
                        + "Path length: " + pathLength + "\n"
                        + "Steps taken (visited nodes): " + steps + "\n"
                        + "Time spent finding path: " + time + "ms");
            } else {
                statistics.setText("Tried to find path with Dijkstra's algorithm \n \n"
                        + "Path was not found. \n");
            }
        });
        
        //Benchmark button functionality
        button5.setOnAction((event) -> {
            RadioButton selected = (RadioButton) benchmarkGroup.getSelectedToggle();
            String mapName = selected.getText();
            int iterations = Integer.valueOf(benchmarkIterations.getText());
            loadMap(mapName);
            drawMap();
            mapSelectionLabel.setText("Current map: " + mapName);
            benchmark.setMapChoice(Character.getNumericValue(mapName.charAt(3))); 
            benchmark.setIterations(iterations);
            benchmark.startBenchmark();
            statistics.setText("Benchmarked all 3 algorithms in: " + mapName + "\n"
                                + "Iterations: " + iterations + "\n"
                                + "Results:\n\n"
                                + "  Time spent finding paths:\n"
                                + "    A*-algorithm: " + benchmark.getAstarTime() + "ms\n"
                                + "    Dijkstra's-algorithm: " + benchmark.getDijkstraTime() + "ms\n"
                                + "    Depth-first-search: " + benchmark.getDfsTime() + "ms\n\n"
                                + "  Average path lengths:\n"
                                + "    A*-algorithm: " + benchmark.getAvgAstarPathLength() + "\n"
                                + "    Dijkstra's-algorithm: " + benchmark.getAvgDijkstraPathLength() + "\n"
                                + "    Depth-first-search: " + benchmark.getAvgDfsPathLength() + "\n\n"
                                + "  Average amount of positions visited:\n"
                                + "    A*-algorithm: " + benchmark.getAvgAstarStepsTaken() + "\n"
                                + "    Dijkstra's-algorithm: " + benchmark.getAvgDijkstraStepsTaken() + "\n"
                                + "    Depth-first-search: " + benchmark.getAvgDfsStepsTaken() + "\n\n");
        });
        
        //Info button functionality
        button6.setOnAction((event) -> {
            statistics.setText("Pathfinding functionality:\n"
                                + "* Choose a map from the list\n"
                                + "* Choose start and goal nodes by clicking the map\n"
                                + "* Select which algorithm to use with the labeled buttons\n"
                                + "* Path is drawn on the map and information is displayed here\n\n"
                                + "Benchmarking functionality:\n"
                                + "* Choose a benchmarking map from the specified selector\n"
                                + "* Choose the iteration amount by typing it in the specified box\n"
                                + "   (Warning: high amount of iterations might take very long to compute)\n"
                                + "* The benchmarking utility will now find paths between a set\n"
                                + "   of start and goal nodes and information is diplayed here ");
        });
              
        //Canvas click to set start or goal
        canvas.setOnMouseClicked((event) -> {
            RadioButton selected = (RadioButton) group.getSelectedToggle();
            if (selected.getText().equals("Start")) {
                Position newStart = new Position((int) event.getX() / 4, (int) event.getY() / 4);
                start = newStart;
                route.setStart(start);
                startPosition.setText(start.toString());

            } else {
                Position newGoal = new Position((int) event.getX() / 4, (int) event.getY() / 4);
                goal = newGoal;
                route.setGoal(goal);
                goalPosition.setText(goal.toString());
            }
            drawMap();
        });

        //Display everything
        ScrollPane scrollPane = new ScrollPane(canvas);
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(scrollPane);
        borderPane.setBottom(buttonGrid);
        borderPane.setPrefSize(1920, 1080);
        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initCanvas() {
        canvas = new Canvas(2048, 2048);
        gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, 2048, 2048);
    }

    private void drawMap() {
        gc.scale(4, 4);
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
        gc.scale(0.25, 0.25);
    }

    private void findRouteDijkstra() {
        route.findRouteDijkstra();
        if (route.isDijkstraFoundPath()) {
            currentMap = route.copyArray(route.getDijkstraMap());
        }
    }

    private void findRouteDFS() {
        route.findRouteDFS();
        if (route.isDfsFoundPath()) {
            currentMap = route.copyArray(route.getDfsMap());
        }
    }

    private void findRouteAstar() {
        route.findRouteAstar();
        if (route.isAstarFoundPath()) {
            currentMap = route.copyArray(route.getAstarMap());
        }
    }

    private void loadMap(String file) {
        char[][] map = reader.readFile(file, 512, 512);
        currentMap = map;
        route.setMap(map);
    }
}
