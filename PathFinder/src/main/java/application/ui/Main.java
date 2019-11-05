package application.ui;

import application.domain.Routefinder;

public class Main {
    public static void main(String[] args) {
        //AppUI ui = new AppUI();
        char[][] kartta = {
            {'S','.','.','.','.','W'},
            {'.','.','W','W','.','G'},        
        };
//        char[][] kartta = {
//            {'.','.','.','.','.','W'},
//            {'.','.','W','W','.','W'},
//            {'W','.','W','W','.','S'},
//            {'W','.','.','.','.','W'},
//            {'W','W','.','W','W','W'},
//            {'W','W','.','.','.','G'},
//        };
        Routefinder route = new Routefinder();
        route.setMap(kartta);
        route.findStartAndGoal();
        System.out.println(route.getStart().getX());
        System.out.println(route.getStart().getY());
        System.out.println("-----");
        System.out.println(route.getGoal().getX());
        System.out.println(route.getGoal().getY());
//        
//        char[][] dfsMap = route.findRouteDFS();
        for (int i = 0; i < kartta.length; i++) {
            System.out.println("");
            for (int j = 0; j < kartta[i].length; j++) {
                System.out.print(kartta[i][j]);
            }
        }
    }
}
