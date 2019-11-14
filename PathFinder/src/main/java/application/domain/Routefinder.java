package application.domain;

/**
 * Class used to handle routefinding in a given map.
 * Stores the original map and all modified maps.
 * Also stores information about paths.
 */
public class Routefinder {

    private char[][] map;
    private Position start;
    private Position goal;

    private char[][] dfsMap;
    private int dfsPathLength;
    private int dfsStepsTaken;
    private boolean dfsFoundPath;
    
    private char[][] dijkstraMap;
    private int dijkstraPathLength;
    private boolean dijkstraFoundPath;
    
    private char[][] astarMap;
    private int astarPathLength;
    private boolean astarFoundPath;

    /**
     * Constructor for Routefinder.
     * Initializes all values to null or zero.
     */
    public Routefinder() {
        this.map = null;
        this.start = null;
        this.goal = null;

        this.dfsMap = null;
        this.dfsPathLength = 0;
        this.dfsStepsTaken = 0;
        this.dfsFoundPath = false;
        
        this.dijkstraMap = null;
        this.dijkstraPathLength = 0;
        this.dijkstraFoundPath = false;
        
        this.astarMap = null;
        this.astarPathLength = 0;
        this.astarFoundPath = false;

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
        dfs.search(start.getX(), start.getY());
        if (dfs.isFound()) {
            this.dfsPathLength = dfs.getPathLength();
            this.dfsStepsTaken = dfs.getStepsTaken();
            this.dfsFoundPath = dfs.isFound();
            this.dfsMap = dfs.getMap();
            this.dfsMap[start.getX()][start.getY()] = 'S';
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
        dijkstra.search();
        if (dijkstra.isFound()) {
            this.dijkstraPathLength = dijkstra.getPathLength();
            this.dijkstraFoundPath = dijkstra.isFound();
            this.dijkstraMap = dijkstra.getMap();
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
        astar.search();
        if (astar.isFound()) {
            this.astarPathLength = astar.getPathLength();
            this.astarFoundPath = astar.isFound();
            this.astarMap = astar.getMap();
        }
    }

    public Position getStart() {
        return start;
    }

    public Position getGoal() {
        return goal;
    }

    public void setMap(char[][] map) {
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

    public int getDijkstraPathLength() {
        return dijkstraPathLength;
    }

    public boolean isDijkstraFoundPath() {
        return dijkstraFoundPath;
    }

    public char[][] getDijkstraMap() {
        return dijkstraMap;
    }

    public char[][] getAstarMap() {
        return astarMap;
    }

    public int getAstarPathLength() {
        return astarPathLength;
    }

    public boolean isAstarFoundPath() {
        return astarFoundPath;
    }
}
