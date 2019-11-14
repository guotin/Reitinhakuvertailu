package application.ui;

import application.domain.Filereader;
import application.domain.Routefinder;


public class Main {

    public static void main(String[] args) {
        Filereader reader = new Filereader();
        char[][] map = reader.readFile("testmap1.map", 2, 6);
        System.out.println("Printing map");
        for (int i = 0; i < map.length; i++) {
            System.out.println("");
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j]);
            }
        }
        Routefinder route = new Routefinder();
        route.setMap(map);
        route.findStartAndGoal();
        route.findRouteDijkstra();
        System.out.println("");
        System.out.println("");
        System.out.println("Dijkstra path");
        char[][] dijkstra = route.getDijkstraMap();
        for (int i = 0; i < map.length; i++) {
            System.out.println("");
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(dijkstra[i][j]);
            }
        }               
    }

}
