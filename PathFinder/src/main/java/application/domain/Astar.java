package application.domain;

public class Astar {
    
    private char[][] map;
    private Position start;
    private Position goal;
    
    public Astar(char[][] map, Position start, Position goal) {
        this.map = map;
        this.start = start;
        this.goal = goal;
    }
       
    public void search() {
        
    }

    public void setMap(char[][] map) {
        this.map = map;
    }
    
}
