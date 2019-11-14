package application.domain;

//import java.util.PriorityQueue;

/**
 * A class that implements Astar-search-algorithm.
 */
public class Astar {
    
    private char[][] map;
    private boolean[][] visited;
    private int[][] distance;
    private Position[][] parents;
    private Position start;
    private Position goal;
    private int pathLength;
    private boolean found;
    
    /**
     * Constructor for Astar.
     * Creates 3 supporting 2d arrays that match the size of the map. 
     * @param map is the map where path is searched.
     * @param start is the starting position.
     * @param goal is the goal position.
     */
    public Astar(char[][] map, Position start, Position goal) {
        this.map = map;
        this.visited = new boolean[map.length][map[0].length];
        this.distance = new int[map.length][map[0].length];
        this.parents = new Position[map.length][map[0].length];
        this.start = start;
        this.goal = goal;   
        this.pathLength = 0;
        this.found = false;
    }
    
    /**
     * Method that implements Astar search.
     * Uses a priorityQueue to find a path.
     * Used heuristic is 'Manhattan distance' between two points.
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
            
            for (Position neighbour : generateNeighbours(currentPosition)) {
                if (neighbour.getX() == -1 || neighbour.getY() == -1) {
                    continue;
                }
                int currentDistance = distance[neighbour.getX()][neighbour.getY()];
                int newDistance = distance[currentX][currentY] + 1;
                if (newDistance < currentDistance) {
                    int distanceToGoal = Math.abs(currentX - goal.getX()) + Math.abs(currentY - goal.getY());
                    distance[neighbour.getX()][neighbour.getY()] = newDistance;
                    priorityQueue.add(new Pair(neighbour, newDistance + distanceToGoal));
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
    
    /**
     * Draws the path to the map.
     * Path is marked with character 'p' from start 'S' to goal 'G'.
     */
    public void drawPath() {
        Position drawPosition = parents[goal.getX()][goal.getY()];
        while (drawPosition != null) {
            map[drawPosition.getX()][drawPosition.getY()] = 'p';
            drawPosition = parents[drawPosition.getX()][drawPosition.getY()];
        }
        map[start.getX()][start.getY()] = 'S';
    }
    
    /**
     * Generates neighbouring positions for a given position in a 2d array.
     * Only positions with character '.' or 'G' are valid moves.
     * @param position is the position to which neighbours are generated.
     * @return a position array containing 4 values.
     * Impossible position value is marked with negative X and Y coordinates.
     */
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

    public char[][] getMap() {
        return map;
    }

    public int getPathLength() {
        return pathLength;
    }

    public boolean isFound() {
        return found;
    }

    public int[][] getDistance() {
        return distance;
    }
    
}
