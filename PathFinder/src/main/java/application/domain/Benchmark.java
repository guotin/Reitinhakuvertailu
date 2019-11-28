package application.domain;

import application.datastructures.Position;

/**
 * Class to benchmark all three search algorithms
 */
public class Benchmark {

    private Routefinder routefinder;
    private Position[] positions;
    private int mapChoice;
    private int iterations;

    private long astarTime;
    private long dijkstraTime;
    private long dfsTime;

    private long astarPathLength;
    private long dijkstraPathLength;
    private long dfsPathLength;

    private long astarStepsTaken;
    private long dijkstraStepsTaken;
    private long dfsStepsTaken;

    public Benchmark(Routefinder routefinder) {
        this.routefinder = routefinder;
        this.positions = new Position[8];
        this.astarTime = 0;
        this.dijkstraTime = 0;
        this.dfsTime = 0;
        this.astarPathLength = 0;
        this.dijkstraPathLength = 0;
        this.dfsPathLength = 0;
        this.astarStepsTaken = 0;
        this.dijkstraStepsTaken = 0;
        this.dfsStepsTaken = 0;
        this.mapChoice = 1;
        this.iterations = 500;
    }
    
    /**
     * Creates test positions based on map choice
     */
    public void initPositions() {
        if (mapChoice == 1) {
            positions[0] = new Position(208, 81);
            positions[1] = new Position(194, 100);
            positions[2] = new Position(183, 114);
            positions[3] = new Position(164, 144);
            positions[4] = new Position(417, 187);
            positions[5] = new Position(433, 245);
            positions[6] = new Position(486, 270);
            positions[7] = new Position(475, 354);
        } else if (mapChoice == 2) {
            positions[0] = new Position(364, 46);
            positions[1] = new Position(199, 23);
            positions[2] = new Position(102, 87);
            positions[3] = new Position(84, 361);
            positions[4] = new Position(360, 314);
            positions[5] = new Position(301, 293);
            positions[6] = new Position(503, 265);
            positions[7] = new Position(356, 204);
        } else {
            positions[0] = new Position(100, 23);
            positions[1] = new Position(220, 26);
            positions[2] = new Position(441, 140);
            positions[3] = new Position(89, 418);
            positions[4] = new Position(238, 308);
            positions[5] = new Position(496, 490);
            positions[6] = new Position(332, 480);
            positions[7] = new Position(293, 233);
        }

    }

    /**
     * Finds route between test positions as many times as wanted
     */
    public void startBenchmark() {
        resetStatistics();
        initPositions();
        int index = 0;
        for (int i = 0; i < iterations; i++) {
            if (index > 7) {
                index = 0;
            }
            routefinder.setStart(positions[index]);
            routefinder.setGoal(positions[7 - index]);
            routefinder.findRouteDFS();
            routefinder.findRouteAstar();
            routefinder.findRouteDijkstra();
            storeStatistics();
        }
    }
    
    /**
     * Calls routefinder's methods to gather statistics
     */
    public void storeStatistics() {
        astarTime += routefinder.getAstarTimeSpent();
        dijkstraTime += routefinder.getDijkstraTimeSpent();
        dfsTime += routefinder.getDfsTimeSpent();

        astarPathLength += routefinder.getAstarPathLength();
        dijkstraPathLength += routefinder.getDijkstraPathLength();
        dfsPathLength += routefinder.getDfsPathLength();

        astarStepsTaken += routefinder.getAstarStepsTaken();
        dijkstraStepsTaken += routefinder.getDijkstraStepsTaken();
        dfsStepsTaken += routefinder.getDfsStepsTaken();
    }
    
    /**
     * Resets everything before a new benchmark
     */
    public void resetStatistics() {
        astarTime = 0;
        dijkstraTime = 0;
        dfsTime = 0;
        astarPathLength = 0;
        dijkstraPathLength = 0;
        dfsPathLength = 0;
        astarStepsTaken = 0;
        dijkstraStepsTaken = 0;
        dfsStepsTaken = 0;
    }

    public void setIterations(int iterations) {
        this.iterations = iterations;
    }

    public long getAstarTime() {
        return astarTime;
    }

    public long getDfsTime() {
        return dfsTime;
    }

    public long getDijkstraTime() {
        return dijkstraTime;
    }

    public long getAvgAstarPathLength() {
        return astarPathLength / iterations;
    }

    public long getAvgDijkstraPathLength() {
        return dijkstraPathLength / iterations;
    }

    public long getAvgDfsPathLength() {
        return dfsPathLength / iterations;
    }

    public long getAvgAstarStepsTaken() {
        return astarStepsTaken / iterations;
    }

    public long getAvgDijkstraStepsTaken() {
        return dijkstraStepsTaken / iterations;
    }

    public long getAvgDfsStepsTaken() {
        return dfsStepsTaken / iterations;
    }

    public void setMapChoice(int mapChoice) {
        this.mapChoice = mapChoice;
    }

}
