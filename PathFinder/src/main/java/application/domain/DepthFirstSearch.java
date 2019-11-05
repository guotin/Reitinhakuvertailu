package application.domain;

public class DepthFirstSearch {

    private char[][] map;
    private boolean[][] visited;
    private Position start;
    private Position goal;
    private int pathLength;
    private int stepsTaken;
    private boolean found;

    public DepthFirstSearch(char[][] map, Position start, Position goal) {
        this.map = map;
        this.visited = new boolean[map.length][map[0].length];
        this.start = start;
        this.goal = goal;
        this.found = false;
        this.pathLength = 0;
        this.stepsTaken = 0;
    }

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
