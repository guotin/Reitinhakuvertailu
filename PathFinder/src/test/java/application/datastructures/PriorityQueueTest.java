package application.datastructures;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class PriorityQueueTest {
    
    PriorityQueue pqueue;
    Position testPos;
    
    @Before
    public void setUp() {
        pqueue = new PriorityQueue();
        testPos = new Position(1,1);
    }
    
    @Test
    public void originalSizeIs5() {
        assertEquals(5, pqueue.getQueue().length);
    }
    
    @Test
    public void sizeIsDoubledWhenFull() {
        pqueue.add(new Pair(testPos, 3));
        pqueue.add(new Pair(testPos, 7));
        pqueue.add(new Pair(testPos, 5));
        pqueue.add(new Pair(testPos, 5));
        pqueue.add(new Pair(testPos, 5));
        assertEquals(10, pqueue.getQueue().length);
    }
    
    @Test
    public void negativeDistancePairsAreNotAdded() {
        pqueue.add(new Pair(testPos, 3));
        pqueue.add(new Pair(testPos, 7));
        pqueue.add(new Pair(testPos, -5));
        assertEquals(3, pqueue.remove().getDistance());
        assertEquals(1, pqueue.getElementCount());
    }
    
    @Test
    public void addingAndRemovingReturnsCorrect1() {
        pqueue.add(new Pair(testPos, 3));
        pqueue.add(new Pair(testPos, 7));
        pqueue.add(new Pair(testPos, 5));
        assertEquals(3, pqueue.remove().getDistance());
    }
    
    @Test
    public void addingAndRemovingReturnsCorrect2() {
        pqueue.add(new Pair(testPos, 3));
        pqueue.add(new Pair(testPos, 7));
        pqueue.add(new Pair(testPos, 5));
        pqueue.add(new Pair(testPos, 0));
        pqueue.add(new Pair(testPos, 11));
        pqueue.add(new Pair(testPos, 70000));
        assertEquals(0, pqueue.remove().getDistance());
    }
}
