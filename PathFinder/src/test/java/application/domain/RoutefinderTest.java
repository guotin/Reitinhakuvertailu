package application.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class RoutefinderTest {
    Routefinder routefinder;
    
    @Before
    public void setUp() {
        routefinder = new Routefinder();
    }
    
    @Test
    public void routefinderIsInitializedWithEmptyValues() {
        assertEquals(null, routefinder.getStart());
        assertEquals(null, routefinder.getGoal());
        assertEquals(0, routefinder.getDfsPathLength());
        assertEquals(0, routefinder.getDfsStepsTaken());
        assertFalse(routefinder.isDfsFoundPath());
    }
    
    @Test
    public void startAndGoalAreFound1() {
        char[][] map = {
            {'.','.','.','.','.','W'},
            {'.','.','W','W','.','W'},
            {'W','.','W','W','.','S'},
            {'W','.','.','W','.','W'},
            {'W','W','.','W','W','W'},
            {'W','W','.','.','.','G'},
        };
        routefinder.setMap(map);
        routefinder.findStartAndGoal();
        assertEquals(2, routefinder.getStart().getX());
        assertEquals(5, routefinder.getStart().getY());
        assertEquals(5, routefinder.getGoal().getX());
        assertEquals(5, routefinder.getGoal().getY());
    }
    
    @Test
    public void startAndGoalAreFound2() {
        char[][] map = {
            {'S','.','.','.','.','W'},
            {'.','.','W','W','.','G'},        
        };
        routefinder.setMap(map);
        routefinder.findStartAndGoal();
        assertEquals(0, routefinder.getStart().getX());
        assertEquals(0, routefinder.getStart().getY());
        assertEquals(1, routefinder.getGoal().getX());
        assertEquals(5, routefinder.getGoal().getY());
    }
    
    @Test
    public void startAndGoalAreFound3() {
        char[][] map = {
            {'W','S','W','W','W','W','W','W','W','W'},
            {'W','.','W','.','.','.','.','.','.','W'},
            {'W','.','W','W','.','W','W','W','.','W'},
            {'W','.','W','.','.','W','W','W','.','W'},
            {'W','.','W','.','W','W','W','W','.','W'},
            {'W','.','W','.','W','W','W','W','.','W'},
            {'W','.','W','.','W','W','W','W','.','W'},
            {'W','.','W','.','.','W','W','W','.','W'},
            {'W','.','W','W','.','W','G','.','.','W'},
            {'W','.','.','.','.','W','W','W','.','W'},    
        };
        routefinder.setMap(map);
        routefinder.findStartAndGoal();
        assertEquals(0, routefinder.getStart().getX());
        assertEquals(1, routefinder.getStart().getY());
        assertEquals(8, routefinder.getGoal().getX());
        assertEquals(6, routefinder.getGoal().getY());
    }
    
    @Test
    public void startNotFoundWhenNotExist() {
        char[][] map = {
            {'W','W','W','W','W','W','W','W','W','W'},
            {'W','.','W','.','.','.','.','.','.','W'},
            {'W','.','W','W','.','W','W','W','.','W'},
            {'W','.','W','.','.','W','W','W','.','W'},
            {'W','.','W','.','W','W','W','W','.','W'},
            {'W','.','W','.','W','W','W','W','.','W'},
            {'W','.','W','.','W','W','W','W','.','W'},
            {'W','.','W','.','.','W','W','W','.','W'},
            {'W','.','W','W','.','W','G','.','.','W'},
            {'W','.','.','.','.','W','W','W','.','W'},    
        };
        routefinder.setMap(map);
        routefinder.findStartAndGoal();
        assertEquals(null, routefinder.getStart());     
    }
    
    @Test
    public void goalNotFoundWhenNotExist() {
        char[][] map = {
            {'W','W','W','W','W','W','W','W','W','W'},
            {'W','.','W','.','.','.','.','.','.','W'},
            {'W','.','W','W','.','W','W','W','.','W'},
            {'W','.','W','.','.','W','W','W','.','W'},
            {'W','.','W','.','W','W','W','W','.','W'},
            {'W','.','W','S','W','W','W','W','.','W'},
            {'W','.','W','.','W','W','W','W','.','W'},
            {'W','.','W','.','.','W','W','W','.','W'},
            {'W','.','W','W','.','W','W','.','.','W'},
            {'W','.','.','.','.','W','W','W','.','W'},    
        };
        routefinder.setMap(map);
        routefinder.findStartAndGoal();
        assertEquals(null, routefinder.getGoal()); 
    }
    
    @Test
    public void dfsChangesValuesIfPathFound() {
        char[][] map = {
            {'S','.','.','.','.','W'},
            {'.','.','W','W','.','G'},        
        };
        routefinder.setMap(map);
        routefinder.findStartAndGoal();
        routefinder.findRouteDFS();
        assertFalse(0 == routefinder.getDfsPathLength());
        assertFalse(0 == routefinder.getDfsStepsTaken());
        assertTrue(routefinder.isDfsFoundPath());
    }
    
    @Test
    public void dfsDoesNotSearchIfNoStart() {
        char[][] map = {
            {'W','.','.','.','.','W'},
            {'.','.','W','W','.','G'},        
        };
        routefinder.setMap(map);
        routefinder.findStartAndGoal();
        routefinder.findRouteDFS();
        assertTrue(0 == routefinder.getDfsPathLength());
        assertTrue(0 == routefinder.getDfsStepsTaken());
        assertFalse(routefinder.isDfsFoundPath());
    }
    
    @Test
    public void dfsDoesNotSearchIfNoGoal() {
        char[][] map = {
            {'W','.','.','.','.','W'},
            {'.','.','W','W','.','W'},        
        };
        routefinder.setMap(map);
        routefinder.findStartAndGoal();
        routefinder.findRouteDFS();
        assertTrue(0 == routefinder.getDfsPathLength());
        assertTrue(0 == routefinder.getDfsStepsTaken());
        assertFalse(routefinder.isDfsFoundPath());
    }
    
}
