package application.domain;

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

    }

    public void findStartAndGoal() {
        if (this.map != null) {
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    if (map[i][j] == 'S') {
                        this.start = new Position(i, j);
                    } else if (map[i][j] == 'G') {
                        this.goal = new Position(i, j);
                    }
                    if (start != null && goal != null) {
                        break;
                    }
                }
            }
        }
    }

    public void findRouteDFS() {
        if (start == null || goal == null) {
            return;
        }
        DepthFirstSearch dfs = new DepthFirstSearch(map, start, goal);
        dfs.search(start.getX(), start.getY());
        if (dfs.isFound()) {
            this.dfsPathLength = dfs.getPathLength();
            this.dfsStepsTaken = dfs.getStepsTaken();
            this.dfsFoundPath = dfs.isFound();
            this.dfsMap = dfs.getMap();
            this.dfsMap[start.getX()][start.getY()] = 'S';
        }
    }
    
    public void findRouteDijkstra() {
        if (start == null || goal == null) {
            return;
        }
        Dijkstra dijkstra = new Dijkstra(map, start, goal);
        dijkstra.search();
        if (dijkstra.isFound()) {
            this.dijkstraPathLength = dijkstra.getPathLength();
            this.dijkstraFoundPath = dijkstra.isFound();
            this.dijkstraMap = dijkstra.getMap();
        }
    }

    public void findRouteAstar() {

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
    
    

}
