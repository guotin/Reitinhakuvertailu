
package application.algorithms;

import application.datastructures.Position;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DepthFirstSearchTest {
    
    DepthFirstSearch dfs;
    
    
    @Test
    public void goalIsFoundFromStart1() {
        char[][] map = {
            {'.','.','.','.','.','W'},
            {'.','.','W','W','.','W'},
            {'W','.','W','W','.','S'},
            {'W','.','.','W','.','W'},
            {'W','W','.','W','W','W'},
            {'W','W','.','.','.','G'},
        };
        Position start = new Position(2,5);
        Position goal = new Position(5,5);
        dfs = new DepthFirstSearch(map, start, goal);
        dfs.search();
        assertTrue(dfs.isFound());
    }
    
    @Test
    public void goalIsFoundFromStart2() {
        char[][] map = {
            {'S','.','.','.','.','W'},
            {'.','.','W','W','.','G'},        
        };
        Position start = new Position(0,0);
        Position goal = new Position(1,5);
        dfs = new DepthFirstSearch(map, start, goal);
        dfs.search();
        assertTrue(dfs.isFound());
    }
    
    @Test
    public void goalIsFoundFromStart3() {
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
        Position start = new Position(0,1);
        Position goal = new Position(8,6);
        dfs = new DepthFirstSearch(map, start, goal);
        dfs.search();
        assertTrue(dfs.isFound());
    }
    
    @Test
    public void goalIsNotFoundIfNotExist1() {
        char[][] map = {
            {'.','.','.','.','.','W'},
            {'.','.','W','W','.','W'},
            {'W','.','W','W','.','S'},
            {'W','.','.','W','.','W'},
            {'W','W','.','W','W','W'},
            {'W','W','.','.','W','G'},
        };
        Position start = new Position(2,5);
        Position goal = new Position(5,5);
        dfs = new DepthFirstSearch(map, start, goal);
        dfs.search();
        assertFalse(dfs.isFound());
    }
    
    @Test
    public void goalIsNotFoundIfNotExist2() {
        char[][] map = {
            {'S','W','.','.','.','W'},
            {'.','.','W','W','.','G'},        
        };
        Position start = new Position(0,0);
        Position goal = new Position(1,5);
        dfs = new DepthFirstSearch(map, start, goal);
        dfs.search();
        assertFalse(dfs.isFound());
    }
    
    @Test
    public void goalIsNotFoundIfNotExist3() {
        char[][] map = {
            {'W','S','W','W','W','W','W','W','W','W'},
            {'W','.','W','.','.','.','.','.','.','W'},
            {'W','.','W','W','.','W','W','W','.','W'},
            {'W','.','W','.','.','W','W','W','.','W'},
            {'W','.','W','W','W','W','W','W','.','W'},
            {'W','.','W','.','W','W','W','W','.','W'},
            {'W','.','W','.','W','W','W','W','.','W'},
            {'W','.','W','.','.','W','W','W','.','W'},
            {'W','.','W','W','.','W','G','.','.','W'},
            {'W','.','.','.','.','W','W','W','.','W'},
        
        };
        Position start = new Position(0,1);
        Position goal = new Position(8,6);
        dfs = new DepthFirstSearch(map, start, goal);
        dfs.search();
        assertFalse(dfs.isFound());
    }
    

}
