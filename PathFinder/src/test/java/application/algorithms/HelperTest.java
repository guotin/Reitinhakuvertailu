package application.algorithms;

import application.datastructures.Position;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class HelperTest {
    
    private Helper helper;
    private char[][] map;
    
    @Before
    public void setUp() {
        char[][] map = {
            {'T','.','.','.','.','W'},
            {'T','.','W','@','.','W'},
            {'W','.','W','@','.','S'},
            {'W','.','T','W','.','W'},
            {'W','.','.','W','W','W'},
            {'W','W','.','.','.','G'},
        };
        this.map = map;
        this.helper = new Helper(map);
    }
    
    @Test
    public void helperGeneratesCorrectNeighbours() {
        Position testPos = new Position(0,1);
        Position[] neighbours = helper.generateNeighbours(testPos);
        Position down = neighbours[0];
        Position up = neighbours[1];
        Position right = neighbours[2];
        Position left = neighbours[3];
        
        assertEquals(1, down.getX());
        assertEquals(1, down.getY());
        
        assertEquals(-1, up.getX());
        assertEquals(-1, up.getY());
        
        assertEquals(0, right.getX());
        assertEquals(2, right.getY());
        
        assertEquals(-1, left.getX());
        assertEquals(-1, left.getY());
    }
    
}
