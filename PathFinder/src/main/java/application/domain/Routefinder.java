package application.domain;

import application.datastructures.Position;
import application.algorithms.Astar;
import application.algorithms.DepthFirstSearch;
import application.algorithms.Dijkstra;

/**
 * Class used to handle routefinding in a given map.
 * Stores the original map and all modified maps.
 * Also stores information about paths.
 */
public class Routefinder {

    private char[][] map;
    private Position start;
    private Position goal;
    private char startReplaceHolder;
    private char goalReplaceHolder;

    private char[][] dfsMap;
    private int dfsPathLength;
    private int dfsStepsTaken;
    private boolean dfsFoundPath;
    private long dfsTimeSpent;
    
    private char[][] dijkstraMap;
    private int dijkstraPathLength;
    private int dijkstraStepsTaken;
    private boolean dijkstraFoundPath;
    private long dijkstraTimeSpent;
    
    private char[][] astarMap;
    private int astarPathLength;
    private int astarStepsTaken;
    private boolean astarFoundPath;
    private long astarTimeSpent;

    /**
     * Constructor for Routefinder.
     */
    public Routefinder() {
        this.map = null;
        this.start = null;
        this.goal = null;
        this.startReplaceHolder = 'H';
        this.goalReplaceHolder = 'H';

        this.dfsMap = null;
        this.dfsPathLength = 0;
        this.dfsStepsTaken = 0;
        this.dfsFoundPath = false;
        this.dfsTimeSpent = 0;
        
        this.dijkstraMap = null;
        this.dijkstraPathLength = 0;
        this.dijkstraStepsTaken = 0;
        this.dijkstraFoundPath = false;
        this.dijkstraTimeSpent = 0;
        
        this.astarMap = null;
        this.astarPathLength = 0;
        this.astarStepsTaken = 0;
        this.astarFoundPath = false;
        this.astarTimeSpent = 0;
    }
    
    /**
     * Finds start and end nodes in the original map.
     * Char 'S' stands for start-node and Char 'G' for goal-node.
     */
    public void findStartAndGoal() {
        if (map != null) {
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    if (map[i][j] == 'S') {
                        start = new Position(i, j);
                    } else if (map[i][j] == 'G') {
                        goal = new Position(i, j);
                    }
                    if (start != null && goal != null) {
                        break;
                    }
                }
            }
        }
    }
    
    /**
     * Copies a given 2d char array.
     * Used to create new maps with search algorithms.
     * @param array is the array to be copied.
     * @return a new 2d char array.
     */
    public char[][] copyArray(char[][] array) {
        char[][] copy = new char[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                copy[i][j] = array[i][j];
            }
        }
        return copy;
    }
    
    /**
     * Calls DepthFirstSearch-class if start and goal are known.
     * Stores DepthFirstSearch data if search was successful.
     */
    public void findRouteDFS() {
        if (start == null || goal == null) {
            return;
        }
        char[][] mapCopy = copyArray(map);
        DepthFirstSearch dfs = new DepthFirstSearch(mapCopy, start, goal);
        dfsTimeSpent = System.currentTimeMillis();
        dfs.search();
        if (dfs.isFound()) {
            dfsPathLength = dfs.getPathLength();
            dfsStepsTaken = dfs.getStepsTaken();
            dfsFoundPath = dfs.isFound();
            dfsMap = dfs.getMap();
            dfsTimeSpent = System.currentTimeMillis() - dfsTimeSpent;
        }
    }
    
    /**
     * Calls Dijkstra-class if start and goal are known.
     * Stores Dijkstra data if search was successful.
     */
    public void findRouteDijkstra() {
        if (start == null || goal == null) {
            return;
        }
        char[][] mapCopy = copyArray(map);
        Dijkstra dijkstra = new Dijkstra(mapCopy, start, goal);
        dijkstraTimeSpent = System.currentTimeMillis();
        dijkstra.search();
        if (dijkstra.isFound()) {
            dijkstraPathLength = dijkstra.getPathLength();
            dijkstraStepsTaken = dijkstra.getStepsTaken();
            dijkstraFoundPath = dijkstra.isFound();
            dijkstraMap = dijkstra.getMap();
            dijkstraTimeSpent = System.currentTimeMillis() - dijkstraTimeSpent;
        }
    }
    
    /**
     * Calls Astar-class if start and goal known.
     * Stores Astar data if search was successful.
     */
    public void findRouteAstar() {
        if (start == null || goal == null) {
            return;
        }
        char[][] mapCopy = copyArray(map);
        Astar astar = new Astar(mapCopy, start, goal);
        astarTimeSpent = System.currentTimeMillis();
        astar.search();
        if (astar.isFound()) {
            astarPathLength = astar.getPathLength();
            astarStepsTaken = astar.getStepsTaken();
            astarFoundPath = astar.isFound();
            astarMap = astar.getMap();
            astarTimeSpent = System.currentTimeMillis() - astarTimeSpent;
        }
    }
    
    /**
     * Sets the goal position and draws a character 'G' to map.
     * Stores real map character to draw original map when goal is changed.
     * @param goal is the new goal position.
     */
    public void setGoal(Position goal) {
        if (goalReplaceHolder != 'H' && this.goal != null) {
            map[this.goal.getX()][this.goal.getY()] = goalReplaceHolder;
        }
        goalReplaceHolder = map[goal.getX()][goal.getY()];
        map[goal.getX()][goal.getY()] = 'G';
        this.goal = goal;
    }
    
    /**
     * Sets the start position and draws a character 'S' to map.
     * Stores real map character to draw original map when start is changed.
     * @param start is the new start position.
     */
    public void setStart(Position start) {
        if (startReplaceHolder != 'H' && this.start != null) {
            map[this.start.getX()][this.start.getY()] = startReplaceHolder;
        }
        startReplaceHolder = map[start.getX()][start.getY()];
        map[start.getX()][start.getY()] = 'S';
        this.start = start;
    }
    
    public Position getStart() {
        return start;
    }

    public Position getGoal() {
        return goal;
    }

    public void setMap(char[][] map) {
        this.astarFoundPath = false;
        this.dijkstraFoundPath = false;
        this.dfsFoundPath = false;
        this.goal = null;
        this.start = null;
        this.map = map;
    }

    public char[][] getMap() {
        return map;
    }

    public char[][] getDfsMap() {
        return dfsMap;
    }

    public int getDfsPathLength() {
        return dfsPathLength;
    }

    public int getDfsStepsTaken() {
        return dfsStepsTaken;
    }

    public boolean isDfsFoundPath() {
        return dfsFoundPath;
    }

    public long getDfsTimeSpent() {
        return dfsTimeSpent;
    }

    public int getDijkstraPathLength() {
        return dijkstraPathLength;
    }

    public int getDijkstraStepsTaken() {
        return dijkstraStepsTaken;
    }
    
    public boolean isDijkstraFoundPath() {
        return dijkstraFoundPath;
    }

    public char[][] getDijkstraMap() {
        return dijkstraMap;
    }

    public long getDijkstraTimeSpent() {
        return dijkstraTimeSpent;
    }

    public char[][] getAstarMap() {
        return astarMap;
    }

    public int getAstarPathLength() {
        return astarPathLength;
    }

    public int getAstarStepsTaken() {
        return astarStepsTaken;
    }  

    public boolean isAstarFoundPath() {
        return astarFoundPath;
    }

    public long getAstarTimeSpent() {
        return astarTimeSpent;
    }  
}
