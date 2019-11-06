package application.domain;

import java.util.PriorityQueue;

public class Dijkstra {
    
    private char[][] map;
    private boolean[][] visited;
    private int[][] distance;
    private Position[][] parents;
    private Position start;
    private Position goal;
    private int pathLength;
    private boolean found;
    
    public Dijkstra(char[][] map, Position start, Position goal) {
        this.map = map;
        this.visited = new boolean[map.length][map[0].length];
        this.distance = new int[map.length][map[0].length];
        this.parents = new Position[map.length][map[0].length];
        this.start = start;
        this.goal = goal;   
        this.pathLength = 0;
        this.found = false;
    }
    
    public void search() {
        initializeMatrixes();
        
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Pair(start, 0));
        
        while (!priorityQueue.isEmpty()) {
            Position currentPosition = priorityQueue.poll().getPosition();
            int currentX = currentPosition.getX();
            int currentY = currentPosition.getY();
            
            if (visited[currentX][currentY]) {
                continue;
            }
            visited[currentX][currentY] = true;
            
            for (Position neighbour : generateNeighbours(currentPosition)) {
                if (neighbour.getX() == -1 || neighbour.getY() == -1) {
                    continue;
                }
                int currentDistance = distance[neighbour.getX()][neighbour.getY()];
                int newDistance = distance[currentX][currentY] + 1;
                if (newDistance < currentDistance) {
                    distance[neighbour.getX()][neighbour.getY()] = newDistance;
                    priorityQueue.add(new Pair(neighbour, newDistance));
                    parents[neighbour.getX()][neighbour.getY()] = new Position(currentX, currentY);
                }
            }         
        }
        if (visited[goal.getX()][goal.getY()]) {
            found = true;
            drawPath();
            pathLength = distance[goal.getX()][goal.getY()];
        }
    }
    
    public void drawPath() {
        Position drawPosition = parents[goal.getX()][goal.getY()];
        while (drawPosition != null) {
            map[drawPosition.getX()][drawPosition.getY()] = 'p';
            drawPosition = parents[drawPosition.getX()][drawPosition.getY()];
        }
        map[start.getX()][start.getY()] = 'S';
    }
    
    public void initializeMatrixes() {
        for (int i = 0; i < this.map.length; i++) {
            for (int j = 0; j < this.map[0].length; j++) {
                distance[i][j] = Integer.MAX_VALUE;
                visited[i][j] = false;
                parents[i][j] = null;
            }
        }
        distance[start.getX()][start.getY()] = 0;
    }
    
    public Position[] generateNeighbours(Position position) {
        Position[] neighbours = new Position[4];
        int x = position.getX();
        int y = position.getY();
        for (int i = 0; i < 4; i++) {
            neighbours[i] = new Position(-1,-1);
        }
        if (x < map.length - 1) {
            if (map[x + 1][y] == '.' || map[x + 1][y] == 'G') {
                neighbours[0] = new Position(x+1, y);
            } 
        }
        if (x > 0) {
            if (map[x - 1][y] == '.' || map[x - 1][y] == 'G') {
                neighbours[1] = new Position(x-1, y);
            }
        }
        if (y < map[0].length - 1) {
            if (map[x][y + 1] == '.' || map[x][y + 1] == 'G') {
                neighbours[2] = new Position(x, y+1);
            }
        }
        if (y > 0) {
            if (map[x][y - 1] == '.' || map[x][y - 1] == 'G') {
                neighbours[3] = new Position(x, y-1);
            }
        }
        return neighbours;
    }

    public int getPathLength() {
        return pathLength;
    }

    public boolean isFound() {
        return found;
    }

    public char[][] getMap() {
        return map;
    }
    
    
    
}
