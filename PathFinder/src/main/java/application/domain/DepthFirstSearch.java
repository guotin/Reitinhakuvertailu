package application.domain;

/**
 * Class that implements Depth-first-search algorithm.
 */
public class DepthFirstSearch {

    private char[][] map;
    private boolean[][] visited;
    private Position start;
    private Position goal;
    private int pathLength;
    private int stepsTaken;
    private boolean found;
    
    /**
     * Constructor for Depth-first-search.
     * Creates a boolean array to mark visited positions.
     * @param map is the map where path is searched.
     * @param start is the starting position.
     * @param goal is the goal position.
     */
    public DepthFirstSearch(char[][] map, Position start, Position goal) {
        this.map = map;
        this.visited = new boolean[map.length][map[0].length];
        this.start = start;
        this.goal = goal;
        this.found = false;
        this.pathLength = 0;
        this.stepsTaken = 0;
    }
    
    /**
     * Method that implements Depth-first-search recursively.
     * All 4 neighbouring positions are considered recursively.
     * On each step the positions original character is replaced with 'p' for path.
     * If a recursive route does not find the goal it backtracks and replaces the placed 'p' with the original character.
     * Pathlength is calculated by doing addition and substraction with the same principle.
     * Search is finished when any route is found to the goal 'G' and characters 'p' mark the route.
     * @param x is the X coordinate.
     * @param y is the Y coordinate.
     */
    public void search(int x, int y) {
        if (x == goal.getX() && y == goal.getY()) {
            this.found = true;
        }
        if (this.found) {
            return;
        }

        pathLength++;
        stepsTaken++;
        char mapCharHolder = map[x][y];
        map[x][y] = 'p';
        visited[x][y] = true;
        if (x < map.length - 1) {
            if ((map[x + 1][y] == '.' || map[x + 1][y] == 'G') && !visited[x + 1][y]) {
                search(x + 1, y);
            }
        }
        if (x > 0) {
            if ((map[x - 1][y] == '.' || map[x - 1][y] == 'G') && !visited[x - 1][y]) {
                search(x - 1, y);
            }
        }
        if (y < map[0].length - 1) {
            if ((map[x][y + 1] == '.' || map[x][y + 1] == 'G') && !visited[x][y + 1]) {
                search(x, y + 1);
            }
        }
        if (y > 0) {
            if ((map[x][y - 1] == '.' || map[x][y - 1] == 'G') && !visited[x][y - 1]) {
                search(x, y - 1);
            }
        }
        if (this.found) {
            return;
        }
        pathLength--;
        map[x][y] = mapCharHolder;
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
