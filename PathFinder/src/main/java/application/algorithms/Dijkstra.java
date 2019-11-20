package application.algorithms;

import application.datastructures.Position;
import application.datastructures.Pair;
import application.datastructures.PriorityQueue;
/**
 * A class that implements Dijkstra's search algorithm.
 */
public class Dijkstra {
    
    private char[][] map;
    private boolean[][] visited;
    private int[][] distance;
    private Position[][] parents;
    private Position start;
    private Position goal;
    private int pathLength;
    private int stepsTaken;
    private boolean found;
    private Helper helper;
    
    /**
     * Constructor for Dijsktra.
     * Creates 3 supporting 2d arrays that match the size of the map.
     * @param map is the map where path is searched.
     * @param start is the starting position.
     * @param goal is the goal position.
     */
    public Dijkstra(char[][] map, Position start, Position goal) {
        this.map = map;
        this.visited = new boolean[map.length][map[0].length];
        this.distance = new int[map.length][map[0].length];
        this.parents = new Position[map.length][map[0].length];
        this.start = start;
        this.goal = goal;   
        this.pathLength = 0;
        this.stepsTaken = 0;
        this.found = false;
        this.helper = new Helper(map);
    }
    
    /**
     * Method that implements Dijkstra's search.
     * Uses a priorityQueue to find a path.
     * Draws a path to the original map when search is complete.
     */
    public void search() {
        initializeMatrixes();
       
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.add(new Pair(start, 0));
        
        while (!priorityQueue.isEmpty()) {
            Position currentPosition = priorityQueue.remove().getPosition();
            int currentX = currentPosition.getX();
            int currentY = currentPosition.getY();
            
            if (visited[currentX][currentY]) {
                continue;
            }
            visited[currentX][currentY] = true;
            if (visited[goal.getX()][goal.getY()]) break;
            stepsTaken++;
            
            for (Position neighbour : helper.generateNeighbours(currentPosition)) {
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
            helper.drawPath(parents, start, goal);
            pathLength = distance[goal.getX()][goal.getY()];
        }
    }   
    
    /**
     * Method to initialize supporting 2d arrays.
     */
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

    public int getPathLength() {
        return pathLength;
    }
    
    public int getStepsTaken() {
        return stepsTaken;
    }

    public boolean isFound() {
        return found;
    }

    public char[][] getMap() {
        return map;
    }

    public int[][] getDistance() {
        return distance;
    }  
}
