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
        assertArrayEquals(null, routefinder.getDfsMap());
        
        assertArrayEquals(null, routefinder.getDijkstraMap());
        assertEquals(0, routefinder.getDijkstraPathLength());
        assertFalse(routefinder.isDijkstraFoundPath());
        
        assertArrayEquals(null, routefinder.getAstarMap());
        assertEquals(0, routefinder.getAstarPathLength());
        assertFalse(routefinder.isAstarFoundPath());
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
        assertEquals(0, routefinder.getDfsPathLength());
        assertEquals(0, routefinder.getDfsStepsTaken());
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
        assertEquals(0, routefinder.getDfsPathLength());
        assertEquals(0, routefinder.getDfsStepsTaken());
        assertFalse(routefinder.isDfsFoundPath());
    }
    
    @Test
    public void dijkstraChangesValuesIfPathFound() {
        char[][] map = {
            {'S','.','.','.','.','W'},
            {'.','.','T','W','.','G'},        
        };
        char[][] pathMap = {
            {'S','p','p','p','p','W'},
            {'.','.','T','W','p','G'},        
        };
        routefinder.setMap(map);
        routefinder.findStartAndGoal();
        routefinder.findRouteDijkstra();
        assertEquals(6, routefinder.getDijkstraPathLength());
        assertTrue(routefinder.isDijkstraFoundPath());
        assertArrayEquals(pathMap, routefinder.getDijkstraMap());   
    }
    
    @Test
    public void dijkstraDoesNotSearchIfNoStart() {
        char[][] map = {
            {'W','.','.','.','.','W'},
            {'.','.','W','W','.','G'},        
        };
        routefinder.setMap(map);
        routefinder.findStartAndGoal();
        routefinder.findRouteDijkstra();
        assertEquals(0, routefinder.getDijkstraPathLength());
        assertFalse(routefinder.isDijkstraFoundPath());
    }
    
    @Test
    public void dijkstraDoesNotSearchIfNoGoal() {
        char[][] map = {
            {'W','S','.','.','.','W'},
            {'.','.','W','W','.','W'},        
        };
        routefinder.setMap(map);
        routefinder.findStartAndGoal();
        routefinder.findRouteDijkstra();
        assertEquals(0, routefinder.getDijkstraPathLength());
        assertFalse(routefinder.isDijkstraFoundPath());
    }
    
    @Test
    public void astarChangesValuesIfPathFound() {
        char[][] map = {
            {'S','.','.','.','.','W'},
            {'.','T','.','W','.','G'},        
        };
        char[][] pathMap = {
            {'S','p','p','p','p','W'},
            {'.','T','.','W','p','G'},        
        };
        routefinder.setMap(map);
        routefinder.findStartAndGoal();
        routefinder.findRouteAstar();
        assertEquals(6, routefinder.getAstarPathLength());
        assertTrue(routefinder.isAstarFoundPath());
        assertArrayEquals(pathMap, routefinder.getAstarMap());   
    }
    
    @Test
    public void astarDoesNotSearchIfNoStart() {
        char[][] map = {
            {'W','.','.','.','.','W'},
            {'.','W','W','W','.','G'},        
        };
        routefinder.setMap(map);
        routefinder.findStartAndGoal();
        routefinder.findRouteAstar();
        assertEquals(0, routefinder.getAstarPathLength());
        assertFalse(routefinder.isAstarFoundPath());
    }
    
    @Test
    public void astarDoesNotSearchIfNoGoal() {
        char[][] map = {
            {'W','S','.','.','W','W'},
            {'.','.','W','W','W','W'},        
        };
        routefinder.setMap(map);
        routefinder.findStartAndGoal();
        routefinder.findRouteAstar();
        assertEquals(0, routefinder.getDfsPathLength());
        assertFalse(routefinder.isDijkstraFoundPath());
    }
    
    
    
}
