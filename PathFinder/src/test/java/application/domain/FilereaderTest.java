package application.domain;

import java.io.FileNotFoundException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class FilereaderTest {
    
    Filereader reader;
    
    @Before
    public void setUp() {
        reader = new Filereader();
    }
    
    @Test
    public void readFileMatchesRealMap1() {
        char[][] readMap = reader.readFile("testmap1.map", 2, 6);
        char[][] map = {
            {'S','.','.','.','.','@'},
            {'.','.','T','.','.','G'},        
        };
        assertArrayEquals(readMap, map);
    }
    
    @Test
    public void readFileMatchesRealMap2() {
        char[][] readMap = reader.readFile("testmap2.map", 10, 10);
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
        assertArrayEquals(readMap, map);
    }
    
}
