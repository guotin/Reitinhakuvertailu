package application.algorithms;

import application.datastructures.Position;
import application.datastructures.Stack;

/**
 * Class that implements Depth-first-search algorithm.
 */
public class DepthFirstSearch {

    private char[][] map;
    private boolean[][] visited;
    private Position[][] parents;
    private Position start;
    private Position goal;
    private int pathLength;
    private int stepsTaken;
    private boolean found;
    private Helper helper;

    /**
     * Constructor for Depth-first-search. Creates a boolean array to mark
     * visited positions.
     * @param map is the map where path is searched.
     * @param start is the starting position.
     * @param goal is the goal position.
     */
    public DepthFirstSearch(char[][] map, Position start, Position goal) {
        this.map = map;
        this.visited = new boolean[map.length][map[0].length];
        this.parents = new Position[map.length][map[0].length];
        this.start = start;
        this.goal = goal;
        this.found = false;
        this.pathLength = 0;
        this.stepsTaken = 0;
        this.helper = new Helper(map);
    }
    
    /**
     * Method that implements Depth-first-search by using a stack.
     * Draws the path and gets path length by calling Helper-class.
     */ 
    public void search() {
        initializeMatrixes();
        Stack stack = new Stack();
        stack.add(start);

        while (!stack.isEmpty()) {
            Position currentPosition = stack.pop();           
            if (visited[currentPosition.getX()][currentPosition.getY()]) {
                continue;
            }            
            visited[currentPosition.getX()][currentPosition.getY()] = true;
            if (visited[goal.getX()][goal.getY()]) {
                break;
            }
            stepsTaken++;
            for (Position neighbour : helper.generateNeighbours(currentPosition)) {
                if (neighbour.getX() == -1 || neighbour.getY() == -1) {
                    continue;
                }
                if (!visited[neighbour.getX()][neighbour.getY()]) {
                    stack.add(neighbour);
                    parents[neighbour.getX()][neighbour.getY()] = new Position(currentPosition.getX(), currentPosition.getY());
                }
            }
        }
        if (visited[goal.getX()][goal.getY()]) {
            found = true;
            helper.drawPath(parents, start, goal);
            pathLength = helper.getPathLength();
        }
    }
    
    /**
     * Method to initialize supporting 2d arrays.
     */
    public void initializeMatrixes() {
        for (int i = 0; i < this.map.length; i++) {
            for (int j = 0; j < this.map[0].length; j++) {
                visited[i][j] = false;
                parents[i][j] = null;
            }
        }
    }

    public char[][] getMap() {
        return map;
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
}
