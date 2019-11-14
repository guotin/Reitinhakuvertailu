package application.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AstarTest {
    
    Astar astar;
    
    @Test
    public void goalIsFoundFromStart1() {
        char[][] map = {
            {'T','.','.','.','.','S'},
            {'T','.','W','@','.','W'},
            {'W','.','W','@','.','@'},
            {'W','.','T','W','.','W'},
            {'W','.','.','W','W','W'},
            {'W','W','.','.','.','G'},
        };
        Position start = new Position(2,5);
        Position goal = new Position(5,5);
        astar = new Astar(map, start, goal);
        astar.search();
        assertTrue(astar.isFound());
    }
    
    @Test
    public void goalIsFoundFromStart2() {
        char[][] map = {
            {'S','.','.','.','.','@'},
            {'.','W','T','T','.','G'},        
        };
        Position start = new Position(0,0);
        Position goal = new Position(1,5);
        astar = new Astar(map, start, goal);
        astar.search();
        assertTrue(astar.isFound());
    }
    
    @Test
    public void goalIsFoundFromStart3() {
        char[][] map = {
            {'W','S','W','W','W','W','W','W','W','W'},
            {'W','.','W','.','.','.','.','.','.','W'},
            {'W','.','W','@','.','T','@','W','.','W'},
            {'W','.','W','.','.','W','@','W','.','W'},
            {'W','.','W','.','T','W','.','.','.','W'},
            {'W','.','W','.','T','.','W','W','.','W'},
            {'W','.','W','.','T','.','W','W','.','W'},
            {'W','.','W','.','.','.','W','W','.','W'},
            {'W','.','W','T','.','W','G','.','.','W'},
            {'W','.','.','.','.','W','W','W','.','W'},
        
        };
        Position start = new Position(0,1);
        Position goal = new Position(8,6);
        astar = new Astar(map, start, goal);
        astar.search();
        assertTrue(astar.isFound());
    }
    
    @Test
    public void goalNotFoundIfObstacle1() {
        char[][] map = {
            {'T','.','.','.','W','W'},
            {'T','.','W','@','.','W'},
            {'W','.','W','@','.','S'},
            {'W','.','T','W','.','W'},
            {'W','.','.','W','W','W'},
            {'W','W','@','.','.','G'},
        };
        Position start = new Position(2,5);
        Position goal = new Position(5,5);
        astar = new Astar(map, start, goal);
        astar.search();
        assertFalse(astar.isFound());
    }
    
    @Test
    public void goalNotFoundIfObstacle2() {
        char[][] map = {
            {'W','S','W','W','W','W','W','W','W','W'},
            {'W','.','W','.','.','.','.','.','.','W'},
            {'W','.','W','@','.','T','@','W','.','W'},
            {'W','.','W','.','.','W','@','W','.','W'},
            {'W','.','W','.','T','.','W','W','.','W'},
            {'W','.','W','.','T','.','W','W','.','W'},
            {'W','.','W','.','T','.','W','W','.','W'},
            {'W','.','W','.','.','W','.','W','@','W'},
            {'W','.','W','T','.','W','G','.','.','W'},
            {'W','.','.','.','.','W','W','W','.','W'},
        
        };
        Position start = new Position(0,1);
        Position goal = new Position(8,6);
        astar = new Astar(map, start, goal);
        astar.search();
        assertFalse(astar.isFound());
    }
    
    @Test
    public void pathFoundIsShortest1() {
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
        Position start = new Position(0,1);
        Position goal = new Position(8,6);
        astar = new Astar(map, start, goal);
        astar.search();
        assertEquals(13, astar.getPathLength());
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
        astar = new Astar(map, start, goal);
        astar.search();
        assertEquals(13, astar.getPathLength());
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
        astar = new Astar(map, start, goal);
        astar.search();
        assertEquals(11, astar.getPathLength());
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
        astar = new Astar(map, start, goal);
        astar.search();
        assertEquals(14, astar.getPathLength());
    }
    
    @Test
    public void pathDrawIsCorrect1() {
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
        astar = new Astar(map, start, goal);
        astar.search();
        assertArrayEquals(pathMap, astar.getMap());
    }
    
    @Test
    public void pathDrawIsCorrect2() {
        char[][] map = {
            {'W','S','W','W','W','W','W','W','W','W'},
            {'W','.','W','.','.','G','.','.','.','W'},
            {'W','.','W','@','.','T','@','W','.','W'},
            {'W','.','W','.','.','W','@','W','.','W'},
            {'W','.','W','.','T','W','@','W','.','W'},
            {'W','.','.','.','T','W','W','W','.','W'},
            {'W','.','W','.','T','W','W','W','.','W'},
            {'W','.','W','.','.','W','W','W','.','W'},
            {'W','.','W','T','.','.','@','.','.','W'},
            {'W','.','.','.','.','W','W','W','.','W'},    
        };
        char[][] pathMap = {
            {'W','S','W','W','W','W','W','W','W','W'},
            {'W','p','W','.','p','G','.','.','.','W'},
            {'W','p','W','@','p','T','@','W','.','W'},
            {'W','p','W','p','p','W','@','W','.','W'},
            {'W','p','W','p','T','W','@','W','.','W'},
            {'W','p','p','p','T','W','W','W','.','W'},
            {'W','.','W','.','T','W','W','W','.','W'},
            {'W','.','W','.','.','W','W','W','.','W'},
            {'W','.','W','T','.','.','@','.','.','W'},
            {'W','.','.','.','.','W','W','W','.','W'},    
        };
        Position start = new Position(0,1);
        Position goal = new Position(1,5);
        astar = new Astar(map, start, goal);
        astar.search();
        assertArrayEquals(pathMap, astar.getMap());
    }
}
