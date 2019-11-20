package application.algorithms;

import application.datastructures.Position;

public class Helper {
    
    private char[][] map;
    private int pathLength;
    
    public Helper(char[][] map) {
        this.map = map;
        this.pathLength = 0;
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
            neighbours[i] = new Position(-1, -1);
        }
        if (x < map.length - 1) {
            if (map[x + 1][y] == '.' || map[x + 1][y] == 'G') {
                neighbours[0] = new Position(x + 1, y);
            }
        }
        if (x > 0) {
            if (map[x - 1][y] == '.' || map[x - 1][y] == 'G') {
                neighbours[1] = new Position(x - 1, y);
            }
        }
        if (y < map[0].length - 1) {
            if (map[x][y + 1] == '.' || map[x][y + 1] == 'G') {
                neighbours[2] = new Position(x, y + 1);
            }
        }
        if (y > 0) {
            if (map[x][y - 1] == '.' || map[x][y - 1] == 'G') {
                neighbours[3] = new Position(x, y - 1);
            }
        }
        return neighbours;
    }
    /**
     * Draws the path to the map.
     * Path is marked with character 'p' from start 'S' to goal 'G'.
     * @param parents contains information from which position a certain position was travelled to.
     * @param start is the start position of the search.
     * @param goal is the goal position of the search.
     */
    public void drawPath(Position[][] parents, Position start, Position goal) {
        Position drawPosition = parents[goal.getX()][goal.getY()];
        while (drawPosition != null) {
            map[drawPosition.getX()][drawPosition.getY()] = 'p';
            pathLength++;
            drawPosition = parents[drawPosition.getX()][drawPosition.getY()];
        }
        map[start.getX()][start.getY()] = 'S';
    }

    public int getPathLength() {
        return pathLength;
    }        
    
}
