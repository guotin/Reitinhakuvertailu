package application.domain;

import application.datastructures.Position;
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
    
    @Test
    public void readTestPosArrayMatchesReal() {
        Position[] testPositions = reader.readTestPos("map1_pos.txt");
        Position[] wantedPositions = new Position[16];
        wantedPositions[0] = new Position(208,81);
        wantedPositions[1] = new Position(194,100);
        wantedPositions[2] = new Position(183,114);
        wantedPositions[3] = new Position(164,144);
        wantedPositions[4] = new Position(234,57);
        wantedPositions[5] = new Position(94,185);
        wantedPositions[6] = new Position(343,119);
        wantedPositions[7] = new Position(242,305);
        wantedPositions[8] = new Position(417,187);
        wantedPositions[9] = new Position(433,245);
        wantedPositions[10] = new Position(486,270);
        wantedPositions[11] = new Position(475,354);
        wantedPositions[12] = new Position(294,245);
        wantedPositions[13] = new Position(291,449);
        wantedPositions[14] = new Position(291,84);
        wantedPositions[15] = new Position(431,414);
        for (int i = 0; i < 16; i++) {
            Position test = testPositions[i];
            Position read = wantedPositions[i];
            assertEquals(test.getX(), read.getX());
            assertEquals(test.getY(), read.getY());
        }
    }
    
}
