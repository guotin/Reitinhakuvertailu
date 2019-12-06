package application.datastructures;

/**
 * Class that creates a pair with a position and its distance. 
 * Used with priorityQueue.
 */
public class Pair implements Comparable<Pair> {
    private Position position;
    private int distance;
    
    public Pair(Position position, int distance) {
        this.position = position;
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public int compareTo(Pair o) {
        return this.distance - o.distance;
    }  
}
