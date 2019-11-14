package application.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DijkstraTest {
    
    Dijkstra dijkstra;
    
    @Test
    public void goalIsFoundFromStart1() {
        char[][] map = {
            {'T','.','.','.','.','W'},
            {'T','.','W','@','.','W'},
            {'W','.','W','@','.','S'},
            {'W','.','T','W','.','W'},
            {'W','.','.','W','W','W'},
            {'W','W','.','.','.','G'},
        };
        Position start = new Position(2,5);
        Position goal = new Position(5,5);
        dijkstra = new Dijkstra(map, start, goal);
        dijkstra.search();
        assertTrue(dijkstra.isFound());
    }
    
    @Test
    public void goalIsFoundFromStart2() {
        char[][] map = {
            {'S','.','.','.','.','@'},
            {'.','.','T','T','.','G'},        
        };
        Position start = new Position(0,0);
        Position goal = new Position(1,5);
        dijkstra = new Dijkstra(map, start, goal);
        dijkstra.search();
        assertTrue(dijkstra.isFound());
    }
    
    @Test
    public void goalIsFoundFromStart3() {
        char[][] map = {
            {'W','S','W','W','W','W','W','W','W','W'},
            {'W','.','W','.','.','.','.','.','.','W'},
            {'W','.','W','@','.','T','@','W','.','W'},
            {'W','.','W','.','.','W','@','W','.','W'},
            {'W','.','W','.','T','W','@','W','.','W'},
            {'W','.','W','.','T','W','W','W','.','W'},
            {'W','.','W','.','T','W','W','W','.','W'},
            {'W','.','W','.','.','W','W','W','.','W'},
            {'W','.','W','T','.','W','G','.','.','W'},
            {'W','.','.','.','.','W','W','W','.','W'},
        
        };
        Position start = new Position(0,1);
        Position goal = new Position(8,6);
        dijkstra = new Dijkstra(map, start, goal);
        dijkstra.search();
        assertTrue(dijkstra.isFound());
    }
    
    @Test
    public void goalNotFoundIfObstacle1() {
        char[][] map = {
            {'T','.','.','.','.','W'},
            {'T','.','W','@','.','W'},
            {'W','.','W','@','.','S'},
            {'W','.','T','W','.','W'},
            {'W','.','.','W','W','W'},
            {'W','W','@','.','.','G'},
        };
        Position start = new Position(2,5);
        Position goal = new Position(5,5);
        dijkstra = new Dijkstra(map, start, goal);
        dijkstra.search();
        assertFalse(dijkstra.isFound());
    }
    
    @Test
    public void goalNotFoundIfObstacle2() {
        char[][] map = {
            {'W','S','W','W','W','W','W','W','W','W'},
            {'W','.','W','.','.','.','.','.','.','W'},
            {'W','.','W','@','.','T','@','W','.','W'},
            {'W','.','W','.','.','W','@','W','.','W'},
            {'W','.','W','.','T','W','@','W','.','W'},
            {'W','.','W','.','T','W','W','W','.','W'},
            {'W','.','W','.','T','W','W','W','.','W'},
            {'W','.','W','.','.','W','W','W','@','W'},
            {'W','.','W','T','.','W','G','.','.','W'},
            {'W','.','.','.','.','W','W','W','.','W'},
        
        };
        Position start = new Position(0,1);
        Position goal = new Position(8,6);
        dijkstra = new Dijkstra(map, start, goal);
        dijkstra.search();
        assertFalse(dijkstra.isFound());
    }
    
    @Test
    public void pathFoundIsShortest1() {
        char[][] map = {
            {'W','S','W','W','W','W','W','W','W','W'},
            {'W','.','W','.','.','.','.','.','.','W'},
            {'W','.','W','@','.','T','@','W','.','W'},
            {'W','.','W','.','.','W','@','W','.','W'},
            {'W','.','W','.','T','W','@','W','.','W'},
            {'W','.','.','.','T','W','W','W','.','W'},
            {'W','.','W','.','T','W','W','W','.','W'},
            {'W','.','W','.','.','W','W','W','.','W'},
            {'W','.','W','T','.','.','G','.','.','W'},
            {'W','.','.','.','.','W','W','W','.','W'},    
        };
        Position start = new Position(0,1);
        Position goal = new Position(8,6);
        dijkstra = new Dijkstra(map, start, goal);
        dijkstra.search();
        assertEquals(13, dijkstra.getPathLength());
    }
    
    @Test
    public void pathFoundIsShortest2() {
        char[][] map = {
            {'W','S','W','W','W','W','W','W','W','W'},
            {'W','.','W','G','.','.','.','.','.','W'},
            {'W','.','W','@','.','T','@','W','.','W'},
            {'W','.','W','.','.','W','@','W','.','W'},
            {'W','.','W','.','T','W','@','W','.','W'},
            {'W','.','.','.','T','W','W','W','.','W'},
            {'W','.','W','.','T','W','W','W','.','W'},
            {'W','.','W','.','.','W','W','W','.','W'},
            {'W','.','W','T','.','.','@','.','.','W'},
            {'W','.','.','.','.','W','W','W','.','W'},    
        };
        Position start = new Position(0,1);
        Position goal = new Position(1,3);
        dijkstra = new Dijkstra(map, start, goal);
        dijkstra.search();
        assertEquals(13, dijkstra.getPathLength());
    }
    
    @Test
    public void pathFoundIsShortest3() {
        char[][] map = {
            {'W','S','W','W','W','W','W','W','W','W'},
            {'W','.','.','.','.','.','.','.','.','W'},
            {'W','.','W','@','.','T','@','W','.','W'},
            {'W','.','W','.','.','W','@','W','.','W'},
            {'W','.','W','.','.','W','@','W','.','W'},
            {'W','.','@','.','.','W','W','W','.','W'},
            {'W','.','W','.','.','W','W','W','.','W'},
            {'W','.','W','.','.','W','W','W','.','W'},
            {'W','.','W','T','.','.','@','.','.','W'},
            {'W','.','.','G','.','W','W','W','.','W'},    
        };
        Position start = new Position(0,1);
        Position goal = new Position(9,3);
        dijkstra = new Dijkstra(map, start, goal);
        dijkstra.search();
        assertEquals(11, dijkstra.getPathLength());
    }
    
    @Test
    public void pathFoundIsShortest4() {
        char[][] map = {
            {'W','S','W','W','W','W','W','W','W','W'},
            {'W','.','.','.','.','.','.','.','.','W'},
            {'W','.','W','@','.','T','@','W','.','W'},
            {'W','.','W','.','.','W','@','W','.','W'},
            {'W','.','W','.','.','W','@','W','.','W'},
            {'W','.','@','.','.','W','W','W','.','W'},
            {'W','.','W','.','.','W','W','W','.','G'},
            {'W','.','W','.','.','W','W','W','.','W'},
            {'W','.','W','T','.','.','.','.','.','@'},
            {'W','.','.','.','.','W','W','W','.','W'},    
        };
        Position start = new Position(0,1);
        Position goal = new Position(6,9);
        dijkstra = new Dijkstra(map, start, goal);
        dijkstra.search();
        assertEquals(14, dijkstra.getPathLength());
    }
    
    @Test
    public void pathDrawIsCorrect1() {
        char[][] map = {
            {'S','.','.','.','.','@'},
            {'.','.','T','T','.','G'},        
        };
        char[][] pathMap = {
            {'S','p','p','p','p','@'},
            {'.','.','T','T','p','G'},        
        };
        Position start = new Position(0,0);
        Position goal = new Position(1,5);
        dijkstra = new Dijkstra(map, start, goal);
        dijkstra.search();
        assertArrayEquals(pathMap, dijkstra.getMap());
    }
    
    @Test
    public void pathDrawIsCorrect2() {
        char[][] map = {
            {'W','S','W','W','W','W','W','W','W','W'},
            {'W','.','W','.','.','@','.','.','.','W'},
            {'W','.','W','@','.','T','@','W','.','W'},
            {'W','.','W','.','.','W','@','W','.','W'},
            {'W','.','W','.','T','W','@','W','.','W'},
            {'W','.','.','.','T','W','W','W','.','W'},
            {'W','.','W','.','T','W','W','W','.','W'},
            {'W','.','W','.','.','W','W','W','.','W'},
            {'W','.','W','T','.','.','G','.','.','W'},
            {'W','.','.','.','.','W','W','W','.','W'},    
        };
        char[][] pathMap = {
            {'W','S','W','W','W','W','W','W','W','W'},
            {'W','p','W','.','.','@','.','.','.','W'},
            {'W','p','W','@','.','T','@','W','.','W'},
            {'W','p','W','.','.','W','@','W','.','W'},
            {'W','p','W','.','T','W','@','W','.','W'},
            {'W','p','p','p','T','W','W','W','.','W'},
            {'W','.','W','p','T','W','W','W','.','W'},
            {'W','.','W','p','p','W','W','W','.','W'},
            {'W','.','W','T','p','p','G','.','.','W'},
            {'W','.','.','.','.','W','W','W','.','W'},    
        };
        Position start = new Position(0,1);
        Position goal = new Position(8,6);
        dijkstra = new Dijkstra(map, start, goal);
        dijkstra.search();
        assertArrayEquals(pathMap, dijkstra.getMap());
    }

}
